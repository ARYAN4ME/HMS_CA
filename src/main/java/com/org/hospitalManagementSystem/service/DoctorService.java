package com.org.hospitalManagementSystem.service;

import com.org.hospitalManagementSystem.entity.Doctor;
import com.org.hospitalManagementSystem.entity.Patient;
import com.org.hospitalManagementSystem.enums.DoctorCity;
import com.org.hospitalManagementSystem.enums.Speciality;
import com.org.hospitalManagementSystem.enums.Symptom;
import com.org.hospitalManagementSystem.repository.DoctorRepository;
import com.org.hospitalManagementSystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;

    public void addDoctor(Doctor doctor, BindingResult bindingResult)throws Exception{
        if(doctorRepository.findById(doctor.getDoctorId()).get()!=null)throw new Exception("Doctor already present");
        else doctorRepository.save(doctor);
    }

//    -------------I hava doubt this api------------
    public Doctor getDoctorBySymptom(String symptom) throws Exception{
        HashSet<String> checkOrthopedic = new HashSet<>();
        checkOrthopedic.add(String.valueOf(Symptom.ARTHRITIS));
        checkOrthopedic.add(String.valueOf(Symptom.BACKPAIN));
        checkOrthopedic.add(String.valueOf(Symptom.TISSUE_INJURIES));
        HashSet<String> checkDermatology = new HashSet<>();
        checkDermatology.add(String.valueOf(Symptom.SKIN_BURN));
        checkDermatology.add(String.valueOf(Symptom.SKIN_INFECTION));
        Doctor findDoctor = new Doctor();

        try {
            Patient patient = patientRepository.findBySymptom(symptom);
            List<Doctor> doctorList = doctorRepository.findByDoctorCity(patient.getPatientCity());
            if (checkDermatology.contains(symptom)) {
                for(Doctor doctors : doctorList){
                    if(doctors.getSpeciality().equals(Speciality.DERMATOLOGY)){
                        findDoctor = doctors;
                    }
                    else {
                        throw new Exception("There isn’t any doctor present at your location for your symptom");
                    }
                }
            }
            else if (checkOrthopedic.contains(symptom)) {

                for(Doctor doctors : doctorList){
                    if(doctors.getSpeciality().equals(Speciality.ORTHOPEDIC)){
                        findDoctor = doctors;
                    }
                    else {
                        throw new Exception("There isn’t any doctor present at your location for your symptom");
                    }
                }
            }
            else if(symptom.equals(Symptom.DYSMENORRHEA)){

                for(Doctor doctors : doctorList){
                    if(doctors.getSpeciality().equals(Speciality.GYNECOLOGY)){
                        findDoctor = doctors;
                    }
                    else {
                        throw new Exception("There isn’t any doctor present at your location for your symptom");
                    }
                }
            }
            else{

                for(Doctor doctors : doctorList){
                    if(doctors.getSpeciality().equals(Speciality.ENT_SPECIALIST)){
                        findDoctor = doctors;
                    }
                    else {
                        throw new Exception("There isn’t any doctor present at your location for your symptom");
                    }
                }

            }
        }
        catch (Exception e){
            throw new Exception("We are still waiting to expand to your location");
        }
        return findDoctor;
    }

}
