import { HttpBackend } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/User';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserServicesService {
  private baseUrl: String = 'http://localhost:8080/';

  constructor(private http: HttpClient) {}

  updateUser(value: String): Observable<User> {
    return this.http.post<User>(this.baseUrl + '/updateUsers/', value);
  }
}
