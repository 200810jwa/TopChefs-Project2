import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { FormGroup, FormControl } from '@angular/forms';


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
  public addToFavorites: Boolean;
  baseURL = environment.baseURL;

  RatingForm = new FormGroup({
    rating: new FormControl(''),
  });
  //baseURL: string = 'http://ec2-3-137-136-86.us-east-2.compute.amazonaws.com:8085/TopChefs-Project2/';
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
    this.rate();
    console.log(JSON.stringify(this.recipe));
    if (this.currentUser != null && this.made == true) {
      try {
        let result = await this.http.put(
          this.baseURL + 'saveToPrevious',
          {
            user: this.currentUser,
            recipe: this.recipe
          }
        ).toPromise();
        console.log("successfully sent request to save recipe to previous");
        sessionStorage.removeItem('currentUser');
        sessionStorage.setItem("currentUser", JSON.stringify(result));
      } catch (error) {
        console.log(error);
        alert('Failed to submit');
      }

    }
    if (this.currentUser != null && this.addToFavorites == true) {
      try {
        let result = await this.http.put(
          this.baseURL + 'saveToFavorites',
          {
            user: this.currentUser,
            recipe: this.recipe
          }
        ).toPromise();
        console.log("successfully sent request to save recipe to favorites");
        sessionStorage.removeItem('currentUser');
        sessionStorage.setItem("currentUser", JSON.stringify(result));
      } catch (error) {
        console.log(error);
        alert('Failed to submit');
      }
    }
    sessionStorage.removeItem("Recipe");
    history.go(-1);
  }

  rate(): void {
    let a = this.RatingForm.get('rating').value;
    if(this.recipe.rating == null){
      this.recipe.rating = [a];
    }else{
      this.recipe.rating.push(a);
    }
    if (a <= 5 && a >= 0) {
      try {
        let result = this.http.patch(
          this.baseURL + 'rate',
          {
            rec: this.recipe
          });
        console.log("Rating successful");
      } catch (error) {
        console.log(error);
        alert('Failed to submit');
      }
    } else {
      alert("Please enter a number between 0 and 5")
    }
  }
  Rate(arr: number[]): number {
    let sum = arr.reduce((previous, current) => current += previous);
    let avg = sum / arr.length;
    return avg;
  }
}