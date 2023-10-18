package com.Rohit.Service;

import com.Rohit.Model.Doctor;
import com.Rohit.Repo.IDoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    IDoctorRepo iDoctorRepo;
    @Autowired
    PTokenService pTokenService;

    public String addDoctor(Doctor doctor,String email,String tokenVal) {
        Integer docId=doctor.getDocId();
        if(pTokenService.AuthenticateA(email,tokenVal)){
            if(docId!=null && iDoctorRepo.existsById(docId)){
                return "Doctor Already Exist";
            }
            else {
                //we are making appointment null bcos as doc is posting we dont want any linking or updatetion..
                //it throws me an error if i want to link by non-fk side ..
                doctor.setDocAppointments(null);
                iDoctorRepo.save(doctor);
                return "Doctor added !!";
            }
        }
        else {
            return "UnAuthorized Admin";
        }

    }

    public Doctor getDoctorById(Integer id) {
        return iDoctorRepo.findById(id).orElseThrow();
    }

    public List<Doctor> getDoctors() {
        return iDoctorRepo.findAll();
    }
}
