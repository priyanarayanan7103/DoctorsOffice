package com.sg.wileyedge.controller;

import com.sg.wileyedge.dto.Appointment;
import com.sg.wileyedge.service.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
@CrossOrigin
public class AppointmentController {

    @Autowired
    AppointmentServiceImpl appointmentService;

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments(){
        List<Appointment> appointments = appointmentService.getAllAppointments();
        return appointments;
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable int id) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        return appointment;
    }

    @PostMapping("/add")
    public Appointment addAppointment(@RequestBody Appointment appointment) {
        Appointment savedAppointment = appointmentService.addNewAppointment(appointment);
        return savedAppointment;
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable int id, @RequestBody Appointment appointment) {
        Appointment updatedAppointment = appointmentService.getAppointmentById(id);
        updatedAppointment.setTime(appointment.getTime());
        updatedAppointment.setStatus(appointment.getStatus());
        updatedAppointment.setDoctorId(appointment.getDoctorId());
        updatedAppointment.setPatientId(appointment.getPatientId());

        Appointment appointmentToReturn = appointmentService.updateAppointmentData(id, updatedAppointment);

        return appointmentToReturn;
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable int id) {
        appointmentService.deleteAppointmentById(id);
    }
}
