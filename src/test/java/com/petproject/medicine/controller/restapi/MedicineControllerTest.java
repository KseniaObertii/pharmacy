package com.petproject.medicine.controller.restapi;

import com.petproject.medicine.AbstractTest;
import com.petproject.medicine.controller.restapi.input.MedicineRequestDto;
import com.petproject.medicine.controller.restapi.mapper.MedicineMapper;
import com.petproject.medicine.controller.restapi.output.MedicineResponseDto;
import com.petproject.medicine.dependecies.dao.output.Medicine;
import com.petproject.medicine.service.MedicineService;
import com.petproject.medicine.service.mapper.MedicineServiceModelMapper;
import com.petproject.medicine.service.output.MedicineServiceModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class MedicineControllerTest extends AbstractTest {

    @InjectMocks
    private MedicineController medicineController;

    @Mock
    private MedicineService medicineService;

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void createMedicine() throws Exception {
        String uri = "/medicine";
        MedicineServiceModel medicineServiceModel = MedicineServiceModel.builder()
                .id(3L)
                .name("Aspirin")
                .build();

        Mockito.when(medicineService.save(Mockito.any(MedicineServiceModel.class))).thenReturn(medicineServiceModel);

        String inputJson = super.mapToJson(medicineServiceModel);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
}