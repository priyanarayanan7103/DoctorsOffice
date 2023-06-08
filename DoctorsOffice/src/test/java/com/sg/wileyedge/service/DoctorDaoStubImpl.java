package com.sg.wileyedge.service;

import com.sg.wileyedge.dao.DoctorDao;
import com.sg.wileyedge.dto.Doctor;

import java.util.List;

public class DoctorDaoStubImpl implements DoctorDao {

    public Doctor onlyDoctor;
    public DoctorDaoStubImpl(){
        onlyDoctor = new Doctor();
        onlyDoctor.setDoctorId(1);
        onlyDoctor.setDoctorFName("Priya");
        onlyDoctor.setDoctorLName("Narayanan");
    }
    @Override
    public Doctor createNewDoctor(Doctor doctor) {
        if(doctor.getDoctorFName() == ""
                || doctor.getDoctorLName() == ""){
            doctor.setDoctorFName("First name blank, doctor not added");
            doctor.setDoctorLName("Last name blank, doctor not added");
        }
        return doctor;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return null;
    }

    @Override
    public Doctor findDoctorById(int id) {
        if(onlyDoctor.getDoctorId() != id){
            onlyDoctor.setDoctorFName("Doctor Not Found");
            onlyDoctor.setDoctorLName("Doctor Not Found");
        }
        return onlyDoctor;
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        onlyDoctor.setDoctorFName(doctor.getDoctorFName());
        onlyDoctor.setDoctorLName(doctor.getDoctorLName());
    }

    @Override
    public void deleteDoctor(int id) {

    }

    @Override
    public String findDoctorSpecialityById(int id) {
        return null;
    }
}
