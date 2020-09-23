import { Recipe } from './recipe';

export class User {
  id: Number;
  username: String;
  password: String;
  firstName: String;
  lastName: String;
  email: String;
  previousRecipes: Recipe[];
  favoriteRecipes: Recipe[];
}
