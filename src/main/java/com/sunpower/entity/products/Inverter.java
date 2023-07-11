package com.sunpower.entity.products;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "Inverter")
public class Inverter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String batteryVoltageRange;
    private String componentEfficiency;
    private String productWarranty;
    private double amount;
}
