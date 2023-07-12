package com.sunpower.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String fullName;
    private String email;
    private String phoneNumber;
    private String password;
    private String confirmPassword;
    private String username;

}
