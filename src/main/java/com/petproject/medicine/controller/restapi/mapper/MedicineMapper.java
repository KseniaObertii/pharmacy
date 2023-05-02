package com.petproject.medicine.controller.restapi.mapper;

import com.petproject.medicine.controller.restapi.input.MedicineRequestDto;
import com.petproject.medicine.controller.restapi.output.MedicineResponseDto;
import com.petproject.medicine.dependecies.dao.output.Medicine;
import com.petproject.medicine.service.output.MedicineServiceModel;
import org.springframework.stereotype.Component;

@Component
public class MedicineMapper {
    public static MedicineResponseDto mapToDto(MedicineServiceModel medicineServiceModel) {
        MedicineResponseDto medicineResponseDto = new MedicineResponseDto();
        medicineResponseDto.setId(medicineServiceModel.getId());
        medicineResponseDto.setCreatedAt(medicineServiceModel.getCreatedAt());
        medicineResponseDto.setManufacturer(medicineServiceModel.getManufacturer());
        medicineResponseDto.setName(medicineServiceModel.getName());
        medicineResponseDto.setManufacturedDate(medicineServiceModel.getManufacturedDate());
        medicineResponseDto.setExpiringDate(medicineServiceModel.getExpiringDate());
        medicineResponseDto.setVerified(medicineServiceModel.isVerified());
        medicineResponseDto.setDeleted(medicineServiceModel.isDeleted());
        return medicineResponseDto;
    }
    public static MedicineServiceModel mapToModel(MedicineRequestDto dto) {
        MedicineServiceModel medicine = new MedicineServiceModel();
        medicine.setName(dto.getName());
        medicine.setManufacturer(dto.getManufacturer());
        medicine.setManufacturedDate(dto.getManufacturedDate());
        medicine.setExpiringDate(dto.getExpiringDate());
        return medicine;
    }
}
