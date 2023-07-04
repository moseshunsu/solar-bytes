package com.sunpower.service;

import com.sunpower.dto.CustomerRequest;
import com.sunpower.dto.Response;

public interface CustomerServ {
    Response registerCustomer(CustomerRequest customerRequest);
}
