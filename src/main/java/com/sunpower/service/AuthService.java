package com.sunpower.service;

import com.sunpower.controller.AuthResponse;
import com.sunpower.dto.LoginDto;

public interface AuthService {
    AuthResponse login(LoginDto loginDto);
}
