import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../interface/user';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  constructor(private http: HttpClient) {}

  registerUser(name: string, surname: string, email: string, password: string): Observable<User> {
    return this.http.post<User>('/api/users', {
			name,
			surname,
      email,
      password,
    });
  }
}
