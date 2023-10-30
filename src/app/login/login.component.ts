import { Component } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = "";
  password: string = "";

  constructor(private authService: AuthenticationService, private router: Router) {}

  login(): void {
    console.log("Login success");
    this.authService.login(this.username, this.password).subscribe(() => {
      console.log("I came back");
        this.router.navigate(['/home']);
      });
    };

}
