import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

	isLoggedIn(): boolean {
		if (sessionStorage.getItem('isLoggedIn')) {
			return true;
		}

		return false;
	}
}
