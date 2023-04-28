package com.petproject.medicine.controller.restapi.mapper;

import com.petproject.medicine.controller.restapi.input.MedicineRequestDto;
import com.petproject.medicine.controller.restapi.output.MedicineResponseDto;
import com.petproject.medicine.dependecies.dao.output.Medicine;
import org.springframework.stereotype.Component;

@Component
public class MedicineMapper {
    public static MedicineResponseDto mapToDto(Medicine medicine) {
        MedicineResponseDto medicineResponseDto = new MedicineResponseDto();
        medicineResponseDto.setId(medicine.getId());
        medicineResponseDto.setCreatedAt(medicine.getCreatedAt());
        medicineResponseDto.setManufacturer(medicine.getManufacturer());
        medicineResponseDto.setName(medicine.getName());
        medicineResponseDto.setManufacturedDate(medicine.getManufacturedDate());
        medicineResponseDto.setExpiringDate(medicine.getExpiringDate());
        medicineResponseDto.setVerified(medicine.isVerified());
        medicineResponseDto.setDeleted(medicine.isDeleted());
        return medicineResponseDto;
    }
    public static Medicine mapToModel(MedicineRequestDto dto) {
        Medicine medicine = new Medicine();
        medicine.setName(dto.getName());
        medicine.setManufacturer(dto.getManufacturer());
        medicine.setManufacturedDate(dto.getManufacturedDate());
        medicine.setExpiringDate(dto.getExpiringDate());
        return medicine;
    }
}
