package com.petproject.medicine.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MedicineRequestDto {
    private String name;
    private String manufacturer;
    private LocalDate manufacturedDate;
    private LocalDate expiringDate;
}
