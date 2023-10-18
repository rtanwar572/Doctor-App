package com.Rohit.Service;

import com.Rohit.Model.Appointment;
import com.Rohit.Model.Patient;
import com.Rohit.Model.dto.AuthenticationInputDto;
import com.Rohit.Repo.IAppointmentRepo;
import com.Rohit.Repo.IDoctorRepo;
import com.Rohit.Repo.IPatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppointService {
    @Autowired
    IAppointmentRepo iAppointmentRepo;

    @Autowired
    PTokenService pTokenService;

    @Autowired
    IDoctorRepo iDoctorRepo;

    @Autowired
    IPatRepo iPatRepo;
    public String patAppoint(AuthenticationInputDto inputDto, Appointment appointment) {
//        String tokVal=inputDto.getTokenVal();
        if(pTokenService.Authenticate(inputDto)){
            //find the patient
            String email=inputDto.getEmail();
            Patient existPat=iPatRepo.findFirstByPatEmail(email);
            appointment.setPatientAppoint(existPat);

            Integer docId=appointment.getDoctorAppoint().getDocId();
            boolean isValid=iDoctorRepo.existsById(docId);
            //if tye doc is present then only we allow to book appoint with doct right ??
            if(isValid){
                appointment.setAppCreation(LocalDateTime.now());
                iAppointmentRepo.save(appointment);
                return "Appointment Registered With Dr. "+appointment.getDoctorAppoint().getDocName();
            }
            else {
                return "Doctor, Does Not Exist";
            }

        }
        else {
            return "UnAuthorized !!";
        }
    }

    public String delAppointById(Integer appId) {
         iAppointmentRepo.deleteById(appId);
         return "Appointment Cancelled !!";
    }
}
