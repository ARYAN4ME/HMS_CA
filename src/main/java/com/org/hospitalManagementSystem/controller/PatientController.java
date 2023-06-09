package com.org.hospitalManagementSystem.controller;

import com.org.hospitalManagementSystem.entity.Patient;
import com.org.hospitalManagementSystem.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;
    @PostMapping("add")
    public Patient addPatient(@Valid @RequestBody Patient patient, BindingResult bindingResult)throws Exception{
        patientService.addPatient(patient,bindingResult);
        return patient;
    }


}
