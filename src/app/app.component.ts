import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DataService } from './data.service';
import { User } from './user.model';
import { Subscriber, from } from 'rxjs';
import{log} from './log.model'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  constructor(){}
        

    ngOnInit(){
    

  }
}
  


    
    