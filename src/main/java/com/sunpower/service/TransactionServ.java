package com.sunpower.service;

import com.sunpower.dto.Response;
import com.sunpower.dto.TransactionRequest;

public interface TransactionServ {
    Response saveTransaction(TransactionRequest transactionRequest) throws Exception;
}
