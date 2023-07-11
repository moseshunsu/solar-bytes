package com.sunpower.repository.ProductsRepo;

import com.sunpower.entity.products.MountingStructure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MountingStructureRepo extends JpaRepository<MountingStructure, Long> {
    Boolean existsByModel(String model);
}
