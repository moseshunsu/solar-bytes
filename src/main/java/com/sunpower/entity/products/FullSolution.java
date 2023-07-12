package com.sunpower.entity.products;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "full_solution")
public class FullSolution {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String src;
    @Column(length = 1500)
    private String specifications;
    @Column(length = 1500)
    private String poweringLoads;
    private double amount;
}
