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
import { NotFoundComponentComponent } from './not-found-component/not-found-component.component';
import { HomepageComponent } from './homepage/homepage.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    // RouterModule.forRoot([
    //   { path: 'login-form', component: LoginFormComponent },
    //   { path: 'register-form', component: RegisterFormComponent },
    //   { path: 'recipe-table', component: RecipeTableComponent },
    //   { path: 'profile', component: ProfileComponent },
    //   { path: 'new-ingredient', component: NewIngredientComponent },
    //   { path: 'Modify-User', component: ModifyUserComponent },
    //   { path: '404', component: NotFoundComponentComponent },
    // ]),
  ],
  declarations: [
    AppComponent,
    HomepageComponent,
    LoginFormComponent,
    RegisterFormComponent,
    RecipeTableComponent,
    ProfileComponent,
    NewIngredientComponent,
    ModifyUserComponent,
    NotFoundComponentComponent,
    HomepageComponent,
  ],
  bootstrap: [AppComponent],
  exports: [CommonModule, FormsModule, ReactiveFormsModule],
})
export class AppModule {}
