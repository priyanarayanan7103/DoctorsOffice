package com.sg.wileyedge.service;

import com.sg.wileyedge.dto.Doctor;

import java.util.List;

public interface DoctorService {

    List<Doctor> getAllDoctors();

    Doctor getDoctorById(int id);

    Doctor addNewDoctor(Doctor doctor);

    Doctor updateDoctorData(int id, Doctor doctor);

    void deletedoctorById(int id);
}
