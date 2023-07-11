package com.sunpower.repository.ProductsRepo;

import com.sunpower.entity.products.SolarPanels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolarRepo extends JpaRepository<SolarPanels, Long> {
    Boolean existsByName(String name);
}
