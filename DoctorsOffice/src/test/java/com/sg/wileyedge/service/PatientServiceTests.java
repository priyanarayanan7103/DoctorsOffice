package com.sg.wileyedge.service;
import com.sg.wileyedge.dao.PatientDao;
import com.sg.wileyedge.dto.Patient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class PatientServiceTests {

    private PatientServiceImpl patientService;

    public PatientServiceTests(){
        PatientDao patientDao = new PatientDaoStubImpl();
        patientService = new PatientServiceImpl(patientDao);
    }

    @Test
    @DisplayName("Find Patient Service Test")
    public void findPatientServiceTest(){
        Patient returnPatient = patientService.getPatientById(1);
        assertNotNull(returnPatient);
        assertEquals("John", returnPatient.getPatientFName());
        assertEquals("Doe", returnPatient.getPatientLName());
    }

    @Test
    @DisplayName("Patient Not Found Service Test")
    public void patientNotFoundServiceTest(){
        Patient notFound = patientService.getPatientById(-1);
        assertNotNull(notFound);
        assertEquals("Patient not found", notFound.getPatientFName());
        assertEquals("Patient not found", notFound.getPatientLName());
    }

    @Test
    @DisplayName("Update Patient Service Test")
    public void updateCourseServiceTest(){
        Patient patient = new Patient();
        patient.setPatientId(1);
        patient.setPatientFName("Updated Patient First Name");
        patient.setPatientLName("Updated Patient Last Name");

        Patient upPatient = patientService.updatePatientData(1, patient);
        assertEquals(1, patient.getPatientId());
        assertNotNull(upPatient);
    }

    @Test
    @DisplayName("Patient No Update Service Test")
    public void patientNoUpdateServiceTest(){
        Patient patient = new Patient();
        patient.setPatientId(-1);
        patient.setPatientFName("Updated Patient First Name");
        patient.setPatientLName("Updated Patient Last Name");

        Patient upPatient = patientService.updatePatientData(-2, patient);
        assertEquals("IDs do not match, patient not updated", patient.getPatientFName());
        assertEquals("IDs do not match, patient not updated", patient.getPatientLName());
    }

    @Test
    @DisplayName("Patient Add Service Test")
    public void patientAddServiceTest(){
        Patient patient = new Patient();
        patient.setPatientFName("New Patient First Name");
        patient.setPatientLName("New Patient Last Name");

        Patient newPatient = patientService.addNewPatient(patient);
        assertNotNull(newPatient);
        assertEquals("New Patient First Name", newPatient.getPatientFName());
        assertEquals("New Patient Last Name", newPatient.getPatientLName());
    }

    @Test
    @DisplayName("Patient No Add Service Test")
    public void patientNoAddServiceTest(){
        Patient patient = new Patient();
        patient.setPatientFName("");
        patient.setPatientLName("");
        Patient newPatient = patientService.addNewPatient(patient);
        assertEquals("First Name blank, patient not added", patient.getPatientFName());
        assertEquals("Last Name blank, patient not added", patient.getPatientLName());
    }
}
