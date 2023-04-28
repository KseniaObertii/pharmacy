package com.petproject.medicine.service.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicineServiceModel {
    private Long id;
    private String name;
    private String manufacturer;
    private LocalDate manufacturedDate;
    private LocalDate expiringDate;
    private boolean verified;
    private LocalDate createdAt;
    private boolean deleted;
}
