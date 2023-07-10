package com.sunpower.ProductRepo;

import com.sunpower.Products.MountingStructure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MountingStructureRepo extends JpaRepository<MountingStructure, Long> {
    Boolean existsByModel(String model);
}
