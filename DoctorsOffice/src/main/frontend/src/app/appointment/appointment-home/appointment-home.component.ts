import { Component, OnInit } from '@angular/core';
import { appointmentService } from './appointment.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-appointment-home',
  templateUrl: './appointment-home.component.html',
  styleUrls: ['./appointment-home.component.css']
})
export class AppointmentHomeComponent implements OnInit {
  constructor(private appointmentService: appointmentService) {}

  patientFName!: string;
  patientLName!: string;
  dateOfBirth!: string;
  address!: string;
  phoneNumber!: string;
  email!: string;
  appointmentTime!: string;

  showForm: boolean = false;

  toggleForm() {
    this.showForm = !this.showForm;
  }

  register(registerForm: NgForm) {
    this.appointmentService.addPatient(registerForm.value).subscribe(
      (resp) => {
        console.log(resp);
        registerForm.reset();
        this.getPatientDetails();
      },
      (err) => {
        console.log(err);
      }
    );
  }

  patientDetails: any;
  doctorDetails: any;
  specialties: { [doctorId: number]: string } = {};

  getPatientDetails() {
    this.appointmentService.getPatients().subscribe(
      (resp) => {
        console.log(resp);
        this.patientDetails = resp;
      },
      (err) => {
        console.log(err);
      }
    );
  }

  getDoctorDetails() {
    this.appointmentService.getDoctors().subscribe(
      (resp) => {
        this.doctorDetails = resp;
        // Fetch specialties for all doctors
        this.doctorDetails.forEach((doctor: any) => {
          this.getDoctorSpeciality(doctor.doctorId);
        });
      },
      (err) => {
        console.log(err);
      }
    );
  }

  getDoctorSpeciality(doctorId: number): void {
    this.appointmentService.getDoctorSpeciality(doctorId).subscribe(
      (resp) => {
        console.log(resp);
        this.specialties[doctorId] = resp.speciality;
      },
      (err) => {
        console.log(err);
      }
    );
  }

  ngOnInit() {
    this.getPatientDetails();
    this.getDoctorDetails();
  }
}