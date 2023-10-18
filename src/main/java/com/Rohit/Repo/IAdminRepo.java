package com.Rohit.Repo;

import com.Rohit.Model.Admin;
import com.Rohit.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin,Integer> {
    Admin findFirstByAdminEmail(String newMail);
//    Patient findFirstByAdminEmail(String newMail);
}
