package com.sunpower.repository.ProductsRepo;

import com.sunpower.entity.products.Battery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatteryRepo extends JpaRepository<Battery, Long> {
    Boolean existsByName (String name);
}
