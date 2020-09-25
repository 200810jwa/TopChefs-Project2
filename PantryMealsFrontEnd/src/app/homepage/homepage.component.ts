import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Recipe } from 'src/app/models/recipe';
import { Observable } from 'rxjs';
import { Ingredient } from 'src/app/new-ingredient/ingredient';
import { ListOfIngredients } from 'src/app/new-ingredient/list-of-ingredients.enum';
import { AutocompleteLibModule } from 'angular-ng-autocomplete';

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
  public FavoriteRecipes: Recipe[] = [];
  public SavedRecipes: Recipe[] = [];
  public SearchResults: Observable<Recipe[]>;
  baseURL: string = 'http://localhost:8085/Project2/';
  // baseURL: string = 'http://ec2-3-137-136-86.us-east-2.compute.amazonaws.com:8085/TopChefs-Project2/';

  keyword = 'name';
  data = [{ name: "Butter" }, { name: "Flour" }, { name: "Salt" }, { name: "Water" }, { name: "Eggplant" }, { name: "Onions" },
  { name: "Parsley" }, { name: "Garlic" }, { name: "Eggs" }, { name: "Tomato" }, { name: "Milk" }, { name: "Cream" },
  { name: "Asparagus" }, { name: "Strawberries" }, { name: "Beef" }, { name: "Vegetable" }, { name: "Potato" }, { name: "Carrot" },
  { name: "Barley" }, { name: "Banana" }, { name: "Chicken" }, { name: "Cinnamon" }, { name: "Paprika" }, { name: "Sugar" },
  { name: "Pepper" }, { name: "Cumin" }, { name: "Cayenne" }, { name: "Orange" }, { name: "Cranberries" }, { name: "raisin" },
  { name: "Nutmeg" }, { name: "Ginger" }, { name: "Apple" }, { name: "Hamburger" }, { name: "Ketchup" }, { name: "Vinegar" },
  { name: "Turmeric" }, { name: "Shallot" }, { name: "Rum" }, { name: "Cornstarch" }, { name: "Honey" }, { name: "Hazelnuts" },
  { name: "Chocolate" }, { name: "Sauce" }, { name: "Pecan" }, { name: "Baguette" }, { name: "Blueberries" }, { name: "Bread" },
  { name: "Lime" }, { name: "Lemon" }, { name: "Mushroom" }, { name: "Cheese" }, { name: "Cilantro" }, { name: "Peppercorn" },
  { name: "Brandy" }, { name: "Tarragon" }, { name: "Chilies" }, { name: "Sriracha" }, { name: "Relish" }, { name: "Turkey" },
  { name: "Basil" }, { name: "Tofu" }, { name: "Berries" }, { name: "Whiskey" }, { name: "Margarine" }, { name: "Buttermilk" },
  { name: "Karo" }, { name: "Liquini" }, { name: "Mirin" }, { name: "Chives" }, { name: "Mango" }, { name: "Pineapple" },
  { name: "Pear" }, { name: "Sherry" }, { name: "Bourbon" }, { name: "Wine" }, { name: "Kiwi" }, { name: "Cloves" },];
  value = '';

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.currentUser = JSON.parse(sessionStorage.getItem('currentUser'));
    //this.taskTypeOptions = Object.keys(this.listOfIngredients);
    if(this.currentUser != null){
      this.SavedRecipes = this.currentUser.previousRecipes;
      this.FavoriteRecipes = this.currentUser.favoriteRecipes;
    }

  }
  Add(): void {
    this.ingredients.push(this.value);
    // console.log(this.value);
    // this.ingredient = null;
  }

  Logout(): void {
    sessionStorage.removeItem('currentUser');
    window.location.reload();
  }
  Remove(i: number): void {
    this.ingredients.splice(i, 1);
  }

  Search(): void {
    console.log(this.ingredients);
    console.log(this.looseFilter);

    try {
      let results = this.http.post<Recipe[]>(
        this.baseURL + 'recipes',
        {
          list: this.ingredients,
          looseFilter: this.looseFilter,
        }
      );
      console.log(results);
      this.SearchResults = results;
    } catch (error) {
      console.log(error);
      alert('Failed to submit');
    }
  }
  goToRecipe(recipe: Recipe): void {
    recipe.id = null;
    sessionStorage.setItem("Recipe", JSON.stringify(recipe));
    window.open(recipe.href, '_blank');
    this.router.navigateByUrl("/recipe-feedback");
  }

  selectEvent(item) {
    this.value = item.name;
    console.warn(this.value);
  }

  onChangeSearch(val: string) {
    //To Do with the Autocomplete, build functionality later?
  }

  onFocused(e) {
    // do something when input is focused
    //To Do with the Autocomplete, build functionality later?
  }
}
