import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from '../models/user';
import { Router } from '@angular/router';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
  private baseUrl: String = 'http://localhost:8081/';
  private currentUser: User;

  constructor(private http: HttpClient, private router: Router) { }

  public async loginService(username: String, password: String) {
    let lf = { username, password } // Need to pass this through as a logintemplate?
    return this.http.post<User>(this.baseUrl + '/login', lf);
  }
  public async registerService(username: String, password: String, firstName: String, lastName: String, email: String) {
    let rg = { username, password, firstName, lastName, email } // Need to pass this through as a Registertemplate?
    return this.http.put<User>(this.baseUrl + '/login', rg);
  }

  public async logoutService() { }
}
