package com.sunpower.Products;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "solar_panel")
public class SolarPanels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String ratingVoltage;
    private String ratingWattage;
    private String productWarranty;
    private double amount;
}
