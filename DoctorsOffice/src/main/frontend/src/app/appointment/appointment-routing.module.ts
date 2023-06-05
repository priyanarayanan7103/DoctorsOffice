import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppointmentHomeComponent } from './appointment-home/appointment-home.component';

const routes: Routes = [
  {path: 'appointment', component: AppointmentHomeComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AppointmentRoutingModule { }
