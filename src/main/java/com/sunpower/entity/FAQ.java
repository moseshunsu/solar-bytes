package com.sunpower.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "faq")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FAQ {

    @Id
    @Column(name = "meter_number")
    private String id;

    @Column(nullable = false, unique = true)
    private String question;

    @Column(nullable = false, unique = true, length = 500)
    private String answer;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "last_modified_at")
    private LocalDateTime modifiedAt;

}
