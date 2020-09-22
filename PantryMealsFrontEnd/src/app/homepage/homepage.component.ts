import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  public currentUser: User;
  public ingredients: String[] = [];
  public ingredient: String;
  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    // this.currentUser = new User;
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser"));
  }
  Add(): void {
    this.ingredients.push(this.ingredient);
    this.ingredient = null;
  }
}
