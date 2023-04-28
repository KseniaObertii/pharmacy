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

//    @GetMapping
//    public List<MedicineResponseDto> getAllInLast14Days() {
//        return medicineService.getAllInLast14Days()
//                .stream()
//                .map(medicineMapper::mapToDto)
//                .collect(Collectors.toList());
//    }

    @PostMapping()
    public MedicineResponseDto create(@RequestBody @Valid MedicineRequestDto medicineRequestDto) {
        return MedicineMapper.mapToDto(
                MedicineServiceModelMapper.mapToModel(
                        medicineService.save(MedicineServiceModelMapper.mapToDto(
                                MedicineMapper.mapToModel(medicineRequestDto)))));
    }

//    @PostMapping("/clean")
//    public void deleteAllTwoWeeksOlder() {
//        medicineService.deleteAllTwoWeeksOlder();
//    }
}
