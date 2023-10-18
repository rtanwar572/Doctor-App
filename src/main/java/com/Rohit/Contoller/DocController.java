package com.Rohit.Contoller;

import com.Rohit.Model.Doctor;
import com.Rohit.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocController {
    @Autowired
    DoctorService doctorService;
    //get doctor by id

    @GetMapping("doctor/id/{id}")
    public Doctor getDoctById(@PathVariable Integer id){
        return doctorService.getDoctorById(id);
    }
}
