import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { Demo1Component } from './demo1/demo1.component';
import {HttpClientModule} from '@angular/common/http';
import{RouterModule,Routes} from '@angular/router';
import { HomeComponent } from './home/home.component';
import { Demo2Component } from './demo2/demo2.component';
import { DataService } from './data.service';
import {FormsModule} from '@angular/forms';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { ProfileComponent } from './profile/profile.component';
import { LogoutComponent } from './logout/logout.component';
import { EditprofileComponent } from './editprofile/editprofile.component';
import { NotificationsComponent } from './notifications/notifications.component';
import {ReactiveFormsModule}  from '@angular/forms';
import { OtherprofileComponent } from './otherprofile/otherprofile.component'
import { AppMaterialModules } from './material.module';

@NgModule({
  declarations: [
    AppComponent,
    Demo1Component,
    HomeComponent,
    Demo2Component,
    ProfileComponent,
    LogoutComponent,
    EditprofileComponent,
    NotificationsComponent,
    OtherprofileComponent,
    
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppMaterialModules,
    MatSnackBarModule


  ],
  providers: [ DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
