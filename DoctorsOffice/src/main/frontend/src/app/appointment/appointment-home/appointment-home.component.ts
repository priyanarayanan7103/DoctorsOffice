import { Component } from '@angular/core';
import { appointmentService } from './appointment.service';



@Component({
  selector: 'app-appointment-home',
  templateUrl: './appointment-home.component.html',
  styleUrls: ['./appointment-home.component.css']
})

export class AppointmentHomeComponent {

  constructor(private appointmentService: appointmentService) {
    this.getDoctors();
  }
  doctorDetails = null as any;

  getDoctors() {
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

