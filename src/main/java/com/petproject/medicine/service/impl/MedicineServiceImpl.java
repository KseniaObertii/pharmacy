package com.petproject.medicine.service.impl;

import com.petproject.medicine.dao.MedicineDao;
import com.petproject.medicine.model.Medicine;
import com.petproject.medicine.service.MedicineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {
    private final MedicineDao medicineDao;

    public MedicineServiceImpl(MedicineDao medicineDao) {
        this.medicineDao = medicineDao;
    }

    @Override
    public Medicine save(Medicine medicine) {
        return medicineDao.save(medicine);
    }

    @Override
    public List<Medicine> getAllInLast14Days() {
        return medicineDao.findAllByCreatedAt();
    }

    @Override
    public void deleteAllTwoWeeksOlder() {
        medicineDao.findAllByCreatedAtBefore()
                .forEach(medicine -> {
                    medicine.setDeleted(true);
                    medicineDao.save(medicine);
                });
    }
}
