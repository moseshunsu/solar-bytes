package com.sunpower.service;

import com.sunpower.dto.Response;
import com.sunpower.dto.UserRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<Response> registerCustomer(UserRequest userRequest);
    ResponseEntity<Response> registerAdmin(UserRequest userRequest);
    List<Response> allUsers();
}
