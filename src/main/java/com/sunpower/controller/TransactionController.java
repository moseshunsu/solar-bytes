package com.sunpower.controller;

import com.sunpower.dto.Response;
import com.sunpower.dto.TransactionRequest;
import com.sunpower.service.TransactionServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionServ transactionServ;

    @PostMapping
    public ResponseEntity<Response> saveTransaction(@RequestBody TransactionRequest transactionRequest) throws Exception {
        return transactionServ.saveTransaction(transactionRequest);
    }

}
