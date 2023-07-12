package com.sunpower.service.impl;

import com.sunpower.dto.Data;
import com.sunpower.dto.Response;
import com.sunpower.dto.TransactionRequest;
import com.sunpower.entity.Transaction;
import com.sunpower.repository.TransactionRepo;
import com.sunpower.repository.UserRepo;
import com.sunpower.service.TransactionServ;
import com.sunpower.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TransactionServImpl implements TransactionServ {

    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public ResponseEntity<Response> saveTransaction(TransactionRequest transactionRequest) throws Exception {

        boolean isMeterNumberExists = userRepo.existsById(transactionRequest.getMeterNumber());

        Transaction transaction = Transaction.builder()
                .units(transactionRequest.getUnits())
                .amount(transactionRequest.getAmount())
                .user(userRepo.findById(transactionRequest.getMeterNumber()).orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                String.valueOf(new Response(ResponseUtils.INVALID_METER_CODE,
                                ResponseUtils.INVALID_METER_MESSAGE,
                                new Data(transactionRequest.getMeterNumber(), null,
                                        transactionRequest.getUnits()))))))
                .build();

        Transaction savedTransaction = transactionRepo.save(transaction);

        return ResponseEntity.ok(Response.builder()
                .responseCode(ResponseUtils.TRANSACTION_SUCCESS_CODE)
                .responseMessage(ResponseUtils.TRANSACTION_SUCCESS_MESSAGE)
                .build());
    }
}
