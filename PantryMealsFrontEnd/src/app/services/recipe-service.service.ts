import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Recipe } from 'src/app/models/recipe';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class RecipeServiceService {
  baseUrl = environment.baseURL;
  //private baseUrl: String = 'http://localhost:8080/'; // this probably isn't the right url?
  //Need to add this to environement and set it up there.

  constructor(private http: HttpClient) { }

  GetAllPreviousRecipes(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(this.baseUrl + '/allRecipes');
  }

  Rating(i: number): Observable<Recipe> {
    return this.http.patch<Recipe>(this.baseUrl + '/rate', i);
  }
}
