import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class appointmentService {
  constructor(private http: HttpClient) { }

  API = 'http://localhost:8080';

  public getDoctors() {
    return this.http.get(this.API + '/doctor/doctors');
  }
  public getPatients() {
    return this.http.get(this.API + '/patient/patients');
  }

  public addPatient(patientData: any) {
    return this.http.post(this.API + '/patient/add', patientData);
  }

  public addAppointment(appointmentData: any) {
    return this.http.post(this.API + '/appointment/add', appointmentData);
  }
}
