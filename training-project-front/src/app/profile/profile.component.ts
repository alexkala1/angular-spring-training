import { Component, OnInit, ɵRender3ComponentFactory } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../interface/user';
import { ProfileService } from './profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss'],
})
export class ProfileComponent implements OnInit {
	user :User | undefined;
  error: string = '';
  profileForm = new FormGroup({
    name: new FormControl(sessionStorage.getItem('name')),
    surname: new FormControl(sessionStorage.getItem('surname')),
    email: new FormControl(sessionStorage.getItem('email')),
    password: new FormControl(null),
    passwordConfirm: new FormControl(null),
  });

  name = sessionStorage.getItem('name');
  surname = sessionStorage.getItem('surname');
  email = sessionStorage.getItem('email');

  constructor(private router: Router, private profileService: ProfileService) {}

  ngOnInit(): void {
    this.initializeForm();
		this.profileService.findById().subscribe(response => this.user = response);
  }

  initializeForm(): void {
    this.profileForm = new FormGroup({
      name: new FormControl(sessionStorage.getItem('name')),
      surname: new FormControl(sessionStorage.getItem('surname')),
      email: new FormControl(sessionStorage.getItem('email')),
      password: new FormControl(null),
      passwordConfirm: new FormControl(null),
    });
  }

  updateProfile(): void {
		const name = this.profileForm.get('name')?.value
		const surname = this.profileForm.get('surname')?.value
		const email = this.profileForm.get('email')?.value

    this.profileService
      .updateProfile(name, surname, email)
      .subscribe(
        (response) => {
					sessionStorage.removeItem('name')
					sessionStorage.setItem('name', response.name!)

					sessionStorage.removeItem('surname')
					sessionStorage.setItem('surname', response.surname!)

					sessionStorage.removeItem('email')
					sessionStorage.setItem('email', response.email!)
				
					this.router.navigate(['/'])
				},
        (error) => (this.error = error.error.message)
      );
  }
}
