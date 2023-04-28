package com.petproject.medicine.service.impl;

import com.petproject.medicine.dependecies.dao.MedicineDao;
import com.petproject.medicine.service.MedicineService;
import com.petproject.medicine.service.mapper.MedicineServiceModelMapper;
import com.petproject.medicine.service.output.MedicineServiceModel;
import org.springframework.stereotype.Service;

@Service
public class MedicineServiceImpl implements MedicineService {
    private final MedicineDao medicineDao;

    public MedicineServiceImpl(MedicineDao medicineDao) {
        this.medicineDao = medicineDao;
    }

    @Override
    public MedicineServiceModel save(MedicineServiceModel medicine) {
        return MedicineServiceModelMapper.mapToDto(
                medicineDao.save(MedicineServiceModelMapper.mapToModel(medicine)));
    }

//    @Override
//    public List<Medicine> getAllInLast14Days() {
//        return medicineDao.findAllByCreatedAt();
//    }
//
//    @Override
//    public void deleteAllTwoWeeksOlder() {
//        medicineDao.findAllByCreatedAtBefore()
//                .forEach(medicine -> {
//                    medicine.setDeleted(true);
//                    medicineDao.save(medicine);
//                });
//    }
}
