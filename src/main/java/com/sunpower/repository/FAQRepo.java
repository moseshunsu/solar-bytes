package com.sunpower.repository;

import com.sunpower.entity.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FAQRepo extends JpaRepository<FAQ, String> {
}
