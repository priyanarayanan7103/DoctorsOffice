package com.sg.wileyedge.dao.mappers;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sg.wileyedge.dto.Doctor;
import org.springframework.jdbc.core.RowMapper;

public class DoctorMapper implements RowMapper<Doctor> {
    @Override
    public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(rs.getInt("doctorId"));
        doctor.setDoctorFName(rs.getString("doctorFName"));
        doctor.setDoctorLName(rs.getString("doctorLName"));
        doctor.setDoctorSpecialtyId(rs.getString("doctorSpecialtyId"));

        doctor.setPhoneNumber(rs.getString("phoneNumber"));
        doctor.setEmail((rs.getString("email")));
        doctor.setImageURL((rs.getString("imageURL")));

        return doctor;
    }
}








