import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule, ROUTES } from '@angular/router';
import { CommonModule } from '@angular/common';
import { LoginFormComponent } from './login-form/login-form.component';
import { RegisterFormComponent } from './register-form/register-form.component';
import { RecipeTableComponent } from './recipe-table/recipe-table.component';
import { ProfileComponent } from './profile/profile.component';
import { NewIngredientComponent } from './new-ingredient/new-ingredient.component';
import { ModifyUserComponent } from './modify-user/modify-user.component';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      { path: 'login-form', component: LoginFormComponent },
      { path: 'register-form', component: RegisterFormComponent },
      { path: 'recipe-table', component: RecipeTableComponent },
      { path: 'profile', component: ProfileComponent },
      { path: 'new-ingredient', component: NewIngredientComponent },
      { path: 'Modify-User', component: ModifyUserComponent },
    ]),
  ],
  declarations: [
    AppComponent,
    LoginFormComponent,
    RegisterFormComponent,
    RecipeTableComponent,
    ProfileComponent,
    NewIngredientComponent,
    ModifyUserComponent,
  ],
  bootstrap: [AppComponent],
  exports: [CommonModule, FormsModule, ReactiveFormsModule],
})
export class AppModule {}
