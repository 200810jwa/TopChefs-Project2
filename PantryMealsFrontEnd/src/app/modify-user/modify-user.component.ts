import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { UserServicesService } from 'src/app/services/user-services.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/User';
import { environment } from '../../environments/environment';
@Component({
  selector: 'app-modify-user',
  templateUrl: './modify-user.component.html',
  styleUrls: ['./modify-user.component.css'],
})
export class ModifyUserComponent implements OnInit {
  modifyForm = new FormGroup({
    FirstName: new FormControl(''),
    LastName: new FormControl(''),
    Email: new FormControl(''),
    Password: new FormControl(''),
  });

  private id: number;
  private username: String;
  private firstName: String;
  private lastName: String;
  private email: String;
  private password: String;
  baseUrl = environment.baseURL;
  // userService = UserServicesService;
  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void { }

  async update() {
    let cu = sessionStorage.getItem("currentUser");
    let User = JSON.parse(cu);
    //console.log(User);

    //Doesn't work at the moment

    try {
      let user = await this.http.post<User>(
        this.baseUrl + 'updateUser',
        {
          id: User.id,
          username: User.username,
          password: this.modifyForm.get('Password'),
          firstName: this.modifyForm.get('FirstName'),
          LastName: this.modifyForm.get('LastName'),
          email: this.modifyForm.get('Email'),
        }
      ).toPromise();

      console.warn(this.modifyForm.value);
      this.router.navigateByUrl("/home");
    } catch (error) {
      alert("Update was unsuccessful.");
    }
  }
  goBack() {
    this.router.navigateByUrl("/home");
    console.warn('Log Out function needed');
  }
}
