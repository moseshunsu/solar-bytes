package com.sunpower.service.impl;

import com.sunpower.controller.AuthResponse;
import com.sunpower.dto.LoginDto;
import com.sunpower.filter.JwtTokenProvider;
import com.sunpower.repository.UserRepo;
import com.sunpower.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public AuthResponse login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(jwtTokenProvider.generateToken(authentication));

        String controllerNumber =
                userRepo.findByUsernameOrEmail(loginDto.getUsername(), loginDto.getUsername()).get().getControllerNumber();
        String email = userRepo.findByUsernameOrEmail(loginDto.getUsername(), loginDto.getUsername()).get().getEmail();
        authResponse.setControllerNumber(controllerNumber);
        authResponse.setEmail(email);

        return authResponse;
    }

}
