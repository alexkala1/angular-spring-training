import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { RegisterService } from './register.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent implements OnInit {
  error = '';
  registerForm = new FormGroup({
    name: new FormControl(''),
    surname: new FormControl(''),
    email: new FormControl(''),
    password: new FormControl(''),
    passwordConfirm: new FormControl(''),
  });

  constructor(
    private router: Router,
    private registerService: RegisterService
  ) {}

  ngOnInit(): void {
    if (sessionStorage.getItem('isLoggedIn')) this.router.navigate(['/']);
  }

  register(): void {
    const name = this.registerForm.get('name')?.value;
    const surname = this.registerForm.get('surname')?.value;
    const email = this.registerForm.get('email')?.value;
    const password = this.registerForm.get('password')?.value;

    this.registerService.registerUser(name, surname, email, password).subscribe(
      (response) => this.router.navigate(['/']),
      (error) => (this.error = error.error.message)
    );
  }
}
