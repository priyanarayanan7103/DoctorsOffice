package com.sg.wileyedge.service;

import com.sg.wileyedge.dao.PatientDao;
import com.sg.wileyedge.dto.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    PatientDao patientDao;

    public PatientServiceImpl(PatientDao patientDao){this.patientDao = patientDao;}

    @Autowired
    AppointmentServiceImpl appointmentService;

    @Override
    public List<Patient> getAllPatients() {
        return patientDao.getAllPatients();
    }

    @Override
    public Patient getPatientById(int id) {
        try {
            return patientDao.findPatientById(id);
        } catch (DataAccessException e) {
            Patient patient = new Patient();
            patient.setPatientFName("Patient Not Found");
            patient.setPatientLName("Patient Not Found");
            return patient;
        }
    }

    @Override
    public Patient addNewPatient(Patient patient) {
        if (patient.getPatientFName().isEmpty()) {
            patient.setPatientFName("First Name blank, patient not added");
        }
        if (patient.getPatientLName().isEmpty()) {
            patient.setPatientLName("Last Name blank, patient not added");
        }

        return patientDao.createNewPatient(patient);
    }

    @Override
    public Patient updatePatientData(int id, Patient patient) {
        if (id != patient.getPatientId()) {
            patient.setPatientFName("IDs do not match, patient not updated");
            patient.setPatientLName("IDs do not match, patient not updated");
            return patient;
        }

        Patient updatedPatient = patientDao.findPatientById(id);
        if (updatedPatient != null) {
            updatedPatient.setPatientFName(patient.getPatientFName());
            updatedPatient.setPatientLName(patient.getPatientLName());
            updatedPatient.setDateOfBirth(patient.getDateOfBirth());
            updatedPatient.setPhoneNumber(patient.getPhoneNumber());
            updatedPatient.setPatientFName(patient.getAddress());
            updatedPatient.setEmail(patient.getEmail());
            patientDao.updatePatient(updatedPatient);
        }
        return updatedPatient;
    }

    @Override
    public void deletePatientById(int id) {
        patientDao.deletePatient(id);
    }

    @Override
    public Patient getPatientByEmail(String email) {
        try {
            return patientDao.findPatientIDByEmail(email);
        } catch (DataAccessException e) {
            Patient patient = new Patient();
            patient.setPatientFName("Patient Not Found");
            patient.setPatientLName("Patient Not Found");
            return patient;
        }
    }
}
