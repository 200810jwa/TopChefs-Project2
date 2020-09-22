import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'PantryMeals';
  
  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.router.navigateByUrl("/home");
  }
}
