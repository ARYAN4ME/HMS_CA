package com.org.hospitalManagementSystem.entity;

import com.org.hospitalManagementSystem.enums.DoctorCity;
import com.org.hospitalManagementSystem.enums.Speciality;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;
    @Size(min = 3, message = "Name should be at least 3 characters")
    private String DoctorName;
    @Pattern(regexp = "^\\d{10}$", message = "Mobile number should be 10 digits")
    private String DoctorPhoneNo;

    @Enumerated(EnumType.STRING)
    private DoctorCity doctorCity;
    @Enumerated(EnumType.STRING)
    private Speciality speciality;
    @Email(message = "Invalid email address")
    String doctorEmail;
    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    List<Doctor> patientList = new ArrayList<>();




}
