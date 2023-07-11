package com.sunpower.repository;

import com.sunpower.entity.SolarUnits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolarUnitsRepo extends JpaRepository<SolarUnits, Long> {
    boolean existsByUnits (String units);
}
