package com.sunpower.repository.ProductsRepo;

import com.sunpower.entity.products.Inverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InverterRepo extends JpaRepository<Inverter, Long> {
    Boolean existsByName(String name);
}
