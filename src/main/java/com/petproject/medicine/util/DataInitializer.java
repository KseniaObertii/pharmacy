package com.petproject.medicine.util;

import com.petproject.medicine.model.Medicine;
import com.petproject.medicine.service.MedicineService;
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
        Medicine eyeDrops = new Medicine();
        eyeDrops.setCreatedAt(LocalDate.now());
        eyeDrops.setManufacturer("Alcon");
        eyeDrops.setManufacturedDate(LocalDate.parse("2020-12-03"));
        eyeDrops.setExpiringDate(LocalDate.parse("2024-12-03"));
        eyeDrops.setName("Eye drops");
        Medicine birthControlPills = new Medicine();
        birthControlPills.setCreatedAt(LocalDate.now().minusDays(16));
        birthControlPills.setManufacturer("Alizena");
        birthControlPills.setManufacturedDate(LocalDate.parse("2020-12-03"));
        birthControlPills.setExpiringDate(LocalDate.parse("2024-12-03"));
        birthControlPills.setName("Birth Control Pills");
        medicineService.save(eyeDrops);
        medicineService.save(birthControlPills);
    }
}
