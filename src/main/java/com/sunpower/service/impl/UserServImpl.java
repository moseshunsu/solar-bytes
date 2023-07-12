package com.sunpower.service.impl;

import com.sunpower.dto.Data;
import com.sunpower.dto.Response;
import com.sunpower.dto.UserRequest;
import com.sunpower.entity.User;
import com.sunpower.repository.UserRepo;
import com.sunpower.service.UserService;
import com.sunpower.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public ResponseEntity<Response> registerCustomer(UserRequest userRequest) {

        boolean isCustomerExists = userRepo.existsByEmailOrPhoneNumber(userRequest.getEmail(),
                userRequest.getPhoneNumber());

        if (isCustomerExists) {
            return ResponseEntity.badRequest().body(Response.builder()
                    .responseCode(ResponseUtils.USER_EXISTS_CODE)
                    .responseMessage(ResponseUtils.USER_EXISTS_MESSAGE)
                    .build());
        }

        if (!userRequest.getPassword().equals(userRequest.getConfirmPassword())) {
            return ResponseEntity.badRequest().body(Response.builder()
                    .responseCode(ResponseUtils.PASSWORD_MISMATCH_CODE)
                    .responseMessage(ResponseUtils.PASSWORD_MISMATCH_MESSAGE)
                    .build());
        }

        User customer = User.builder()
                .meterNumber(ResponseUtils.generateMeterNumber(7))
                .fullName(userRequest.getFullName())
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .role("ROLE_CUSTOMER")
                .username(userRequest.getUsername())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .build();

        User savedCustomer = userRepo.save(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(Response.builder()
                .responseCode(ResponseUtils.USER_SUCCESS_CODE)
                .responseMessage(ResponseUtils.CUSTOMER_SUCCESS_MESSAGE)
                .data(Data.builder()
                        .customerName(savedCustomer.getFullName())
                        .meterNumber(savedCustomer.getMeterNumber())
                        .build())
                .build());

    }

    @Override
    public ResponseEntity<Response> registerAdmin(UserRequest userRequest) {

        boolean isAdminExists = userRepo.existsByEmailOrPhoneNumber(userRequest.getEmail(),
                userRequest.getPhoneNumber());

        if (isAdminExists) {
            return ResponseEntity.badRequest().body(Response.builder()
                    .responseCode(ResponseUtils.USER_EXISTS_CODE)
                    .responseMessage(ResponseUtils.USER_EXISTS_MESSAGE)
                    .build());
        }

        if (!userRequest.getPassword().equals(userRequest.getConfirmPassword())) {
            return ResponseEntity.badRequest().body(Response.builder()
                    .responseCode(ResponseUtils.PASSWORD_MISMATCH_CODE)
                    .responseMessage(ResponseUtils.PASSWORD_MISMATCH_MESSAGE)
                    .build());
        }

        User admin = User.builder()
                .meterNumber(ResponseUtils.generateMeterNumber(7))
                .fullName(userRequest.getFullName())
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .role("ROLE_ADMIN")
                .username(userRequest.getUsername())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .build();

        User savedAdmin = userRepo.save(admin);

        return ResponseEntity.status(HttpStatus.CREATED).body(Response.builder()
                .responseCode(ResponseUtils.USER_SUCCESS_CODE)
                .responseMessage(ResponseUtils.ADMIN_SUCCESS_MESSAGE)
                .data(Data.builder()
                        .customerName(savedAdmin.getFullName())
                        .meterNumber(savedAdmin.getMeterNumber())
                        .build())
                .build());

    }

}
