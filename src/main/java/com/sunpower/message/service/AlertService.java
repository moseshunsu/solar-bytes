package com.sunpower.message.service;

import com.sunpower.message.domain.AlertMessage;
import com.sunpower.message.domain.Recipient;

public interface AlertService {

    void sendSMS(Recipient recipient, AlertMessage alertMessage);

}
