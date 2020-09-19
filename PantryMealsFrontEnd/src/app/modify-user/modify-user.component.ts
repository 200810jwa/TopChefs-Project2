import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';

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

  constructor(private router: Router) {}

  ngOnInit(): void {}

  update() {
    console.warn(this.modifyForm.value);
  }
  goBack() {
    this.router.navigate(['profile']);
    console.warn('Log Out function needed');
  }
}
