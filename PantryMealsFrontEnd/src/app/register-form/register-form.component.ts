import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service'
import { environment } from '../../environments/environment';
import { User } from '../models/User';

import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css'],
})
export class RegisterFormComponent implements OnInit {
  registerForm = new FormGroup({
    Username: new FormControl(''),
    Password: new FormControl(''),
    FirstName: new FormControl(''),
    LastName: new FormControl(''),
    Email: new FormControl(''),
  });
  Auth: AuthenticationService;
  baseURL = environment.baseURL;
  constructor(private router: Router, private http: HttpClient) { }

  private id: number;
  private username: String;
  private firstName: String;
  private lastName: String;
  private email: String;
  private password: String;

  ngOnInit(): void { }

  onSubmit() {
    try {
      let results = this.http.post<User>(
        this.baseURL + 'newUser',
        {
          username: this.registerForm.get('Username').value,
          password: this.registerForm.get('Password').value,
          firstName: this.registerForm.get('FirstName').value,
          LastName: this.registerForm.get('LastName').value,
          email: this.registerForm.get('Email').value,
        }
      );
      console.log(results);
    } catch (error) {
      console.log(error);
      alert('Failed to submit');
    }
    console.warn(this.registerForm.value);
    this.router.navigate(['login']);
  }
}
