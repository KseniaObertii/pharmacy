package com.petproject.medicine.controller.restapi.output;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MedicineResponseDto {
    private Long id;
    private String name;
    private String manufacturer;
    private LocalDate manufacturedDate;
    private LocalDate expiringDate;
    private boolean verified;
    private LocalDate createdAt;
    private boolean deleted;
}
