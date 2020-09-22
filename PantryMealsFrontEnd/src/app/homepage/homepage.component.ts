import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Recipe } from 'src/app/models/recipe';
import { Observable } from 'rxjs';
import { Ingredient } from 'src/app/new-ingredient/ingredient';
import { ListOfIngredients } from 'src/app/new-ingredient/list-of-ingredients.enum';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css'],
})
export class HomepageComponent implements OnInit {
  public currentUser: User;
  public ingredients: String[] = [];
  public ingredient: String;
  public looseFilter: Boolean;
  public FavoriteRecipes: Observable<Recipe[]>;
  public SavedRecipes: Observable<Recipe[]>;
  public SearchResults: Observable<Recipe[]>;

  public task: Ingredient;
  private listOfIngredients = ListOfIngredients;
  public taskTypeOptions = [];

  constructor(private router: Router, private http: HttpClient) {}

  ngOnInit(): void {
    this.currentUser = new User();
    // this.currentUser = JSON.parse(sessionStorage.getItem("currentUser"));
    this.taskTypeOptions = Object.keys(this.listOfIngredients);
  }
  Add(): void {
    this.ingredients.push(this.ingredient);
    this.ingredient = null;
  }
  Login(): void {
    this.router.navigateByUrl('/login-form');
  }

  Register(): void {
    this.router.navigateByUrl('/register-form');
  }

  Remove(i: number): void {
    this.ingredients.splice(i, 1);
  }

  Search(): void {
    console.log(this.ingredients);
    console.log(this.looseFilter);

    try {
      let results = this.http.post<Recipe[]>(
        'http://localhost:8085/Project2/recipes',
        {
          list: list,
          filter: true,
        },
        {
          withCredentials: true,
        }
      );
      console.log(results);
      this.SearchResults = results;
    } catch (error) {
      console.log(error);
      alert('Failed to submit');
    }
  }
<<<<<<< HEAD
  gotToRecipe(href: string): void{
    window.open(href, "_blank");
  }
=======
>>>>>>> 8da9342c97960e5a48ff30448488192e2160c7c1
}
