package com.sunpower.dto.productsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BatteryRequest {
    private String name;
    private String workingVoltage;
    private String standardVoltage;
    private String productWarranty;
    private double amount;
}
