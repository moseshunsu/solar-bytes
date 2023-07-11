package com.sunpower.dto.productsDto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FullSolutionRequest {
    private String name;
    private String specifications;
    private String poweringLoads;
    private double amount;
}
