package com.sunpower.repository;

import com.sunpower.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
    boolean existsByUnits (String units);
}
