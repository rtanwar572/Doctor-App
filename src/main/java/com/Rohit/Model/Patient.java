package com.Rohit.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = Patient.class,property = "patId")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patId;
    private String patName;
    @Email
    private String patEmail;
    private String patPass;
    @Enumerated(value = EnumType.STRING)
    private Blood bloodGroup;
    @Enumerated(value = EnumType.STRING)
    private Gender patGen;
    private String patContact;
    private LocalDateTime patDate;

    @OneToMany(mappedBy = "patientAppoint")
    List<Appointment> patAppointments;

}
