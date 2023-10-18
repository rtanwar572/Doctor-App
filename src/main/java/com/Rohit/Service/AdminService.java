package com.Rohit.Service;

//import com.Rohit.Model.Admin;
import com.Rohit.Model.Admin;
import com.Rohit.Model.Patient;
import com.Rohit.Model.PatientAuthToken;
import com.Rohit.Model.dto.SignInInputDto;
import com.Rohit.Repo.IAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class AdminService {
    @Autowired
    IAdminRepo iAdminRepo;

    @Autowired
    PTokenService pTokenService;

    public String addminSignUp(Admin admin){
        //check if already exist ... then try login ....
        String newMail = admin.getAdminEmail();
        Admin existingAdmin = iAdminRepo.findFirstByAdminEmail(newMail);
        if (existingAdmin != null) {
            return "email already Used";
        }
//        return "login";
        //password creation encryptioon..
        String signUpPassword = admin.getAdminpass();

        try {
            String encryptedPassword = PassEncryptor.encrypt(signUpPassword);

            admin.setAdminpass(encryptedPassword);


            // patient table - save patient
            iAdminRepo.save(admin);
            return "patient registered";

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }

    }

    public String addminSignIn(SignInInputDto signIn) {
        String signEmail=signIn.getEmail();
        Admin existingAdmin=iAdminRepo.findFirstByAdminEmail(signEmail);
        //here we eil get fisrt record of that matching email
        if (existingAdmin==null){
            return "Not a Valid email";
        }
        //
        String givenPass=signIn.getPass();
        try {
            String encryptedPassword = PassEncryptor.encrypt(givenPass);

            if(existingAdmin.getAdminpass().equals(encryptedPassword)){
                //return a token for this signin
                PatientAuthToken authToken=new PatientAuthToken(existingAdmin);
                //we want to write tokens login seperately that why we create it
                pTokenService.createToken(authToken); //we hev creted th token now lets return it...
                return authToken.getTokValue();
            }
            return "Invalid Credentials !!";

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }


    }
}
