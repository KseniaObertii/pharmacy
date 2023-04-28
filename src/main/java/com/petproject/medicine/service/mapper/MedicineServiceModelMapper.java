package com.petproject.medicine.service.mapper;

import com.petproject.medicine.dependecies.dao.output.Medicine;
import com.petproject.medicine.service.output.MedicineServiceModel;

public class MedicineServiceModelMapper {
    public static Medicine mapToModel(MedicineServiceModel dto) {
        return Medicine.builder()
                .id(dto.getId())
                .name(dto.getName())
                .createdAt(dto.getCreatedAt())
                .manufacturer(dto.getManufacturer())
                .manufacturedDate(dto.getManufacturedDate())
                .expiringDate(dto.getExpiringDate())
                .deleted(dto.isDeleted())
                .verified(dto.isVerified())
                .build();
    }

    public static MedicineServiceModel mapToDto(Medicine medicine) {
        return MedicineServiceModel.builder()
                .id(medicine.getId())
                .name(medicine.getName())
                .createdAt(medicine.getCreatedAt())
                .manufacturer(medicine.getManufacturer())
                .manufacturedDate(medicine.getManufacturedDate())
                .expiringDate(medicine.getExpiringDate())
                .deleted(medicine.isDeleted())
                .verified(medicine.isVerified())
                .build();
    }
}
