package com.sg.wileyedge.service;

import com.sg.wileyedge.dto.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> getAllPatients();

    Patient getPatientById(int id);

    Patient addNewPatient(Patient patient);

    Patient updatePatientData(int id, Patient patient);

    void deletePatientById(int id);

    Patient getPatientByEmail(String email);
}
