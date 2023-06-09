import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Specialty } from './specialty.interface';

@Injectable({
  providedIn: 'root'
})
export class AboutService {
  private baseUrl = 'http://localhost:8080'; // Update with your API endpoint

  constructor(private http: HttpClient) {}

  getAllSpecialties(): Observable<Specialty[]> {
    const url = `${this.baseUrl}/doctor/specialities`;
    return this.http.get<Specialty[]>(url);
  }
}