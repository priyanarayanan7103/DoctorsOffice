import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AppointmentRoutingModule } from './appointment-routing.module';
import { AppointmentHomeComponent } from './appointment-home/appointment-home.component';
import { FormsModule } from '@angular/forms';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { ProfileService } from '../profile/profile-home/profile.service';

@NgModule({
  declarations: [
    AppointmentHomeComponent
  ],
  providers: [ProfileService],

  imports: [
    CommonModule,
    AppointmentRoutingModule,
    FormsModule,
    NgbModule,
  ]
})
export class AppointmentModule { }
