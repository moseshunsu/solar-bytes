package com.sunpower.service.productsSevice;

import com.sunpower.dto.productsDto.BatteryRequest;
import com.sunpower.dto.Response;
import org.springframework.http.ResponseEntity;

public interface BatteryServ {
    ResponseEntity<Response> registerBattery(BatteryRequest batteryRequest);
}
