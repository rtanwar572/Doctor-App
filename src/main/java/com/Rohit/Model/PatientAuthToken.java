package com.Rohit.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "auth_token")
public class PatientAuthToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tokId;
    private String tokValue;
    private LocalDateTime tokCreationTime;
    //it should linked with one patient at a time ..

    public PatientAuthToken(Patient patient) {
        this.patient = patient;
        this.tokCreationTime=LocalDateTime.now();
        this.tokValue= UUID.randomUUID().toString();
    }
    public PatientAuthToken(Admin admin) {
        this.admin = admin;
        this.tokCreationTime=LocalDateTime.now();
        this.tokValue= UUID.randomUUID().toString();
    }

    @OneToOne
    @JoinColumn(name = "fk-patId")
    Patient patient;

    @OneToOne
    @JoinColumn(name = "fk-adminId")
    Admin admin;
}
