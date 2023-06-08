import { Component } from '@angular/core';
import { AuthService } from '@auth0/auth0-angular';
import { map } from 'rxjs/operators';
import { ProfileService } from './profile.service';

@Component({
  selector: 'app-profile-home',
  templateUrl: './profile-home.component.html',
  styleUrls: ['./profile-home.component.css']
})
export class ProfileHomeComponent {
  profileJson: string = "";

  constructor(public auth: AuthService, private profileService: ProfileService) {}

  ngOnInit(): void {
    this.auth.user$.subscribe(
      (profile) => {
        this.profileJson = JSON.stringify(profile, null, 2);
        this.profileService.setProfileData(this.profileJson);
      }
    );
  }
}
