import { Component } from '@angular/core';

@Component({
  selector: 'app-locate-home',
  templateUrl: './locate-home.component.html',
  styleUrls: ['./locate-home.component.css']
})
export class LocateHomeComponent {
  // component.ts
  
  myLatLng = { lat: 40.7374, lng: -74.0282 }; // Map Options
  mapOptions: google.maps.MapOptions = {
    center: this.myLatLng,
    zoom: 14,
  };

  markerOptions: google.maps.MarkerOptions = {};

  spots: { id: number; lat: number; lng: number }[] = [
    { id: 1, lat: 40.7374, lng: -74.0282 },
  ];

}
