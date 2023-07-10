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
    private String componentPower;
    private String componentEfficiency;
    private String productWarranty;
    private String powerWarranty;
}
