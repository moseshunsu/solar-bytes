package com.sunpower.service;

import com.sunpower.dto.Response;
import com.sunpower.dto.TransactionRequest;
import org.springframework.http.ResponseEntity;

public interface TransactionServ {
    ResponseEntity<Response> saveTransaction(TransactionRequest transactionRequest) throws Exception;
}
