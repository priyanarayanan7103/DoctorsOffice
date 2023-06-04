package com.sg.wileyedge.dao.mappers;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sg.wileyedge.dto.Patient;
import org.springframework.jdbc.core.RowMapper;

public class PatientMapper implements RowMapper<Patient> {
    @Override
    public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
        Patient patient = new Patient();
        patient.setPatientId(rs.getInt("patientId"));
        patient.setPatientFName(rs.getString("patientFName"));
        patient.setPatientLName(rs.getString("patientLName"));
        patient.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
        patient.setAddress(rs.getString("address"));
        patient.setPhoneNumber(rs.getString("phoneNumber"));
        patient.setEmail(rs.getString("email"));
        return patient;
    }
}
