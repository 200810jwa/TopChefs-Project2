import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { UserServicesService } from 'src/app/services/user-services.service';

@Component({
  selector: 'app-modify-user',
  templateUrl: './modify-user.component.html',
  styleUrls: ['./modify-user.component.css'],
})
export class ModifyUserComponent implements OnInit {
  modifyForm = new FormGroup({
    FirstName: new FormControl(''),
    LastName: new FormControl(''),
    email: new FormControl(''),
    password: new FormControl(''),
  });

  userService = UserServicesService;
  constructor(private router: Router) {}

  ngOnInit(): void {}

  update() {
    //this.userService.updateUser(this.modifyForm.value);
    console.warn(this.modifyForm.value);
  }
  goBack() {
    this.router.navigate(['home']);
    console.warn('Log Out function needed');
  }
}
