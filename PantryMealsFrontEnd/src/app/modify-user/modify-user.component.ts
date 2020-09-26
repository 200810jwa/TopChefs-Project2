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

  async update(): Promise<void> {
    let cu = sessionStorage.getItem("currentUser");
    let obj = JSON.parse(sessionStorage.currentUser);
    console.log(obj);
    this.id = obj.id;
    //this.username = obj.username;
    console.log(this.id);
    try {
      //Doesn't work at the moment
      let user = await this.http.patch<User>(
        this.baseUrl + 'updateUser',
        {
          id: this.id,
          username: this.username,
          password: this.modifyForm.get('Password').value,
          firstName: this.modifyForm.get('FirstName').value,
          LastName: this.modifyForm.get('LastName').value,
          email: this.modifyForm.get('Email').value,
        }
      ).toPromise();

      console.warn(this.modifyForm.value);
      this.router.navigateByUrl("/home");
    } catch (error) {
      alert("Update was unsuccessful.");
      console.warn(error);
    }
  }
  goBack() {
    this.router.navigateByUrl("/home");
    console.warn('Log Out function needed');
  }
}
