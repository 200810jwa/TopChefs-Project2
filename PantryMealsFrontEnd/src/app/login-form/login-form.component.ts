import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { User } from '../models/User';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css'],
})
export class LoginFormComponent implements OnInit {
  public username: String;
  public password: String;
  baseURL: string = 'http://localhost:8085/Project2/';
  // baseURL: string = 'http://ec2-3-137-136-86.us-east-2.compute.amazonaws.com:8085/TopChefs-Project2/';

  constructor(private router: Router, private http: HttpClient) {} //private http: HttpClient

  ngOnInit(): void {}

  goToRegister() {
    this.router.navigate(['register-form']);
    console.warn('Switch to Register component?');
  }
  async Login(): Promise<void> {
    console.log("logging in...");
    try {
      let user = await this.http.post<User>(
        this.baseURL + 'login',
        { username: this.username,
        password: this.password}
      ).toPromise();
      
      sessionStorage.setItem("currentUser", JSON.stringify(user));  
      this.router.navigateByUrl("/home");
    } catch (error) {
      console.log(error);
      alert('Failed to Login');
    }
    
  }
  onSubmit() {
    // const promise = new Promise(function(resolve,reject)){

    // }
    // const headers = { 'content-type': 'application/json' };
    //let body = JSON.parse(this.loginForm.value);
    //let baseURL = 'http.localhost:4200/';
    // const body = JSON.stringify(this.loginForm.value);
    //console.log(body);
    //return this.http.post(baseURL + 'login', body, {
    //Returns user class?
    //response = sessionStorage.setItem('currentUser');
    // });

    this.router.navigate(['home']);
  }
}
