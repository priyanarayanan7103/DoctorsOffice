import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LocateRoutingModule } from './locate-routing.module';
import { LocateHomeComponent } from './locate-home/locate-home.component';

import { GoogleMapsModule } from '@angular/google-maps'

@NgModule({
  declarations: [
    LocateHomeComponent
  ],
  imports: [
    CommonModule,
    LocateRoutingModule,
    GoogleMapsModule
  ]
})
export class LocateModule { }
