import { Component } from '@angular/core';
import { appointmentService } from './appointment.service';
import { NgForm } from '@angular/forms';



@Component({
  selector: 'app-appointment-home',
  templateUrl: './appointment-home.component.html',
  styleUrls: ['./appointment-home.component.css']
})

export class AppointmentHomeComponent  {

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
        //console.log(resp);
        this.doctorDetails = resp;
      },
      (err) => {
        console.log(err);
      }
    );
  }

  getDoctorSpeciality(doctorId: number): string {
    let specialty: string = "test";
    this.appointmentService.getDoctorSpeciality(doctorId).subscribe(
      (resp) => {
        console.log(resp);
         specialty = resp as string;
      },
      (err) => {
        console.log(err);
      }
    );
    return specialty;
  }
}

