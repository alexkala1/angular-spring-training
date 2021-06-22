import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../interface/user';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private http: HttpClient) { }

	findById() : Observable<User> {
		return this.http.get<User>(`/api/users/${sessionStorage.getItem('id')}`)
	}

	updateProfile(name: string | null, surname: string | null, email: string | null): Observable<User> {
    return this.http.post<User>('/api/users', {
			name,
			surname,
      email,
			id: sessionStorage.getItem('id'),
			password: sessionStorage.getItem('password')
    });
  }
}
