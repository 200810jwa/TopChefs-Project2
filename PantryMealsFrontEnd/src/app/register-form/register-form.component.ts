import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service'
import { environment } from '../../environments/environment';
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
  Auth: AuthenticationService;

  constructor(private router: Router) { }

  ngOnInit(): void { }

  onSubmit() {
    try {
      console.warn(this.registerForm.value);
      this.Auth.registerService(this.registerForm.get('username').value, this.registerForm.get('password').value, this.registerForm.get('firstName').value,
        this.registerForm.get('lastName').value, this.registerForm.get('email').value);
      this.router.navigate(['login']);
    } catch (error) {
      console.warn("there was an error");
    }


  }
}
