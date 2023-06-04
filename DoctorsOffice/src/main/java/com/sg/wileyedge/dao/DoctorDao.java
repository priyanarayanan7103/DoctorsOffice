package com.sg.wileyedge.dao;

import com.sg.wileyedge.dto.Doctor;

import java.util.List;

public interface DoctorDao {

    Doctor createNewDoctor(Doctor doctor);

    List<Doctor> getAllDoctors();

    Doctor findDoctorById(int id);

    void updateDoctor(Doctor doctor);

    void deleteDoctor(int id);
}