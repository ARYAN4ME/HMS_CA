package com.org.hospitalManagementSystem.entity;

import com.org.hospitalManagementSystem.enums.Symptom;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;
    @Pattern(regexp = "^\\d{10}$", message = "Mobile number should be 10 digits")
    private String patientPhoneNo;
    @Size(min = 3,message = "Name should be at least 10 number")
    private String patientName;
    @Size(max = 20,message = "City should be at mad 20 characters")
    private String patientCity;
    @Email(message = "Invalid email address")
    private String patientEmail;
    @Enumerated(EnumType.STRING)
    private Symptom symptom;
    @ManyToOne
    @JoinColumn
    private Doctor doctor;
}
