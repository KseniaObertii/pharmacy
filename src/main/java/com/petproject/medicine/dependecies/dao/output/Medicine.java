package com.petproject.medicine.dependecies.dao.output;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
