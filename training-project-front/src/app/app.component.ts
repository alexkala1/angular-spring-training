import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'training-project';
	isLoggedIn = sessionStorage.getItem('isLoggedIn')
	fullName = `${sessionStorage.getItem('name')} ${sessionStorage.getItem('surname')}`

	constructor(private router: Router) {}

	logout(): void {
		sessionStorage.removeItem('name')
		sessionStorage.removeItem('surname')
		sessionStorage.removeItem('email')
		sessionStorage.removeItem('id')
		sessionStorage.removeItem('isLoggedIn')

		this.isLoggedIn = null
		this.fullName = ''

		this.router.navigate(['/login'])
	}
}
