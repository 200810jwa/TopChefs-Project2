import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Ingredient } from './ingredient';

@Component({
  selector: 'app-new-ingredient',
  templateUrl: './new-ingredient.component.html',
  styleUrls: ['./new-ingredient.component.css'],
})
export class NewIngredientComponent implements OnInit {
  IngredientForm = new FormGroup({
    IngredientName: new FormControl(''),
  });

  IngredientArray: Ingredient[] = [];

  constructor(private router: Router) {}

  ngOnInit(): void {}

  addIngredient() {
    this.IngredientArray.push({
      name: this.IngredientForm.controls['IngredientName'].value,
    });
    //console.warn(this.IngredientForm.value);
    console.warn(this.IngredientArray); //Pass List of Ingredients to Back-End!!!
  }

  goBack() {
    this.router.navigate(['profile']);
    console.warn('Log Out function needed');
  }
}
