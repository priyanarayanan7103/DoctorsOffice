package com.sg.wileyedge.dao.mappers;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sg.wileyedge.dto.Appointment;
import org.springframework.jdbc.core.RowMapper;
public class AppointmentMapper implements RowMapper<Appointment> {
    @Override
    public Appointment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(rs.getInt("appointment_id"));
        appointment.setTime(rs.getTimestamp("appointment_time").toLocalDateTime());
        appointment.setStatus(rs.getString("status"));
        appointment.setDoctorId(rs.getInt("doctor_id"));
        appointment.setPatientId(rs.getInt("patient_id"));
        return appointment;

    }
}







