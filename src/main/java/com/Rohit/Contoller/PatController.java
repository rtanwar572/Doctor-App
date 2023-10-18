package com.Rohit.Contoller;

import com.Rohit.Model.Appointment;
import com.Rohit.Model.Patient;
import com.Rohit.Model.dto.AuthenticationInputDto;
import com.Rohit.Model.dto.ScheduleAppointDto;
import com.Rohit.Model.dto.SignInInputDto;
import com.Rohit.Service.AppointService;
import com.Rohit.Service.PatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatController {
    @Autowired
    PatService patService;

    @Autowired
    AppointService appointService;
    //sign up
    @PostMapping("/signup")
    public String patSignUp(@RequestBody Patient pat){
        return patService.patSignUp(pat);
    }
    //sing in

    @PostMapping("/signin")
    //here we are accepting an object of signIninputDto
    public String patSignIn(@RequestBody SignInInputDto signIn){
        return patService.patSignIn(signIn);
    }

//    sign out
    //who can signout ==> who has sign in
    @DeleteMapping("/signout")
    public String patSignOut(@RequestBody AuthenticationInputDto authInputDto){
        //the auth token should deleted after this callout..
        return patService.patsignout(authInputDto);
    }
    //appointment
    @PostMapping("/appointment/schedule")
    public String patAppoint(@RequestBody ScheduleAppointDto scheduleAppointDto){
        return appointService.patAppoint(scheduleAppointDto.getInputDto(),scheduleAppointDto.getAppointment());
    }
    @GetMapping("/id/{patId}")
    public Patient getPatient(@RequestBody AuthenticationInputDto authenticationInputDto,@PathVariable Integer patId){
        return patService.getPatient(authenticationInputDto,patId);
    }
    @DeleteMapping("/cancel/Appointment")
    public String cancelAppoint(@RequestBody ScheduleAppointDto scheduleAppointDto){
        return patService.delAppoint(scheduleAppointDto);
    }
}
