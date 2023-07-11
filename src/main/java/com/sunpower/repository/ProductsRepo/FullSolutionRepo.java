package com.sunpower.repository.ProductsRepo;

import com.sunpower.entity.products.FullSolution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FullSolutionRepo extends JpaRepository<FullSolution, Long> {
    Boolean existsByName(String name);
}
