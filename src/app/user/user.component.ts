import { Component } from '@angular/core';
import { SearchService } from '../search.service';
import { HomeServiceService } from '../home-service.service';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {
  constructor(private searchService: SearchService, private homeService: HomeServiceService, private router:Router, private authSrvice: AuthenticationService) {}
  ngOnInit(): void {
    if(!this.authSrvice.checkLoggedInUser()){
      this.router.navigate(['']);
    }
  }
  username: string | null = localStorage.getItem('username');
}
