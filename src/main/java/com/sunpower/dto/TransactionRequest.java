package com.sunpower.dto;

import com.sunpower.entity.Customer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Setter
@Getter
public class TransactionRequest {
    private BigDecimal amount;
    private String units;
    private String meterNumber;
}
