package com.petproject.medicine.util;

import com.petproject.medicine.service.MedicineService;
import com.petproject.medicine.service.output.MedicineServiceModel;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer {
    private final MedicineService medicineService;

    public DataInitializer(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @PostConstruct
    public void inject() {
        MedicineServiceModel eyeDrops = MedicineServiceModel.builder()
                .id(1L)
                .createdAt(LocalDate.now())
                .manufacturer("Alcon")
                .manufacturedDate(LocalDate.parse("2020-12-03"))
                .expiringDate(LocalDate.parse("2024-12-03"))
                .name("Eye drops").build();
        MedicineServiceModel birthControlPills = MedicineServiceModel.builder()
                .id(2L)
                .createdAt(LocalDate.now().minusDays(16))
                .manufacturer("Alizena")
                .manufacturedDate(LocalDate.parse("2020-12-03"))
                .expiringDate(LocalDate.parse("2024-12-03"))
                .name("Birth Control Pills").build();
        medicineService.save(eyeDrops);
        medicineService.save(birthControlPills);
    }
}
