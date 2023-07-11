package com.sunpower.repository;

import com.sunpower.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, String> {

    boolean existsByEmailOrPhoneNumber(String email, String phoneNumber);
    Optional<Customer> findByUsernameOrEmail(String username, String email);

}
