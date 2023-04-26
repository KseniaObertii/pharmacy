package com.petproject.medicine.service;

import com.petproject.medicine.model.Medicine;

import java.util.List;

public interface MedicineService {
    Medicine save(Medicine medicine);

    List<Medicine> getAllInLast14Days();

    void deleteAllTwoWeeksOlder();
}
