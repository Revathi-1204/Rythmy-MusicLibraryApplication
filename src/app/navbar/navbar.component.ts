import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  searchTerm: string = '';
  checkLogin: boolean = false;

  constructor(private authservice: AuthenticationService, private router: Router){}
  ngOnInit(): void {
    var username: string | null = localStorage.getItem("username");
    if (username !== null && username !== "") {
      this.checkLogin = true;
    }
    console.log(this.checkLogin);
  }

  logoutApp()
  {
    this.authservice.logout();
    this.router.navigate(['']);
  }
}
