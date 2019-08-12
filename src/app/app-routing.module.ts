import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Demo2Component } from './demo2/demo2.component';
import { Demo1Component } from './demo1/demo1.component';
import { HomeComponent } from './home/home.component';
import{ProfileComponent}from './profile/profile.component';
import { LogoutComponent } from './logout/logout.component';
import { EditprofileComponent } from './editprofile/editprofile.component';
import { OtherprofileComponent } from './otherprofile/otherprofile.component';
import { NotificationsComponent } from './notifications/notifications.component'
const routes: Routes = [
{
  path: '',component: HomeComponent
},
{
  path: 'demo2',component: Demo2Component
},
{
  path: 'otherprofile',component: OtherprofileComponent
},

  {
    path: 'demo1',component: Demo1Component
  },

  {
    path: 'profile',component: ProfileComponent
  },
  
  {
    path: 'logout',component: LogoutComponent
  },
  {
    path: 'editprofile',component: EditprofileComponent
  },
  {
    path: 'notifications',component: NotificationsComponent
  },
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
 