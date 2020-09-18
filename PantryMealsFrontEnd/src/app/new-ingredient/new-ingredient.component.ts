import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-new-ingredient',
  templateUrl: './new-ingredient.component.html',
  styleUrls: ['./new-ingredient.component.css'],
})
export class NewIngredientComponent implements OnInit {
  IngredientForm = new FormGroup({
    IngredientName: new FormControl(''),
  });

  constructor() {}

  ngOnInit(): void {}

  addIngredient() {
    console.warn(this.IngredientForm.value);
  }
}
