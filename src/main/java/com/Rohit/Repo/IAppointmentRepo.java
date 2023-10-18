package com.Rohit.Repo;

import com.Rohit.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepo extends JpaRepository<Appointment,Integer> {
}
