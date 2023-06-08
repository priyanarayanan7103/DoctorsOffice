import { Component, OnInit } from '@angular/core';
import { AboutService } from './about.service';
import { Specialty } from './specialty.interface';

@Component({
  selector: 'app-about-home',
  templateUrl: './about-home.component.html',
  styleUrls: ['./about-home.component.css']
})
export class AboutHomeComponent implements OnInit {
  specialties: Specialty[] = [];

  constructor(private aboutService: AboutService) {}

  ngOnInit() {
    this.getSpecialties();
  }

  getSpecialties() {
    this.aboutService.getAllSpecialties().subscribe(
      (resp) => {
        this.specialties = resp;
        console.log(this.specialties);
      },
      (err) => {
        console.log(err);
      }
    );
  }
}