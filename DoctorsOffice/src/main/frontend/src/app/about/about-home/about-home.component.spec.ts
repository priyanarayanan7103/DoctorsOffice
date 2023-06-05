import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AboutHomeComponent } from './about-home.component';

describe('AboutHomeComponent', () => {
  let component: AboutHomeComponent;
  let fixture: ComponentFixture<AboutHomeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AboutHomeComponent]
    });
    fixture = TestBed.createComponent(AboutHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
