import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
//https://angular.io/start/start-forms
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  LoginForm;
  username;
  password;

  constructor(private formBuilder: FormBuilder) {
    this.LoginForm = this.formBuilder.group({
      Username: '',
      Password: '',
    });
  }

  ngOnInit(): void {}

  async Register() {}

  onSubmit(LoginFormData) {
    // Pull the information from the form upon the submit button
    this.username = this.username;
    this.password = this.password;
    //Is this calling the right variables?

    console.log(
      'Your Login has been submitted' + this.username + this.password
    );
  }
}
