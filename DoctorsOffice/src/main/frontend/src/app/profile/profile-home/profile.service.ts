import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  private profileData: String | undefined;

  setProfileData(profile: any) {
    this.profileData = profile;
  }

  getProfileData() {
    return this.profileData;
  }
}
