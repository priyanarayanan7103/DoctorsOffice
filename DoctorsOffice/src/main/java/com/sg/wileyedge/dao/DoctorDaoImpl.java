package com.sg.wileyedge.dao;

import com.sg.wileyedge.dao.mappers.DoctorMapper;
import com.sg.wileyedge.dto.Doctor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorDaoImpl implements DoctorDao{
    private final JdbcTemplate jdbcTemplate;

    public DoctorDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Doctor createNewDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctor (doctorId, doctorFName, doctorLName, doctorSpecialtyId, phoneNumber, email) VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, doctor.getDoctorId(), doctor.getDoctorFName(), doctor.getDoctorLName(), doctor.getDoctorSpecialtyId(), doctor.getPhoneNumber(), doctor.getEmail() );
        return doctor;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        String sql = "SELECT * FROM doctor";
        return jdbcTemplate.query(sql, new DoctorMapper());
    }

    @Override
    public Doctor findDoctorById(int id) {
        String sql = "SELECT * FROM doctor WHERE doctorId = ?";
        return jdbcTemplate.queryForObject(sql, new DoctorMapper(), id);
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        String sql = "UPDATE doctor SET doctorFName = ?, doctorLName = ?, doctorSpecialtyId = ?, phoneNumber = ?, email = ? WHERE doctorId = ?";
        jdbcTemplate.update(sql, doctor.getDoctorFName(), doctor.getDoctorLName(), doctor.getDoctorSpecialtyId(), doctor.getPhoneNumber(), doctor.getEmail(), doctor.getDoctorId());
    }

    @Override
    public void deleteDoctor(int id) {
        String sql = "DELETE FROM doctor WHERE doctorId = ?";
        jdbcTemplate.update(sql, id);
    }
}