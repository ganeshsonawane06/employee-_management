import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  private BaseUrl1:string="http://localhost:8080/user";
  private BaseUrl2:string="http://localhost:8080/employee";
  private BaseUrl3:string="http://localhost:8080/country";

  constructor(private http:HttpClient) { }

  loginCheck(obj){
   return (this.http.post(`${this.BaseUrl1}/login`,obj));
  }
  getAllEMP(){
    return(this.http.get(`${this.BaseUrl2}/getAllEmployee`));
  }
  getAllCountries(){
    return(this.http.get(`${this.BaseUrl3}/getAllCountries`));
  }
  AddEmployee(obj){
    return (this.http.post(`${this.BaseUrl2}/addEmployee`,obj,{responseType:'text'}));


  }
  UpdateEmployee(obj){
    return (this.http.put(`${this.BaseUrl2}/updateEmployee`,obj,
    {responseType:'text'}));
  }

  
  }
