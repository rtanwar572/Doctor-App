package com.Rohit.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = Appointment.class,property = "appId")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appId;
    private String appDescription;
    private LocalDateTime appCreation;
    private LocalDateTime appScheduleTime;

    @ManyToOne
    @JoinColumn(name = "doctor-id")
    Doctor doctorAppoint;

    @ManyToOne
    @JoinColumn(name = "patient-id")
    Patient patientAppoint;
}
