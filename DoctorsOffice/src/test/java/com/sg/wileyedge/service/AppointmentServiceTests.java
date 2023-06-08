package com.sg.wileyedge.service;
import com.sg.wileyedge.dao.AppointmentDao;
import com.sg.wileyedge.dto.Appointment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
public class AppointmentServiceTests {

    private AppointmentServiceImpl appointmentService;

    public AppointmentServiceTests(){
        AppointmentDao appointmentDao = new AppointmentDaoStubImpl();
        appointmentService = new AppointmentServiceImpl(appointmentDao);
    }

    @Test
    @DisplayName("Find appointment service test")
    public void findAppointmentServiceTest(){
        Appointment returnAppointment = appointmentService.getAppointmentById(100);
        assertNotNull(returnAppointment);
        assertEquals(100, returnAppointment.getAppointmentId());
    }
    @Test
    @DisplayName("Appointment not found service test")
    public void appointmentNotFoundServiceTest(){
        Appointment notFound = appointmentService.getAppointmentById(100);
        assertNotNull(notFound);
        assertEquals(100, notFound.getAppointmentId());
    }

    @Test
    @DisplayName("Update course servicetest")
    public void updateAppointmentServiceTest(){
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(100);
        appointment.setStatus("Updated status");
        appointment.setTime(LocalDateTime.now());
        appointment.setDoctorId(1);
        appointment.setPatientId(1);

        Appointment upAppointment = appointmentService.updateAppointmentData(100, appointment);
        upAppointment = appointmentService.getAppointmentById(100);
        assertNotNull(upAppointment);
        assertEquals(100, upAppointment.getAppointmentId());
        assertEquals("Updated status", upAppointment.getStatus());
        assertEquals(1, upAppointment.getDoctorId());
        assertEquals(1, upAppointment.getPatientId());
    }

    @Test
    @DisplayName("Appointment Add Service Test")
    public void appointmentAddServiceTest(){
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(100);
        appointment.setStatus("New status");
        appointment.setTime(LocalDateTime.now());
        appointment.setDoctorId(1);
        appointment.setPatientId(1);

        Appointment newAppointment = appointmentService.addNewAppointment(appointment);
        assertNotNull(newAppointment);
        assertEquals("New status", newAppointment.getStatus());
        assertEquals(100, newAppointment.getAppointmentId());
        assertEquals(1, newAppointment.getDoctorId());
        assertEquals(1, newAppointment.getPatientId());
    }

    @Test
    @DisplayName("Appointment No Add Service Test")
    public void appointmentNoAddServiceTest(){
        Appointment appointment = new Appointment();
        appointment.setStatus("");
        Appointment newAppointment = appointmentService.addNewAppointment(appointment);
        assertEquals("Appointment not added", appointment.getStatus());
    }
}
