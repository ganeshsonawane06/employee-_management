import { Component, OnInit, TemplateRef } from '@angular/core';
import { Route, Router } from '@angular/router';
import { HttpService } from '../http-service.service';
import {BsModalService,BsModalRef} from 'ngx-bootstrap/modal'
import { Employee } from './Employee';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  isRadioClick:boolean=false;

  EmpData:any={
    employee:'',
    employees:[],
    message:''
  };
  ModalRef:BsModalRef;
  config={
    animeted:true,
    ignoreBackdropdClick:true,
    class:"alert alert-danger"
  };
  Empobj=<Employee>{};
  data:any[]=[];


  constructor(private service:HttpService,
              private router:Router,private modalservice:BsModalService) { }

  ngOnInit() {
    this.GetAllRecord();
  }

  GetAllRecord(){
      this.service.getAllEMP()
      .subscribe((response)=>{
        // console.log(response);
        this.EmpData=(<any>response);
        this.data=this.EmpData.employees;
        // console.log(this.EmpData.employees);
       
      })
  }
  onaddEmployee(){
    this.router.navigate(["/addEmployee"]);
  }
  oradioclick(item){
    this.isRadioClick=true;
    console.log(item);
    this.Empobj=item;
  }
  RadioCheck(){
    if (this.isRadioClick==true){
      return true;
    }
    else{
      return false;
    }
  }
  onEdit(popup:TemplateRef<any>){
    if (this.RadioCheck()){
      this.ModalRef =this.modalservice.show(popup,this.config)

    }
    else{
      alert("Please Select Record To Update.....")
    }
  }

}
