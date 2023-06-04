package com.sg.wileyedge.dao;

import com.sg.wileyedge.dto.Appointment;

import java.util.List;

public interface AppointmentDao {

    Appointment createNewAppointment(Appointment appointment);

    List<Appointment> getAllAppointments();

    Appointment findAppointmentById(int id);

    void updateAppointment(Appointment appointment);

    void deleteAppointment(int id);

    void deleteAllAppointments();

}
