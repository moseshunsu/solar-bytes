package com.sunpower.repository;

import com.sunpower.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, String> {
    Optional<User> findByControllerNumber(String controllerNumber);
    boolean existsByEmailOrPhoneNumber(String email, String phoneNumber);
    Optional<User> findByUsernameOrEmail(String username, String email);

}
