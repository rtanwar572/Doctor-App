package com.Rohit.Repo;

import com.Rohit.Model.PatientAuthToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPTokenRepo extends JpaRepository<PatientAuthToken,Integer> {
    PatientAuthToken findFirstByTokValue(String tokenVal);
}
