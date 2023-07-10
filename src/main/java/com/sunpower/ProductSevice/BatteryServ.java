package com.sunpower.ProductSevice;

import com.sunpower.ProductDto.BatteryRequest;
import com.sunpower.ProductResponse.Response;

public interface BatteryServ {
    Response registerBattery(BatteryRequest batteryRequest);
}
