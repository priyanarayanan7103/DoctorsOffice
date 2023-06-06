package com.sg.wileyedge.dao;


import com.sg.wileyedge.dao.AppointmentDao;
import com.sg.wileyedge.dto.Appointment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@ActiveProfiles("test")
public class AppointmentDaoTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AppointmentDao appointmentDao;

    @Test
    @DisplayName("Create New Appointment")
    public void createNewAppointmentTest() {
        Integer numberOfAppointments = appointmentDao.getAllAppointments().size();

        Appointment appointment = new Appointment();
        appointment.setAppointmentId(-1);
        appointment.setTime(LocalDateTime.now());
        appointment.setDoctorId(1); // Provide a valid doctorId
        appointment.setPatientId(1); // Provide a valid patientId
        appointment.setStatus("Scheduled");
        appointmentDao.createNewAppointment(appointment);

        List<Appointment> appointmentList = appointmentDao.getAllAppointments();
        assertNotNull(appointmentList);
        assertEquals(numberOfAppointments + 1, appointmentList.size());
    }

    @Test
    @DisplayName("Get All Appointments")
    public void getAllAppointmentsTest() {
        List<Appointment> appointmentList = appointmentDao.getAllAppointments();
        assertNotNull(appointmentList);
        assertEquals(7, appointmentList.size()); // Update with the expected number of appointments
    }

    @Test
    @DisplayName("Find Appointment By Id")
    public void findAppointmentByIdTest() {
        Appointment appointment = appointmentDao.findAppointmentById(1); // Provide a valid appointmentId
        assertNotNull(appointment);
        assertEquals(1, appointment.getAppointmentId()); // Update with the expected appointmentId
    }

    @Test
    @DisplayName("Update Appointment")
    public void updateAppointmentTest() {
        // Create a new appointment
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(-2); // Provide a valid appointmentId
        appointment.setTime(LocalDateTime.now());
        appointment.setDoctorId(1); // Provide a valid doctorId
        appointment.setPatientId(1); // Provide a valid patientId
        appointment.setStatus("Scheduled");
        appointmentDao.createNewAppointment(appointment);

        // Update the appointment's information
        appointment.setTime(LocalDateTime.now().plusHours(1)); // Update with the new time
        appointment.setStatus("Cancelled"); // Update with the new status
        appointmentDao.updateAppointment(appointment);

        // Retrieve the updated appointment from the database
        Appointment updatedAppointment = appointmentDao.findAppointmentById(appointment.getAppointmentId());
        assertNotNull(updatedAppointment);
        assertEquals(appointment.getStatus(), updatedAppointment.getStatus());
    }

    @Test
    @DisplayName("Delete Appointment")
    public void deleteAppointmentTest() {
        Integer numberOfAppointments = appointmentDao.getAllAppointments().size();

        appointmentDao.deleteAppointment(-1); // Provide a valid appointmentId
        appointmentDao.deleteAppointment(-2); // Provide a valid appointmentId

        List<Appointment> appointmentList = appointmentDao.getAllAppointments();
        assertNotNull(appointmentList);
        assertEquals(numberOfAppointments - 2, appointmentList.size());


    }

}