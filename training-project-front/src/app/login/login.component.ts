import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  hide = true;
  errorMessage = '';
  loginForm = new FormGroup({
    email: new FormControl(''),
    password: new FormControl(''),
  });

  constructor(private loginService: LoginService, private router: Router) {}

  ngOnInit(): void {
		if (sessionStorage.getItem('isLoggedIn'))
			this.router.navigate(['/'])
	}

  login(): void {
    const email = this.loginForm.get('email')?.value;
    const password = this.loginForm.get('password')?.value;

    this.loginService.login(email, password).subscribe(
      (response) => {
        sessionStorage.setItem('isLoggedIn', 'true')
        sessionStorage.setItem('email', response.email!)
        sessionStorage.setItem('name', response.name!)
        sessionStorage.setItem('surname', response.surname!)
        sessionStorage.setItem('id', response.id?.toString()!)

				this.router.navigate(['/'])
        
      },
      (error) => {
				this.errorMessage = error.error.message
			}
    );
  }
}
