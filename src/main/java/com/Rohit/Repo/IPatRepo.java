package com.Rohit.Repo;

import com.Rohit.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatRepo extends JpaRepository<Patient,Integer> {
    Patient findFirstByPatEmail(String newMail);
}
