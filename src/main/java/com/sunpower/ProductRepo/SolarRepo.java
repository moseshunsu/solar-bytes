package com.sunpower.ProductRepo;

import com.sunpower.Products.SolarPanels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolarRepo extends JpaRepository<SolarPanels, Long> {
    Boolean existsByName(String name);
}
