import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HomeModule } from './home/home.module';
import { AppointmentModule } from './appointment/appointment.module';

// Import auth0 module from the SDK
import { AuthModule } from '@auth0/auth0-angular';
import { AuthButtonComponent } from './auth-button/auth-button.component';

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

    // Copied from auth0 for login authentication
    AuthModule.forRoot({
      domain: 'dev-tsr0hs58jbrfnpmv.us.auth0.com',
      clientId: 'hEP6cN8aMnICcOowCjUENAYwv1Vq1MJH',
      authorizationParams: {
        redirect_uri: window.location.origin
      }
    }),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
