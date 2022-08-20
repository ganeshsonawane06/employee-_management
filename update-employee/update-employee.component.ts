import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http-service.service';
import { Employee } from '../Modal/Employee';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {
  allcountry:any[]=[];
  issubmitDissabled:boolean=true;

  backendResponce:string='';
   parentdat=<Employee>{};

  constructor(private service:HttpService) { }

  ngOnInit() {
    this.Getallcountry();
  }
  Getallcountry(){
    this.service.getAllCountries().subscribe((responce)=>{
      this.allcountry=(<any>responce);


    })

  }
  onupdate(){
    this.issubmitDissabled=false;
    this.parentdat.updatedby=sessionStorage.getItem("firstName");
    this.parentdat.updateddtm=Date.now();
    this.service.UpdateEmployee(this.parentdat).subscribe((responce)=>{
    this.backendResponce=responce;
    })
  }

}

