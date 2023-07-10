package com.sunpower.ProductRepo;

import com.sunpower.Products.Inverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InverterRepo extends JpaRepository<Inverter, Long> {
    Boolean existsByName(String name);
}
