package com.sunpower.repository.ProductsRepo;

import com.sunpower.entity.products.SolarUnits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolarUnitsRepo extends JpaRepository<SolarUnits, Long> {
    boolean existsByUnits (String units);
}
