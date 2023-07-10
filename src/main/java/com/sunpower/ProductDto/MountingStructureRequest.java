package com.sunpower.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MountingStructureRequest {
    private String model;
    private String material;
    private String warranty;
    private String serviceLife;
}
