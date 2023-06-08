import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileHomeComponent } from './profile-home.component';

describe('ProfileHomeComponent', () => {
  let component: ProfileHomeComponent;
  let fixture: ComponentFixture<ProfileHomeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProfileHomeComponent]
    });
    fixture = TestBed.createComponent(ProfileHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
