import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  RegisterForm;
  Username;
  Password;
  FirstName;
  LastName;
  email;

  constructor(private formBuilder: FormBuilder) {
    this.RegisterForm = this.formBuilder.group({
      Username: '',
      Password: '',
      FirstName: '',
      LastName: '',
      email: '',
    });
  }

  ngOnInit(): void {}

  onSubmit(RegisterData) {
    // Pull the information from the form upon the submit button
    this.Username = this.Username;
    this.Password = this.Password;
    this.FirstName = this.FirstName;
    this.LastName = this.LastName;
    this.email = this.email;
    //Is this calling the right variables?

    console.log('You have registration has been submitted');
  }

  async GoBack() {}
}
