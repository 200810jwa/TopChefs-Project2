import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css'],
})
export class RegisterFormComponent implements OnInit {
  registerForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    email: new FormControl(''),
  });

  constructor() {}

  ngOnInit(): void {}

  onSubmit() {
    console.warn(this.registerForm.value);
  }
}
