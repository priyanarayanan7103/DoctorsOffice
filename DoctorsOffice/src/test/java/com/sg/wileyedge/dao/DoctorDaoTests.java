package com.sg.wileyedge.dao;

import com.sg.wileyedge.dto.Doctor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@ActiveProfiles("test")
class DoctorDaoTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DoctorDao doctorDao;

    @Test
    @DisplayName("Get A List Of All Doctors")
    public void getListOfAllDoctorsTest() {
        List<Doctor> newList = doctorDao.getAllDoctors();
        assertNotNull(newList);
        assertEquals(7, newList.size());
    }

    @Test
    @DisplayName("Add New Doctor Test")
    public void addNewDoctorTest() {
        Integer numberOfDoctors = doctorDao.getAllDoctors().size();

        Doctor doctor = new Doctor();
        doctor.setDoctorId(-1);
        doctor.setDoctorFName("Pasan");
        doctor.setDoctorLName("Undugodage");
        doctor.setDoctorSpecialtyId("1"); // Provide a valid specialtyId
        doctor.setPhoneNumber("1234567890");
        doctor.setEmail("pasanu@email.com");

        doctorDao.createNewDoctor(doctor);
        List<Doctor> newList = doctorDao.getAllDoctors();
        assertNotNull(newList);
        assertEquals(numberOfDoctors + 1, newList.size());
    }



    @Test
    @DisplayName("Find Doctor By Id")
    public void findDoctorByIdTest() {
        Doctor doctor = doctorDao.findDoctorById(1);
        assertNotNull(doctor);
        assertEquals("John", doctor.getDoctorFName());
        assertEquals("Smith", doctor.getDoctorLName());
    }

    @Test
    @DisplayName("Update Doctor Info")
    public void updateDoctorInfoTest() {
        // Create a new doctor
        Doctor doctor = new Doctor();
        doctor.setDoctorId(-2);
        doctor.setDoctorFName("Test");
        doctor.setDoctorLName("Name");
        doctor.setDoctorSpecialtyId("1"); // Provide a valid specialtyId
        doctor.setPhoneNumber("1234567890");
        doctor.setEmail("johndoe@example.com");
        doctorDao.createNewDoctor(doctor);

        // Update the doctor's information
        doctor.setDoctorFName("Updated");
        doctor.setDoctorLName("Name");
        doctor.setDoctorSpecialtyId("2"); // Provide a valid updated specialtyId
        doctor.setPhoneNumber("9876543210");
        doctor.setEmail("updated@example.com");
        doctorDao.updateDoctor(doctor);

        // Retrieve the updated doctor from the database
        Doctor updatedDoctor = doctorDao.findDoctorById(doctor.getDoctorId());
        assertNotNull(updatedDoctor);
        assertEquals("Updated", updatedDoctor.getDoctorFName());
        assertEquals("Name", updatedDoctor.getDoctorLName());
        assertEquals("2", updatedDoctor.getDoctorSpecialtyId());
        assertEquals("9876543210", updatedDoctor.getPhoneNumber());
        assertEquals("updated@example.com", updatedDoctor.getEmail());
    }

    @Test
    @DisplayName("Delete Doctor Test")

    public void deleteDoctorTest() {
        Integer numberOfDoctors = doctorDao.getAllDoctors().size();

        doctorDao.deleteDoctor(-1);
        assertNotNull(doctorDao.getAllDoctors());
        assertEquals(numberOfDoctors - 1, doctorDao.getAllDoctors().size());


        doctorDao.deleteDoctor(-2);
        assertNotNull(doctorDao.getAllDoctors());
        assertEquals(numberOfDoctors - 2, doctorDao.getAllDoctors().size());
    }


}