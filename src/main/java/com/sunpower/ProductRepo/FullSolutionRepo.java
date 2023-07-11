package com.sunpower.ProductRepo;

import com.sunpower.Products.FullSolution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FullSolutionRepo extends JpaRepository<FullSolution, Long> {
    Boolean existsByName(String name);
}
