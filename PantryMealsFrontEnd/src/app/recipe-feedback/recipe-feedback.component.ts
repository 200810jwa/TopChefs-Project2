import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-recipe-feedback',
  templateUrl: './recipe-feedback.component.html',
  styleUrls: ['./recipe-feedback.component.css']
})
export class RecipeFeedbackComponent implements OnInit {
  public currentUser: any;
  public recipe: any;
  public made: Boolean = false;
  public currentRating = 2;

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.recipe = JSON.parse(sessionStorage.getItem("Recipe"));
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser"));
  }
  Logout(): void {
    sessionStorage.removeItem('currentUser');
    this.router.navigateByUrl("/home");
  }
  RecipeMade(): void {
    this.made = true;
  }
  RecipeNotMade(): void {
    this.made = false;
  }
  async Back(): Promise<void> {
    if(this.currentUser != null && this.made == true){
      try {
        let results = await this.http.put(
          'http://localhost:8085/Project2/saveToPrevious/' + this.currentUser.id,
          {
            recipe: this.recipe
          }
        ).toPromise();
        console.log("successfully sent request to save recipe");
      } catch (error) {
        console.log(error);
        alert('Failed to submit');
      }

    }
    sessionStorage.removeItem("Recipe");
    history.go(-1);
  }
  
}