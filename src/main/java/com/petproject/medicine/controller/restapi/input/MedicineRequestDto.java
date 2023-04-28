package com.petproject.medicine.controller.restapi.input;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MedicineRequestDto {
    private String name;
    private String manufacturer;
    private LocalDate manufacturedDate;
    private LocalDate expiringDate;
}
