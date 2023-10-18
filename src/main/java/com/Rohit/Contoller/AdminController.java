package com.Rohit.Contoller;

import com.Rohit.Model.Admin;
import com.Rohit.Model.Doctor;
import com.Rohit.Model.Patient;
import com.Rohit.Model.dto.SignInInputDto;
import com.Rohit.Service.AdminService;
import com.Rohit.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    DoctorService doctorService;

    @Autowired
    AdminService adminService;

    @PostMapping("/signup")
    public String patSignUp(@RequestBody Admin admin){
        return adminService.addminSignUp(admin);
    }

    @PostMapping("/signin")
    //here we are accepting an object of signIninputDto
    public String addSignIn(@RequestBody SignInInputDto signIn){
        return adminService.addminSignIn(signIn);
    }

    @PostMapping("/doctor")
    public String addDoctor(@RequestBody Doctor doctor,String email,String tokVal){
        return doctorService.addDoctor(doctor,email,tokVal);
    }

    @GetMapping("/doctor")
    public List<Doctor> getDoctors(){
        return doctorService.getDoctors();
    }

}
