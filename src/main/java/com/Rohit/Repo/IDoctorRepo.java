package com.Rohit.Repo;

import com.Rohit.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepo extends JpaRepository<Doctor,Integer> {
}
