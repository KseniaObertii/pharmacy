package com.petproject.medicine.controller.restapi;

import com.petproject.medicine.controller.restapi.input.MedicineRequestDto;
import com.petproject.medicine.controller.restapi.mapper.MedicineMapper;
import com.petproject.medicine.controller.restapi.output.MedicineResponseDto;
import com.petproject.medicine.service.MedicineService;
import com.petproject.medicine.service.mapper.MedicineServiceModelMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicine")
public class MedicineController {
    private final MedicineService medicineService;
    private final MedicineMapper medicineMapper;

    public MedicineController(MedicineService medicineService, MedicineMapper medicineMapper) {
        this.medicineService = medicineService;
        this.medicineMapper = medicineMapper;
    }

    @PostMapping()
    public MedicineResponseDto create(@RequestBody @Valid MedicineRequestDto medicineRequestDto) {
        return MedicineMapper.mapToDto(
                        medicineService.save(MedicineMapper.mapToModel(medicineRequestDto)));
    }
}
