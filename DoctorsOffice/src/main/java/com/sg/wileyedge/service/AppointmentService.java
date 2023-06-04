package com.sg.wileyedge.service;

import com.sg.wileyedge.dto.Appointment;

import java.util.List;

public interface AppointmentService {

    List<Appointment> getAllAppointments();

    Appointment getAppointmentById(int id);

    Appointment addNewAppointment(Appointment appointment);

    Appointment updateAppointmentData(int id, Appointment appointment);

    void deleteAppointmentById(int id);


}
