package com.petproject.medicine.controller;

import com.petproject.medicine.dto.MedicineResponseDto;
import com.petproject.medicine.dto.MedicineRequestDto;
import com.petproject.medicine.model.Medicine;
import com.petproject.medicine.service.MedicineService;
import com.petproject.medicine.service.mapper.MedicineMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicine")
public class MedicineController {
    private final MedicineService medicineService;
    private final MedicineMapper medicineMapper;

    public MedicineController(MedicineService medicineService, MedicineMapper medicineMapper) {
        this.medicineService = medicineService;
        this.medicineMapper = medicineMapper;
    }

    @GetMapping
    public List<MedicineResponseDto> getAllInLast14Days() {
        return medicineService.getAllInLast14Days()
                .stream()
                .map(medicineMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping()
    public MedicineResponseDto create(@RequestBody @Valid MedicineRequestDto medicineRequestDto) {
        return medicineMapper.mapToDto(
                medicineService.save(medicineMapper.mapToModel(medicineRequestDto)));
    }

    @PostMapping("/clean")
    public void deleteAllTwoWeeksOlder() {
        medicineService.deleteAllTwoWeeksOlder();
    }
}
