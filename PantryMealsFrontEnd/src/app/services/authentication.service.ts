import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from '../models/user';
import { Router } from '@angular/router';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
  private currentUser: User;

  constructor(private http: HttpClient, private router: Router) {}

  public async loginService(username: String, password: String) {
    //Build out promise here?
  }

  public async logoutService() {}
}
