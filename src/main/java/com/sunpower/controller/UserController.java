package com.sunpower.controller;

import com.sunpower.dto.Response;
import com.sunpower.dto.UserRequest;
import com.sunpower.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register-customer")
    public ResponseEntity<Response> registerCustomer(@RequestBody UserRequest userRequest) {
        return userService.registerCustomer(userRequest);
    }

    @PostMapping("/register-admin")
    public ResponseEntity<Response> registerAdmin(@RequestBody UserRequest userRequest) {
        return userService.registerAdmin(userRequest);
    }

}
