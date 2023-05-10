package com.org.hospitalManagementSystem.repository;

import com.org.hospitalManagementSystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
    Patient findBySymptom(String symptom);
}
