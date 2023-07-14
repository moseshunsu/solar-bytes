package com.sunpower.service.impl;

import com.sunpower.dto.Data;
import com.sunpower.dto.Response;
import com.sunpower.dto.UserRequest;
import com.sunpower.email.dto.EmailDetails;
import com.sunpower.email.service.EmailService;
import com.sunpower.entity.User;
import com.sunpower.repository.UserRepo;
import com.sunpower.service.UserService;
import com.sunpower.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;


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
                .controllerNumber(ResponseUtils.generateControllerNumber(7))
                .fullName(userRequest.getFullName())
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .role("ROLE_CUSTOMER")
                .username(userRequest.getUsername())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .build();

        User savedCustomer = userRepo.save(customer);

        EmailDetails emailDetails = EmailDetails.builder()
                .subject("SUN POWER ACCOUNT DETAILS")
                .recipient(savedCustomer.getEmail())
                .messageBody(
                        "Dear " + savedCustomer.getFullName().toUpperCase() + ", your account with Sun Power has " +
                                "been successful created. Your  Controller No. is " +
                                savedCustomer.getControllerNumber() + "." +
                                "\n\nOur engineers will get in touch with you shortly to know what suits you " +
                                "best. Subsequently, kindly login with your username or email to purchase solar units" +
                                "\n\n\nBest Regards, \nSun Power\nIlluminating the world."
                )
                .build();

        emailService.sendSimpleMail(emailDetails);

        return ResponseEntity.status(HttpStatus.CREATED).body(Response.builder()
                .responseCode(ResponseUtils.USER_SUCCESS_CODE)
                .responseMessage(ResponseUtils.CUSTOMER_SUCCESS_MESSAGE)
                .data(Data.builder()
                        .customerName(savedCustomer.getFullName())
                        .controllerNumber(savedCustomer.getControllerNumber())
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
                .controllerNumber(ResponseUtils.generateControllerNumber(7))
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
                        .controllerNumber(savedAdmin.getControllerNumber())
                        .build())
                .build());

    }


    @Override
    public List<Response> allUsers() {
        List<User> usersList = userRepo.findAll();

        List<Response> response = new ArrayList<>();

        usersList.stream().map(user -> {
            response.add(Response.builder()
                            .responseCode(ResponseUtils.USER_EXISTS_CODE)
                            .data(Data.builder()
                                    .customerName(user.getFullName())
                                    .controllerNumber(user.getControllerNumber())
                                    .build())
                    .build());
            return response;
        }).collect(Collectors.toList());
        return response;

//        for (User user: usersList) {
//            response.add(Response.builder()
//                    .responseCode(ResponseUtils.SUCCESS)
//                    .responseMessage(ResponseUtils.SUCCESS_MESSAGE)
//                    .data(Data.builder()
//                            .accountNumber(user.getAccountNumber())
//                            .accountBalance(user.getAccountBalance())
//                            .accountName(user.getFirstName() + " " + user.getLastName())
//                            .build())
//                    .build());
//        }
//        return response;
    }


}
