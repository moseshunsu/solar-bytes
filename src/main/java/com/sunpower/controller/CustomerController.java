package com.sunpower.controller;

import com.sunpower.dto.CustomerRequest;
import com.sunpower.dto.Response;
import com.sunpower.service.CustomerServ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerServ customerServ;

    public CustomerController(CustomerServ customerServ) {
        this.customerServ = customerServ;
    }

    @PostMapping
    public ResponseEntity<Response> registerCustomer(@RequestBody CustomerRequest customerRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerServ.registerCustomer(customerRequest));
    }

}
