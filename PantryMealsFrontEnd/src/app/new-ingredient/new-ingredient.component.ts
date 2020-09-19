import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-ingredient',
  templateUrl: './new-ingredient.component.html',
  styleUrls: ['./new-ingredient.component.css'],
})
export class NewIngredientComponent implements OnInit {
  IngredientForm = new FormGroup({
    IngredientName: new FormControl(''),
  });

  constructor(private router: Router) {}

  ngOnInit(): void {}

  addIngredient() {
    console.warn(this.IngredientForm.value);
  }

  goBack() {
    this.router.navigate(['profile']);
    console.warn('Log Out function needed');
  }
}
