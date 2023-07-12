package com.sunpower.repository;

import com.sunpower.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, String> {
     List<Transaction> findAllByCustomer_Id(String id);
}
