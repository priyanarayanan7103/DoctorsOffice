package com.sg.wileyedge.service;

import com.sg.wileyedge.dao.AppointmentDao;
import com.sg.wileyedge.dto.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    AppointmentDao appointmentDao;

    public AppointmentServiceImpl(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentDao.getAllAppointments();
    }

    @Override
    public Appointment getAppointmentById(int id) {
        try {
            return appointmentDao.findAppointmentById(id);
        } catch(DataAccessException e){
            Appointment appointment = new Appointment();
            appointment.setAppointmentId(0);
            appointment.setStatus("Appointment does not exist");
            return appointment;
        }
    }

    @Override
    public Appointment addNewAppointment(Appointment appointment) {
        if(appointment.getAppointmentId() == 0){
            appointment.setStatus("Appointment not added.");
            return appointment;
        }
        return appointmentDao.createNewAppointment(appointment);
    }

    @Override
    public Appointment updateAppointmentData(int id, Appointment appointment) {
        if(id != appointment.getAppointmentId()){
            appointment.setAppointmentId(0);
            appointment.setStatus("Appointment not updated: ID's do not match");
            return appointment;
        }

        Appointment updatedAppointment = appointmentDao.findAppointmentById(id);
        if(updatedAppointment != null){
            updatedAppointment.setAppointmentId(appointment.getAppointmentId());
            updatedAppointment.setTime(appointment.getTime());
            updatedAppointment.setStatus(appointment.getStatus());
            updatedAppointment.setPatientId(appointment.getPatientId());
            updatedAppointment.setDoctorId(appointment.getDoctorId());
        }
        return updatedAppointment;
    }

    @Override
    public void deleteAppointmentById(int id) {
        appointmentDao.deleteAppointment(id);
        System.out.println("Appointment number " + id + " deleted");
    }
}
