package com.org.hospitalManagementSystem.controller;

import com.org.hospitalManagementSystem.entity.Doctor;
import com.org.hospitalManagementSystem.enums.Symptom;
import com.org.hospitalManagementSystem.repository.DoctorRepository;
import com.org.hospitalManagementSystem.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;

@RestController
@Validated
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @PostMapping("/add")
    public Doctor addDoctor(@Valid @RequestBody Doctor doctor, BindingResult bindingResult)throws Exception{
        doctorService.addDoctor(doctor,bindingResult);
        return doctor;
    }
    @GetMapping("/get/{symptom}")
    public Doctor getDoctorBySymptom(@PathVariable String symptom){
        return doctorService.getDoctorBySymptom(symptom);
    }
}
