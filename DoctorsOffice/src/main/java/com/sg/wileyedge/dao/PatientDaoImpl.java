package com.sg.wileyedge.dao;

import com.sg.wileyedge.dao.mappers.PatientMapper;
import com.sg.wileyedge.dto.Patient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDaoImpl implements PatientDao {

    private final JdbcTemplate jdbcTemplate;

    public PatientDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Patient createNewPatient(Patient patient) {
        String sql = "INSERT INTO patient (patientId, patientFName, patientLName, dateOfBirth, address, phoneNumber, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, patient.getPatientId(), patient.getPatientFName(), patient.getPatientLName(), patient.getDateOfBirth(), patient.getAddress(), patient.getPhoneNumber(), patient.getEmail());
        return patient;
    }

    @Override
    public List<Patient> getAllPatients() {
        String sql = "SELECT * FROM patient";
        return jdbcTemplate.query(sql, new PatientMapper());
    }

    @Override
    public Patient findPatientById(int id) {
        String sql = "SELECT * FROM patient WHERE patientId = ?";
        return jdbcTemplate.queryForObject(sql, new PatientMapper(), id);
    }

    @Override
    public void updatePatient(Patient patient) {
        String sql = "UPDATE patient SET patientFName = ?, patientLName = ?, dateOfBirth = ?, address = ?, phoneNumber = ?, email = ? WHERE patientId = ?";
        jdbcTemplate.update(sql, patient.getPatientFName(), patient.getPatientLName(), patient.getDateOfBirth(), patient.getAddress(), patient.getPhoneNumber(), patient.getEmail(), patient.getPatientId());
    }

    @Override
    public void deletePatient(int id) {
        String sql = "DELETE FROM patient WHERE patientId = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Patient findPatientIDByEmail(String email) {
        String sql = "SELECT * FROM patient WHERE email = ? LIMIT 1";
        return jdbcTemplate.queryForObject(sql, new PatientMapper(), email);
    }
}
