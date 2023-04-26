package com.petproject.medicine.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String manufacturer;
    private LocalDate manufacturedDate;
    private LocalDate expiringDate;
    @ColumnDefault("false")
    private boolean verified;
    @CreationTimestamp
    private LocalDate createdAt;
    @ColumnDefault("false")
    private boolean deleted;
}
