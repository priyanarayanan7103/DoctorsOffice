import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HomeModule } from './home/home.module';
import { AppointmentModule } from './appointment/appointment.module';
import { ProfileModule } from './profile/profile.module';
import { HttpClientModule } from '@angular/common/http';


// Import auth0 module from the SDK
import { AuthModule } from '@auth0/auth0-angular';
import { AuthButtonComponent } from './auth-button/auth-button.component';
import { AboutModule } from './about/about.module';
import { LocateModule } from './locate/locate.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


@NgModule({
  declarations: [
    AppComponent,
    AuthButtonComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HomeModule,
    AppointmentModule,
    AboutModule,
    LocateModule,
    HttpClientModule,
    ProfileModule,

    // Copied from auth0 for login authentication
    AuthModule.forRoot({
      domain: 'dev-tsr0hs58jbrfnpmv.us.auth0.com',
      clientId: 'hEP6cN8aMnICcOowCjUENAYwv1Vq1MJH',
      authorizationParams: {
        redirect_uri: window.location.origin
      }
    }),
      NgbModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
