import { TestBed } from '@angular/core/testing';

import { appointmentService } from './appointment.service'

describe('appointmentService', () => {
  let service: appointmentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(appointmentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
