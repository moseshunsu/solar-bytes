package com.sunpower.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "transaction_id")
    private String transaction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meter_number", referencedColumnName = "meter_number")
    @ToString.Exclude
    private User user;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private String units;

    @CreationTimestamp
    private LocalDateTime dateTime;
}
