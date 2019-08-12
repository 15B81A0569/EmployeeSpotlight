import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user.model';
import{log } from './log.model';
import{HttpHeaders}from '@angular/common/http';
import { reg } from  './reg.model'
import{show} from './show.model'

@Injectable({
  providedIn: 'root'
})
export class DataService {
  

  constructor( private _http: HttpClient) { }
  
  createUsers(userData){
    const httpOptions = {
      headers: new HttpHeaders({
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET, POST, PATCH, PUT, DELETE, OPTIONS',
      'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token'
      })
      };
      return this._http.post("http://localhost:8080/save-user", userData, httpOptions);
  }
 
  loginIn(logData){
    const httpOptions = {
      headers: new HttpHeaders({
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET, POST, PATCH, PUT, DELETE, OPTIONS',
      'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token'
      })
      };
    return this._http.post("http://localhost:8080/login",logData, httpOptions);
  }
  register(regData){
    const httpOptions = {
      headers: new HttpHeaders({
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET, POST, PATCH, PUT, DELETE, OPTIONS',
      'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token'
      })
      };
    return this._http.put("http://localhost:8080/updateProfile",regData,httpOptions);
  }
  sendothers(reg1Data){
    const httpOptions = {
      headers: new HttpHeaders({
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET, POST, PATCH, PUT, DELETE, OPTIONS',
      'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token'
      })
      };
    return this._http.put("http://localhost:8080/search",reg1Data,httpOptions);
  }
  
  getprofile(){
  }
  getprofile1(){
  }
    
}
