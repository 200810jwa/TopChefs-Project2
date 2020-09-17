import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

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

  constructor() {}

  ngOnInit(): void {}

  onSubmit() {
    console.warn(this.loginForm.value);
  }
}
