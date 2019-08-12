import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user.model';
import {DataService} from '../data.service';
import { MatSnackBar} from '@angular/material/snack-bar';
@Component({
  selector: 'app-demo1',
  templateUrl: './demo1.component.html',
  styleUrls: ['./demo1.component.css']
})

export class Demo1Component implements OnInit {
user:User=new User();
  constructor (private dataService:DataService,private router: Router,private snackbar: MatSnackBar) { }
ngOnInit() {
}
createUser(){
console.log(this.user);
this.dataService.createUsers(this.user).subscribe(res => {
  console.log(res);
  this.loadSnackBar("Signup Sucessfull!!!");
this.router.navigate(['/demo2']);
}) ;
}

loadSnackBar(message:string)
  {
    this.snackbar.open(message,"Dismiss",{
      duration: 6000,
    });
}

}