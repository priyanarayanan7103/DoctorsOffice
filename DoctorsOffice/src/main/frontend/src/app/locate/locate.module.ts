import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LocateRoutingModule } from './locate-routing.module';
import { LocateHomeComponent } from './locate-home/locate-home.component';


@NgModule({
  declarations: [
    LocateHomeComponent
  ],
  imports: [
    CommonModule,
    LocateRoutingModule
  ]
})
export class LocateModule { }
