import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpService } from '../http-service.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {
  
  allCountry:any={
    message:'',
    country:'',
    countries:[]
  };
  countryname:any[]=[];

  constructor(private service:HttpService,
             private router:Router)  { }

  ngOnInit() {
    this.GetAllCountry();
  }
  GetAllCountry(){
    this.service.getAllCountries().subscribe((responce)=>{
      this.allCountry=(<any>responce);
      this.countryname=(this.allCountry.countries);

      console.log(this.countryname);
      
    });

  }
  onSubmit(f:NgForm){
    let obj={
    firstName:f.value.name,
    department:f.value.department,
    status:f.value.status,
    mobileNumber:f.value.phoneno,
    updateBy:sessionStorage.getItem("firstName"),
  
    country:{
      country:f.value.country.country,
      countryId:f.value.country.countryId
      }
    
  }
  this.service.AddEmployee(obj)
.subscribe((responce)=>{
  console.log(responce);
  this.router.navigate(["/home"]);


})

  }
  
}


