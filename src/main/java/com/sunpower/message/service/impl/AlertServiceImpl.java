package com.sunpower.message.service.impl;

import com.sunpower.message.domain.AlertMessage;
import com.sunpower.message.domain.Recipient;
import com.sunpower.message.service.AlertService;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AlertServiceImpl implements AlertService {

    @Value("${twilio.phone.number}")
    private String phoneNumber;

    @Override
    public void sendSMS(Recipient recipient, AlertMessage alertMessage) {
        Message.creator(new PhoneNumber(recipient.getPhoneNumber()), new PhoneNumber(phoneNumber),
                        alertMessage.getMessage())
                .create();
    }
}
