package com.sg.wileyedge.controller;

import com.sg.wileyedge.dto.Appointment;
import com.sg.wileyedge.service.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/appointment")
@CrossOrigin
public class AppointmentController {

    @Autowired
    AppointmentServiceImpl appointmentService;

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments(){
        return null;
    }
}
