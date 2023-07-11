package com.sunpower.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class InverterRequest {
    private String name;
    private String batteryVoltageRange;
    private String componentEfficiency;
    private String productWarranty;
    private double amount;
}
