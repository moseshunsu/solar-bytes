package com.sunpower.service.impl;

import com.sunpower.dto.CustomerRequest;
import com.sunpower.dto.Data;
import com.sunpower.dto.Response;
import com.sunpower.entity.Customer;
import com.sunpower.repository.CustomerRepo;
import com.sunpower.service.CustomerServ;
import com.sunpower.utils.ResponseUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServImpl implements CustomerServ {

    private final CustomerRepo customerRepo;

    public CustomerServImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Response registerCustomer(CustomerRequest customerRequest) {

        boolean isCustomerExists = customerRepo.existsByEmailOrPhoneNumber(customerRequest.getEmail(),
                customerRequest.getPhoneNumber());

        if (isCustomerExists) {
            return Response.builder()
                    .responseCode(ResponseUtils.USER_EXISTS_CODE)
                    .responseMessage(ResponseUtils.USER_EXISTS_MESSAGE)
                    .build();
        }

        if (!customerRequest.getPassword().equals(customerRequest.getConfirmPassword())) {
            return Response.builder()
                    .responseCode(ResponseUtils.PASSWORD_MISMATCH_CODE)
                    .responseMessage(ResponseUtils.PASSWORD_MISMATCH_MESSAGE)
                    .build();
        }

        Customer customer =Customer.builder()
                .id(ResponseUtils.generateMeterNumber(7))
                .fullName(customerRequest.getFullName())
                .email(customerRequest.getEmail())
                .phoneNumber(customerRequest.getPhoneNumber())
                .password(customerRequest.getPassword())
                .build();

        Customer savedCustomer = customerRepo.save(customer);

        return Response.builder()
                .responseCode(ResponseUtils.SUCCESS)
                .responseMessage(ResponseUtils.USER_SUCCESS_MESSAGE)
                .data(Data.builder()
                        .customerName(savedCustomer.getFullName())
                        .meterNumber(savedCustomer.getId())
                        .build())
                .build();

    }

}
