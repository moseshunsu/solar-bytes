package com.sunpower.dto.productsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SolarUnitsRequest {
    private BigDecimal amount;
    private String units;
    private String description;
}
