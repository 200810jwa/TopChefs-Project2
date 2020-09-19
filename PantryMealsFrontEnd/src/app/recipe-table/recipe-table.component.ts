import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-recipe-table',
  templateUrl: './recipe-table.component.html',
  styleUrls: ['./recipe-table.component.css'],
})
export class RecipeTableComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}

  findRecipes() {
    console.warn('Not implemented yet.');
  }
  goBack() {
    this.router.navigate(['profile']);
    console.warn('Go Back Ingredients function needed');
  }
}
