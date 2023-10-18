package com.Rohit.Service;

import com.Rohit.Model.Patient;
import com.Rohit.Model.PatientAuthToken;
import com.Rohit.Model.dto.AuthenticationInputDto;
import com.Rohit.Model.dto.ScheduleAppointDto;
import com.Rohit.Model.dto.SignInInputDto;
import com.Rohit.Repo.IPTokenRepo;
import com.Rohit.Repo.IPatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class PatService {
    @Autowired
    IPatRepo iPatRepo;

    @Autowired
    PTokenService tokenService;

    @Autowired
    AppointService appointService;

    public String patSignUp(Patient pat) {
        //check if already exist ... then try login ....
        String newMail = pat.getPatEmail();
        Patient existingPat = iPatRepo.findFirstByPatEmail(newMail);
        if (existingPat != null) {
            return "email already Used";
        }
//        return "login";
        //password creation encryptioon..
        String signUpPassword = pat.getPatPass();

        try {
            String encryptedPassword = PassEncryptor.encrypt(signUpPassword);

            pat.setPatPass(encryptedPassword);


            // patient table - save patient
            iPatRepo.save(pat);
            return "patient registered";

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }

//        return "login";
        //save to patient repo

    }

    public String patSignIn(SignInInputDto signIn) {
        //check if the email is there in table
        //signIn only possible if this person ever sugnup

        String signEmail=signIn.getEmail();
        Patient existingpat=iPatRepo.findFirstByPatEmail(signEmail);
        //here we eil get fisrt record of that matching email
        if (existingpat==null){
            return "Not a Valid email";

        }
        //
        String givenPass=signIn.getPass();
        try {
            String encryptedPassword = PassEncryptor.encrypt(givenPass);

            if(existingpat.getPatPass().equals(encryptedPassword)){
                //return a token for this signin
                PatientAuthToken authToken=new PatientAuthToken(existingpat);
                //we want to write tokens login seperately that why we create it
                tokenService.createToken(authToken); //we hev creted th token now lets return it...
                return authToken.getTokValue();
            }
            return "Invalid Credentials !!";

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }

    }

    public String patsignout(AuthenticationInputDto authInputDto) {
        //first check that user is sign in or not
        if (tokenService.Authenticate(authInputDto)){
            String tokVal=authInputDto.getTokenVal();
            tokenService.delToken(tokVal);
            return "Sign Out Successfully !!";
        }
        return "Un Authenticated User !!";

    }

    public Patient getPatient(AuthenticationInputDto authenticationInputDto, Integer patId) {
        if(tokenService.Authenticate(authenticationInputDto)){
            return iPatRepo.findById(patId).orElseThrow();
        }
        else {
            throw new RuntimeException("UnAuthorized Access 1!");
        }
    }

    public String delAppoint(ScheduleAppointDto scheduleAppointDto) {
        String email=scheduleAppointDto.getInputDto().getEmail();
        if(tokenService.AuthenticateA(email,scheduleAppointDto.getInputDto().getTokenVal())){
            Patient existPat=iPatRepo.findFirstByPatEmail(email);
            Patient appointPat=scheduleAppointDto.getAppointment().getPatientAppoint();
            if (existPat.equals(appointPat)){
                return appointService.delAppointById(scheduleAppointDto.getAppointment().getAppId());
            }
            else {
                return "Patient Not Exist !!";
            }

        }
        else {
            return "UnAuthorized ";
        }
    }
}
