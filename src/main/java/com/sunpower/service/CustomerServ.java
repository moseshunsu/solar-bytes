package com.sunpower.service;

import com.sunpower.dto.CustomerRequest;
import com.sunpower.dto.Response;
import org.springframework.http.ResponseEntity;

public interface CustomerServ {
    ResponseEntity<Response> registerCustomer(CustomerRequest customerRequest);
}
