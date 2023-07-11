package com.sunpower.Products;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "Full_Solution")
public class FullSolution {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(length = 1500)
    private String specifications;
    @Column(length = 1500)
    private String poweringLoads;
    private double amount;
}
