package com.sunpower.ProductRepo;

import com.sunpower.Products.Battery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatteryRepo extends JpaRepository<Battery, Long> {
    Boolean existsByName (String name);
}
