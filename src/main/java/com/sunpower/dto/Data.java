package com.sunpower.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@lombok.Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Data {
    private String controllerNumber;
    private String customerName;
    private String units;
}
