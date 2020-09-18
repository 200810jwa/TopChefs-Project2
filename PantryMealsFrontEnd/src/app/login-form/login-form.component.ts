import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css'],
})
export class LoginFormComponent implements OnInit {
  loginForm = new FormGroup({
    Username: new FormControl(''),
    Password: new FormControl(''),
  });
  //baseURL: string = 'http://localhost:4200/';

  constructor() {} //private http: HttpClient

  ngOnInit(): void {}

  register() {
    console.warn('Switch to Register component?');
  }

  onSubmit() {
    //: Observable<any>
    // const headers = { 'content-type': 'application/json' };
    // const body = JSON.stringify(this.loginForm.value);
    //console.log(body);
    // return this.http.post(this.baseURL + 'loginTemplate', body, {
    //  headers: headers,
    // });
    console.warn(this.loginForm.value);
    //Don't know if this works?
  }
}
