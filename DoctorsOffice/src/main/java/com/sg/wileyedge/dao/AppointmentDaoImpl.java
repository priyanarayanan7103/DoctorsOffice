package com.sg.wileyedge.dao;

import com.sg.wileyedge.dao.mappers.AppointmentMapper;
import com.sg.wileyedge.dto.Appointment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppointmentDaoImpl implements AppointmentDao {
    private final JdbcTemplate jdbcTemplate;

    public AppointmentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Appointment createNewAppointment(Appointment appointment) {
        String sql = "INSERT INTO appointment (appointmentId, time, doctorId, patientId, status) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, appointment.getAppointmentId(), appointment.getTime(), appointment.getDoctorId(), appointment.getPatientId(), appointment.getStatus());
        return appointment;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        String sql = "SELECT * FROM appointment";
        return jdbcTemplate.query(sql, new AppointmentMapper());
    }

    @Override
    public Appointment findAppointmentById(int id) {
        String sql = "SELECT * FROM appointment WHERE appointmentId = ?";
        return jdbcTemplate.queryForObject(sql, new AppointmentMapper(), id);
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        String sql = "UPDATE appointment SET time = ?, doctorId = ?, patientId = ?, status = ? WHERE appointmentId = ?";
        jdbcTemplate.update(sql, appointment.getTime(), appointment.getDoctorId(), appointment.getPatientId(), appointment.getStatus(), appointment.getAppointmentId());
    }

    @Override
    public void deleteAppointment(int id) {
        String sql = "DELETE FROM appointment WHERE appointmentId = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void deleteAllAppointments() {
        String sql = "DROP TABLE appointments";
        jdbcTemplate.execute(sql);
    }
}
