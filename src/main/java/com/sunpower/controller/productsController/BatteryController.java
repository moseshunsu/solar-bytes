package com.sunpower.controller.productsController;

import com.sunpower.dto.productsDto.BatteryRequest;
import com.sunpower.service.productsSevice.BatteryServ;
import com.sunpower.dto.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register-battery")
public class BatteryController {
    private final BatteryServ batteryServ;
    public BatteryController(BatteryServ batteryServ) {
        this.batteryServ = batteryServ;

    }
    @PostMapping
    public ResponseEntity<Response> registerBattery(@RequestBody BatteryRequest batteryRequest) {
        return batteryServ.registerBattery(batteryRequest);

    }
}
