package com.sunpower.ProductSevice;

import com.sunpower.ProductDto.BatteryRequest;
import com.sunpower.dto.Response;
import org.springframework.http.ResponseEntity;

public interface BatteryServ {
    ResponseEntity<Response> registerBattery(BatteryRequest batteryRequest);
}
