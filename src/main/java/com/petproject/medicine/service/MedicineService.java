package com.petproject.medicine.service;

import com.petproject.medicine.service.output.MedicineServiceModel;

public interface MedicineService {
    MedicineServiceModel save(MedicineServiceModel medicine);

//    List<Medicine> getAllInLast14Days();

//    void deleteAllTwoWeeksOlder();
}
