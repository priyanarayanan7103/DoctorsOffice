import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LocateHomeComponent } from './locate-home.component';

describe('LocateHomeComponent', () => {
  let component: LocateHomeComponent;
  let fixture: ComponentFixture<LocateHomeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LocateHomeComponent]
    });
    fixture = TestBed.createComponent(LocateHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
