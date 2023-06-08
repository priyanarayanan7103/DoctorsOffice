package com.sg.wileyedge.service;

import com.sg.wileyedge.dao.PatientDao;
import com.sg.wileyedge.dto.Patient;

import java.util.List;

public class PatientDaoStubImpl implements PatientDao {

    public Patient onlyPatient;

    public PatientDaoStubImpl(){
        onlyPatient = new Patient();
        onlyPatient.setPatientId(1);
        onlyPatient.setPatientFName("John");
        onlyPatient.setPatientLName("Doe");
    }


    @Override
    public Patient createNewPatient(Patient patient) {
        if(patient.getPatientFName() == "" || patient.getPatientLName() == ""){
            patient.setPatientFName("First name blank, student not added");
            patient.setPatientLName("Last name blank, student not added");
        }
        return patient;
    }

    @Override
    public List<Patient> getAllPatients() {
        return null;
    }

    @Override
    public Patient findPatientById(int id) {
        if(onlyPatient.getPatientId() != id){
            onlyPatient.setPatientFName("Patient not found");
            onlyPatient.setPatientLName("Patient not found");
        }
        return onlyPatient;
    }

    @Override
    public void updatePatient(Patient patient) {
        onlyPatient.setPatientFName(patient.getPatientFName());
        onlyPatient.setPatientLName(patient.getPatientLName());
    }

    @Override
    public void deletePatient(int id) {

    }
}
