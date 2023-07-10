package com.sunpower.ProductDto;

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
    private String componentPower;
    private String componentEfficiency;
    private String productWarranty;
}
