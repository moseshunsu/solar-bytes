package com.sunpower.entity.products;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "Mounting_Structure")
public class MountingStructure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String src;
    private String material;
    private String warranty;
    private String serviceLife;
    private double amount;
}
