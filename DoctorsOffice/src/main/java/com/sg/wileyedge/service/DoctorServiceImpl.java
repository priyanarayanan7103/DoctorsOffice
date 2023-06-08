package com.sg.wileyedge.service;

import com.sg.wileyedge.dao.DoctorDao;
import com.sg.wileyedge.dto.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    DoctorDao doctorDao;

    public DoctorServiceImpl(DoctorDao doctorDao){this.doctorDao = doctorDao;}

    @Autowired
    AppointmentServiceImpl appointmentService;

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorDao.getAllDoctors();
    }

    @Override
    public Doctor getDoctorById(int id) {
        try {
            return doctorDao.findDoctorById(id);
        } catch (DataAccessException e) {
            Doctor doctor = new Doctor();
            doctor.setDoctorFName("Doctor Not Found");
            doctor.setDoctorLName("Doctor Not Found");
            return doctor;
        }
    }

    public String getDoctorSpecialityById(int id) {
        try {
            return doctorDao.findDoctorSpecialityById(id);
        } catch (DataAccessException e) {
            return "";
        }
    }

    @Override
    public Doctor addNewDoctor(Doctor doctor) {
        if (doctor.getDoctorFName().isBlank()) {
            doctor.setDoctorFName("First Name blank, doctor not added");
        }
        if (doctor.getDoctorLName().isBlank()) {
            doctor.setDoctorLName("Last Name blank, doctor not added");
        }
        return doctorDao.createNewDoctor(doctor);
    }

    @Override
    public Doctor updateDoctorData(int id, Doctor doctor) {
        if (id != doctor.getDoctorId()) {
            doctor.setDoctorFName("IDs do not match, doctor not updated");
            doctor.setDoctorLName("IDs do not match, doctor not updated");
            return doctor;
        }

        Doctor updatedDoctor = doctorDao.findDoctorById(id);
        if (updatedDoctor != null) {
            updatedDoctor.setDoctorFName(doctor.getDoctorFName());
            updatedDoctor.setDoctorLName(doctor.getDoctorLName());
            updatedDoctor.setDoctorSpecialtyId(doctor.getDoctorSpecialtyId());
            updatedDoctor.setPhoneNumber(doctor.getPhoneNumber());
            doctorDao.updateDoctor(updatedDoctor);
        }
        return updatedDoctor;
    }

    @Override
    public void deletedoctorById(int id) {
        doctorDao.deleteDoctor(id);
    }
}
