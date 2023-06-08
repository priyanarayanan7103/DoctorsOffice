package com.sg.wileyedge.dao;

import com.sg.wileyedge.dao.mappers.DoctorMapper;
import com.sg.wileyedge.dto.Doctor;
import com.sg.wileyedge.dto.Specialty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
        String sql = "INSERT INTO doctor (doctorId, doctorFName, doctorLName, doctorSpecialtyId, phoneNumber, email, imageURL) VALUES (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, doctor.getDoctorId(), doctor.getDoctorFName(), doctor.getDoctorLName(), doctor.getDoctorSpecialtyId(), doctor.getPhoneNumber(), doctor.getEmail(), doctor.getImageURL());
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
        String sql = "UPDATE doctor SET doctorFName = ?, doctorLName = ?, doctorSpecialtyId = ?, phoneNumber = ?, email = ?, imageURL = ? WHERE doctorId = ?";
        jdbcTemplate.update(sql, doctor.getDoctorFName(), doctor.getDoctorLName(), doctor.getDoctorSpecialtyId(), doctor.getPhoneNumber(), doctor.getEmail(),doctor.getImageURL(), doctor.getDoctorId());
    }

    @Override
    public void deleteDoctor(int id) {
        String sql = "DELETE FROM doctor WHERE doctorId = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public String findDoctorSpecialityById(int id) {
        String sql = "SELECT * FROM Doctor WHERE doctorId = ?";
        Doctor temp = jdbcTemplate.queryForObject(sql, new Object[]{id}, new DoctorMapper());

        String specialtyIdStr = temp.getDoctorSpecialtyId();
        int specialtyId = Integer.parseInt(specialtyIdStr);

        sql = "SELECT specialtyName FROM Specialty WHERE specialtyId = ?";
        String specialty = jdbcTemplate.queryForObject(sql, new Object[]{specialtyId}, String.class);

        return specialty;
    }

    @Override
    public List<Specialty> getAllSpecialities() {
        String sql = "SELECT * FROM Specialty";

        return jdbcTemplate.query(sql, specialtyRowMapper);
    }

    private RowMapper<Specialty> specialtyRowMapper = (rs, rowNum) -> {
        Specialty specialty = new Specialty();
        specialty.setSpecialtyId(rs.getInt("specialtyId"));
        specialty.setSpecialtyName(rs.getString("specialtyName"));
        return specialty;
    };





}