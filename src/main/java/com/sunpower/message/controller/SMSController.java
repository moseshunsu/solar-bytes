package com.sunpower.message.controller;

import com.sunpower.message.domain.AlertMessage;
import com.sunpower.message.domain.Recipient;
import com.sunpower.message.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SMSController {

    @Autowired
    private AlertService alertService;

    @PostMapping("api/sms")
    public void sendSMS(@RequestBody AlertMessage alertMessage) {
        Recipient recipient = new Recipient("...", "...", "+23....");
        alertService.sendSMS(recipient, alertMessage);
    }

}
