package com.sunpower.entity.products;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "Battery")
public class Battery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String src;
    private String workingVoltage;
    private String standardVoltage;
    private String productWarranty;
    private double amount;
}
