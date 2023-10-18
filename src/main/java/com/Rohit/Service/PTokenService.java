package com.Rohit.Service;

import com.Rohit.Model.PatientAuthToken;
import com.Rohit.Model.dto.AuthenticationInputDto;
import com.Rohit.Repo.IPTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//for saving token in table we need to create service and repo for ptokenauth
@Service
public class PTokenService {
    @Autowired
    IPTokenRepo tokenRepo;

    public void createToken(PatientAuthToken authToken) {
        tokenRepo.save(authToken);
    }

    public void delToken(String tokVal) {
        PatientAuthToken token =tokenRepo.findFirstByTokValue(tokVal);
        tokenRepo.delete(token);
    }

    //used for check or autenticate the user ud and pass
    public boolean Authenticate(AuthenticationInputDto authInputDto) {
    String tokenVal=authInputDto.getTokenVal();
    String email=authInputDto.getEmail();
    PatientAuthToken token=tokenRepo.findFirstByTokValue(tokenVal);
        if(token!=null){
            return token.getPatient().getPatEmail().equals(email);
        }
        else{
            return false;
        }
//    return true;
    }
    public boolean AuthenticateA(String email,String tokVal) {
        PatientAuthToken token=tokenRepo.findFirstByTokValue(tokVal);
        if(token!=null){
            return token.getAdmin().getAdminEmail().equals(email);
        }
        else{
            return false;
        }
//    return true;
    }

}
