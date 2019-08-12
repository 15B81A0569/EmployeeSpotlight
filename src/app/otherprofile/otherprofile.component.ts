
import { others } from '../others.model';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../data.service';
import{reg}from '../reg.model'
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-otherprofile',
  templateUrl: './otherprofile.component.html',
  styleUrls: ['./otherprofile.component.css']
})
export class OtherprofileComponent implements OnInit {
  

  show:any;


  constructor (private dataService:DataService, private router: Router, private http: HttpClient) { }

  
ngOnInit() {
  this.getprofile1();
  

}

getprofile1(){

  this.http.get("http://localhost:8080/otherprofile").subscribe((response)=>{
      console.log(response);
      this.show = Object.assign({}, response);
      

    });
  }
   

 
}
