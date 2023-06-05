import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LocateHomeComponent } from './locate-home/locate-home.component';

const routes: Routes = [
  {path: 'locate', component: LocateHomeComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LocateRoutingModule { }
