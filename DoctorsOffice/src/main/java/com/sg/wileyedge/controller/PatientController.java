package com.sg.wileyedge.controller;

import com.sg.wileyedge.dto.Patient;
import com.sg.wileyedge.service.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@CrossOrigin
public class PatientController {

    @Autowired
    PatientServiceImpl patientServiceImpl;

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientServiceImpl.getAllPatients();
    }

    @PostMapping("/add")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientServiceImpl.addNewPatient(patient);
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable int id) {
        return patientServiceImpl.getPatientById(id);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable int id, @RequestBody Patient patient) {
        return patientServiceImpl.updatePatientData(id, patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable int id) {
        patientServiceImpl.deletePatientById(id);
    }
}
