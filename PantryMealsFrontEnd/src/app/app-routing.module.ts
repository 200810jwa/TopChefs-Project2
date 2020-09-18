import { NgModule } from '@angular/core';
import { Routes, RouterModule, ROUTES } from '@angular/router';
import { LoginFormComponent } from './login-form/login-form.component';
import { RegisterFormComponent } from './register-form/register-form.component';
import { RecipeTableComponent } from './recipe-table/recipe-table.component';
import { ProfileComponent } from './profile/profile.component';
import { NewIngredientComponent } from './new-ingredient/new-ingredient.component';

const routes: Routes = [
  { path: 'login-form', component: LoginFormComponent },
  { path: 'register-form', component: RegisterFormComponent },
  { path: 'recipe-table', component: RecipeTableComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'new-ingredient', component: NewIngredientComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
