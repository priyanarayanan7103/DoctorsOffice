package com.sg.wileyedge.dao;

import com.sg.wileyedge.dto.Patient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
class PatientDaoTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PatientDao patientDao;

    @Test
    @DisplayName("Get A List Of All Patients")
    public void getAllPatientsTest() {
        List<Patient> patientList = patientDao.getAllPatients();
        assertNotNull(patientList);
        // Add assertions to verify the expected number of patients
        // and the correctness of the retrieved patient information
    }

    @Test
    @DisplayName("Get Patient By Id")
    public void getPatientByIdTest() {
        Patient patient = patientDao.findPatientById(1);
        assertNotNull(patient);
        // Add assertions to verify the correctness of the retrieved patient information
    }

    @Test
    @DisplayName("Add New Patient")
    public void addNewPatientTest() {
        Integer numberOfPatients = patientDao.getAllPatients().size();

        Patient patient = new Patient();
        patient.setPatientId(-1);
        patient.setPatientFName("Peter");
        patient.setPatientLName("Pan");
        patient.setDateOfBirth(LocalDate.parse("1999-01-01"));
        patient.setPhoneNumber("1234567890");
        patient.setEmail("peter.pan@example.com");
        patient.setAddress("Neverland");

        patientDao.createNewPatient(patient);

        List<Patient> patientList = patientDao.getAllPatients();
        assertNotNull(patientList);
        assertEquals(numberOfPatients + 1, patientList.size());
    }

    @Test
    @DisplayName("Update Patient Data")
    public void updatePatientDataTest() {
        Patient patient = new Patient();
        patient.setPatientId(1);
        patient.setPatientFName("Updated");
        patient.setPatientLName("Patient");
        patient.setDateOfBirth(LocalDate.parse("1995-05-05"));
        patient.setPhoneNumber("9876543210");
        patient.setEmail("updated.patient@example.com");
        patient.setAddress("456 Elm St");

        patientDao.updatePatient(patient);

        Patient updatedPatient = patientDao.findPatientById(patient.getPatientId());
        assertNotNull(updatedPatient);
        assertEquals("Updated", updatedPatient.getPatientFName());
        assertEquals("Patient", updatedPatient.getPatientLName());
        assertEquals("1995-05-05", updatedPatient.getDateOfBirth().toString());
        assertEquals("9876543210", updatedPatient.getPhoneNumber());
        assertEquals("updated.patient@example.com", updatedPatient.getEmail());
        assertEquals("456 Elm St", updatedPatient.getAddress());
    }

    @Test
    @DisplayName("Delete Patient By Id")
    public void deletePatientByIdTest() {
        Integer numberOfPatients = patientDao.getAllPatients().size();

        patientDao.deletePatient(-1);

        List<Patient> patientList = patientDao.getAllPatients();
        assertNotNull(patientList);
        assertEquals(numberOfPatients - 1, patientList.size());
    }
}