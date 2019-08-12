import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../data.service';
import{reg}from '../reg.model'
import { HttpClient } from '@angular/common/http';
import { others } from '../others.model';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  others: others = new others();
  myControl = new FormControl();
  options: string[] = ['jyothsna',
'mahesh',
'diiya',
'anusha',
'sid',
'manu',
'mayuri',
'asha'];
  filteredOptions: Observable<string[]>

  show:any;


  constructor (private dataService:DataService, private router: Router, private http: HttpClient) { }

  
ngOnInit() {
  this.filteredOptions = this.myControl.valueChanges
  .pipe(
    startWith(''),
    map(value => this._filter(value))
  );
  this.getprofile();

}

getprofile(){

  this.http.get("http://localhost:8080/getProfile").subscribe((response)=>{
      console.log(response);
      this.show = Object.assign({}, response);
      

    });
  }
  sendothers() {

    this.dataService.sendothers(this.others).subscribe(
    res => {
     console.log(res);
     this.router.navigate(['/otherprofile']);
     
     
  }, err => {
     console.log(err);
     
   }
 )
}

private _filter(value: string): string[] {
  const filterValue = value.toLowerCase();

  return this.options.filter(option => option.toLowerCase().includes(filterValue));
}

 
}
