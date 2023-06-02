package com.sg.wileyedge.service;

import com.sg.wileyedge.dao.PatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    PatientDao patientDao;

    public PatientServiceImpl(PatientDao patientDao){this.patientDao = patientDao;}

    @Autowired
    AppointmentServiceImpl appointmentService;
}
