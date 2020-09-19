import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}

  Modify() {
    this.router.navigate(['Modify-User']);
    console.warn('Modify function needed');
  }
  add() {
    this.router.navigate(['new-ingredient']);
    console.warn('Add ingredient function needed');
  }
  viewPrevious() {
    this.router.navigate(['recipe-table']);
    console.warn('View Previous function needed');
  }
  viewFavorite() {
    this.router.navigate(['recipe-table']);
    console.warn('View Favorite function needed');
  }
  LogOut() {
    this.router.navigate(['login-form']);
    console.warn('Log Out function needed');
  }
}
