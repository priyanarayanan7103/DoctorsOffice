package com.sg.wileyedge.service;

import com.sg.wileyedge.dao.DoctorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    DoctorDao doctorDao;

    public DoctorServiceImpl(DoctorDao doctorDao){this.doctorDao = doctorDao;}

    @Autowired
    AppointmentServiceImpl appointmentService;
}
