package com.sunpower.service.impl;

import com.sunpower.dto.Data;
import com.sunpower.dto.Response;
import com.sunpower.dto.TransactionRequest;
import com.sunpower.entity.Transaction;
import com.sunpower.repository.CustomerRepo;
import com.sunpower.repository.TransactionRepo;
import com.sunpower.service.TransactionServ;
import com.sunpower.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServImpl implements TransactionServ {

    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private CustomerRepo customerRepo;

//    public TransactionServImpl(TransactionRepo transactionRepo) {
//        this.transactionRepo = transactionRepo;
//    }

    @Override
    public Response saveTransaction(TransactionRequest transactionRequest) throws Exception {

        boolean isMeterNumberExists = customerRepo.existsById(transactionRequest.getMeterNumber());
//
//        if (!isMeterNumberExists) {
//            return Response.builder()
//                    .responseMessage(ResponseUtils.INVALID_METER_CODE)
//                    .responseMessage(ResponseUtils.INVALID_METER_MESSAGE)
//                    .build();
//        }

        Transaction transaction = Transaction.builder()
                .units(transactionRequest.getUnits())
                .amount(transactionRequest.getAmount())
                .customer(customerRepo.findById(transactionRequest.getMeterNumber()).orElseThrow(() ->
                        new RuntimeException(String.valueOf(new Response(ResponseUtils.INVALID_METER_CODE,
                                ResponseUtils.INVALID_METER_MESSAGE,
                                new Data(transactionRequest.getMeterNumber(), null,
                                        transactionRequest.getUnits()))))))
                .build();

        Transaction savedTransaction = transactionRepo.save(transaction);

        return Response.builder()
                .responseCode(ResponseUtils.TRANSACTION_SUCCESS_CODE)
                .responseMessage(ResponseUtils.TRANSACTION_SUCCESS_MESSAGE)
                .build();
    }

}
