import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../data.service'
import { log } from '../log.model';
import { MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-demo2',
  templateUrl: './demo2.component.html',
  styleUrls: ['./demo2.component.css']
})
export class Demo2Component implements OnInit {
  log: log = new log();
  constructor(private router: Router, private dataService: DataService,private snackbar: MatSnackBar) { }
  ngOnInit() {
  }
  loginIn() {

       this.dataService.loginIn(this.log).subscribe(
       res => {
        this.loadSnackBar("Signin Sucessfull!!!");
        console.log(res);
        this.router.navigate(['/profile']);
     }, err => {
      this.loadSnackBar("invalid login Credentials!!!");
        console.log(err);
        this.router.navigate(['/demo2']);
      }
    )
  }
  loadSnackBar(message:string)
  {
    this.snackbar.open(message,"Dismiss",{
      duration: 6000,
    });
}
}


