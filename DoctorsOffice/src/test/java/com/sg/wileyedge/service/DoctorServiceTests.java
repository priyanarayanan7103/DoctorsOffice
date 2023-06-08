package com.sg.wileyedge.service;

import com.sg.wileyedge.dao.DoctorDao;
import com.sg.wileyedge.dto.Doctor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoctorServiceTests {

    private DoctorServiceImpl doctorService;

    public DoctorServiceTests(){
        DoctorDao doctorDao = new DoctorDaoStubImpl();
        doctorService = new DoctorServiceImpl(doctorDao);
    }

    @Test
    @DisplayName("Find Doctor Service Test")
    public void findDoctorServiceTest(){
        Doctor returnDoctor = doctorService.getDoctorById(1);
        assertNotNull(returnDoctor);
        assertEquals("Priya", returnDoctor.getDoctorFName());
    }

    @Test
    @DisplayName("Find doctor service test")
    public void doctorNotFoundServiceTest(){
        Doctor notFound = doctorService.getDoctorById(1);
        assertNotNull(notFound);
        assertEquals(   1, notFound.getDoctorId());
    }

    @Test
    @DisplayName("Update teacher service test")
    public void updateDoctorServiceTest(){
        Doctor doctor = new Doctor();
        doctor.setDoctorId(2);
        doctor.setDoctorFName("Min");
        doctor.setDoctorLName("Toe");

        Doctor upDoctor = doctorService.updateDoctorData(2, doctor);
        assertNotNull(upDoctor);
        assertEquals(2, doctor.getDoctorId());
        assertEquals("Min", upDoctor.getDoctorFName());
        assertEquals("Toe", upDoctor.getDoctorLName());
    }

    @Test
    @DisplayName("Doctor not updated service test")
    public void doctorNotUpdatedServiceTest(){
        Doctor doctor = new Doctor();
        doctor.setDoctorId(2);
        doctor.setDoctorFName("Updated first name");
        doctor.setDoctorLName("Updated last name");

        Doctor upDoctor = doctorService.updateDoctorData(3, doctor);
        assertEquals("IDs do not match, doctor not updated", doctor.getDoctorFName());
        assertEquals("IDs do not match, doctor not updated", doctor.getDoctorLName());
    }

    @Test
    @DisplayName("Doctor Add Service test")
    public void doctorAddServiceTest(){
        Doctor doctor = new Doctor();
        doctor.setDoctorFName("New doctor first name");
        doctor.setDoctorLName("New doctor last name");
        Doctor newDoctor = doctorService.addNewDoctor(doctor);
        assertNotNull(newDoctor);
        assertEquals("New doctor first name", newDoctor.getDoctorFName());
        assertEquals("New doctor last name", newDoctor.getDoctorLName());
    }

    @Test
    @DisplayName("Doctor No Add Service Test")
    public void doctorNoAddServiceTest(){
        Doctor doctor = new Doctor();
        doctor.setDoctorFName("");
        doctor.setDoctorLName("");
        Doctor newDoctor = doctorService.addNewDoctor(doctor);
        assertEquals("First Name blank, doctor not added", doctor.getDoctorFName());
        assertEquals("Last Name blank, doctor not added", doctor.getDoctorLName());

    }
}
