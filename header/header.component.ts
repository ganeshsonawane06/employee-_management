import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  firstName:string='';

  
  constructor(private router:Router,
              ) { }

  ngOnInit() {
    this.firstName=sessionStorage.getItem("firstName");
  }

  onLogout(){
        sessionStorage.removeItem("firstName");
        sessionStorage.clear();
        this.router.navigate(['/login'])
  }

}