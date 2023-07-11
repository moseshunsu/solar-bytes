package com.sunpower.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SolarPanelRequest {
    private String name;
    private String ratingVoltage;
    private String ratingWattage;
    private String productWarranty;
    private double amount;
}
