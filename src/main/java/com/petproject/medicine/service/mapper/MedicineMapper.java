package com.petproject.medicine.service.mapper;

import com.petproject.medicine.dto.MedicineRequestDto;
import com.petproject.medicine.dto.MedicineResponseDto;
import com.petproject.medicine.model.Medicine;
import org.springframework.stereotype.Component;

@Component
public class MedicineMapper implements ResponseDtoMapper<MedicineResponseDto, Medicine>,
        RequestDtoMapper<MedicineRequestDto, Medicine> {
    @Override
    public MedicineResponseDto mapToDto(Medicine medicine) {
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

    @Override
    public Medicine mapToModel(MedicineRequestDto dto) {
        Medicine medicine = new Medicine();
        medicine.setName(dto.getName());
        medicine.setManufacturer(dto.getManufacturer());
        medicine.setManufacturedDate(dto.getManufacturedDate());
        medicine.setExpiringDate(dto.getExpiringDate());
        return medicine;
    }
}
