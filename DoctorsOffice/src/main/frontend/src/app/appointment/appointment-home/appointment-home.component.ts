import { Component } from '@angular/core';
import { appointmentService } from './appointment.service';
import { NgForm } from '@angular/forms';



@Component({
  selector: 'app-appointment-home',
  templateUrl: './appointment-home.component.html',
  styleUrls: ['./appointment-home.component.css']
})

export class AppointmentHomeComponent {

  constructor(private appointmentService: appointmentService) {
    this.getDoctorDetails();
  }
  patientFName!: string;
  patientLName!: string;
  dateOfBirth!: string;
  address!: string;
  phoneNumber!: string;
  email!: string;
  appointmentTime!: string;
  doctorId!: number;
  status!: string;
  time!: Date;
  patientId!: number;

  showForm: boolean = false;

  toggleForm() {
    this.showForm = !this.showForm;
  }

  selectedDoctor: any = null;

  showFormForDoctor(doctor: any) {
    this.selectedDoctor = doctor;
  }

  register(registerForm: NgForm) {
    this.appointmentService.addPatient(registerForm.value).subscribe(
      (resp) => {
        console.log(resp);
        this.getPatientDetails();
      },
      (err) => {
        console.log(err);
      }
    );
    const appointmentData = {
      doctorId : this.selectedDoctor.doctorId,
      patientId: 2,
      time: "2023-06-03T10:00:00",
      status: "Scheduled"
    }
    console.log(appointmentData)

    this.appointmentService.addAppointment(appointmentData).subscribe(
      (resp) => {
        console.log(resp);
        registerForm.reset();
        this.getAppointmentDetails();
      },
      (err) => {
        console.log(err);

      }
    );
  }

  appointmentDetails = null as any;
  getAppointmentDetails() {
    this.appointmentService.getAppointments().subscribe(
      (resp) => {
        console.log(resp);
        this.appointmentDetails = resp;
      },
      (err) => {
        console.log(err);
      }
    );
  }

  patientDetails = null as any;
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

  doctorDetails = null as any;

  getDoctorDetails() {
    this.appointmentService.getDoctors().subscribe(
      (resp) => {
        console.log(resp);
        this.doctorDetails = resp;
      },
      (err) => {
        console.log(err);
      }
    );
  }
}

