package com.sg.wileyedge.dao;

import com.sg.wileyedge.dto.Patient;

import java.util.List;

public interface PatientDao {

    Patient createNewPatient(Patient patient);

    List<Patient> getAllPatients();

    Patient findPatientById(int id);

    void updatePatient(Patient patient);

    void deletePatient(int id);
}
