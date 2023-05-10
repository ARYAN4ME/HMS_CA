package com.org.hospitalManagementSystem.service;

import com.org.hospitalManagementSystem.entity.Patient;
import com.org.hospitalManagementSystem.repository.PatientRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    public void addPatient(Patient patient, BindingResult bindingResult)throws Exception{
        if(patientRepository.findById(patient.getPatientId()).get() != null)throw new Exception("Patient already exist");
        else patientRepository.save(patient);

    }
}
