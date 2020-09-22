import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

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

  constructor(private router: Router, private http: HttpClient) {} //private http: HttpClient

  ngOnInit(): void {}

  goToRegister() {
    this.router.navigate(['register-form']);
    console.warn('Switch to Register component?');
  }
  Login(): void {
    sessionStorage.setItem("currentUser", "test");
    this.router.navigateByUrl("/home");
  }
  onSubmit() {
    //: Observable<any>
    // const headers = { 'content-type': 'application/json' };
    // const body = JSON.stringify(this.loginForm.value);
    //console.log(body);
    // return this.http.post(this.baseURL + 'loginTemplate', body, {
    //  headers: headers,
    // });
    this.router.navigate(['profile']);
    console.warn(this.loginForm.value);
    //Don't know if this works?
  }
}
