package com.sg.wileyedge.service;

import com.sg.wileyedge.dao.AppointmentDao;
import com.sg.wileyedge.dto.Appointment;

import java.time.LocalDateTime;
import java.util.List;

public class AppointmentDaoStubImpl implements AppointmentDao {

    public Appointment onlyAppointment;

    public AppointmentDaoStubImpl(){
        onlyAppointment = new Appointment();
        onlyAppointment.setAppointmentId(100);
        onlyAppointment.setTime(LocalDateTime.now());
        onlyAppointment.setStatus("Test");
        onlyAppointment.setPatientId(-1);
        onlyAppointment.setDoctorId(-2);
    }

    @Override
    public Appointment createNewAppointment(Appointment appointment) {
        if(appointment.getAppointmentId() < 0
                || appointment.getStatus() == "" || appointment.getDoctorId() < 0
                || appointment.getPatientId() < 0){
            appointment.setStatus("Appointment not added");
        }
        return appointment;
    }

    @Override
    public List<Appointment> getAllAppointments(){
        return null;
    }

    @Override
    public Appointment findAppointmentById(int id) {
        if(onlyAppointment.getAppointmentId() != id){
            onlyAppointment.setStatus("Appointment not found");
        }
        return onlyAppointment;
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        onlyAppointment.setAppointmentId(appointment.getAppointmentId());
        onlyAppointment.setTime(appointment.getTime());
        onlyAppointment.setStatus(appointment.getStatus());
        onlyAppointment.setPatientId(appointment.getPatientId());
        onlyAppointment.setDoctorId(appointment.getDoctorId());
    }

    @Override
    public void deleteAppointment(int id) {

    }

    @Override
    public void deleteAllAppointments() {

    }


}
