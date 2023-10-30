import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  checkLogin: boolean = false;

  constructor(private router: Router) {}

  ngOnInit(): void {
    var username: string | null = localStorage.getItem("username");
    if (username !== null && username !== "") {
      this.checkLogin = true;
    }
    console.log(this.checkLogin);
  }
}

