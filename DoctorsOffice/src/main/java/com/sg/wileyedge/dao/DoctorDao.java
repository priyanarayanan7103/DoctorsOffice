package com.sg.wileyedge.dao;

import com.sg.wileyedge.dto.Doctor;
import com.sg.wileyedge.dto.Specialty;

import java.util.List;

public interface DoctorDao {

    Doctor createNewDoctor(Doctor doctor);

    List<Doctor> getAllDoctors();

    Doctor findDoctorById(int id);

    void updateDoctor(Doctor doctor);

    void deleteDoctor(int id);

    String findDoctorSpecialityById(int id);
    List<Specialty> getAllSpecialities();
}


