import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { LoginFormComponent } from './login-form/login-form.component';
import { RegisterFormComponent } from './register-form/register-form.component';

@NgModule({
  imports: [BrowserModule, FormsModule, ReactiveFormsModule, RouterModule],
  declarations: [AppComponent, LoginFormComponent, RegisterFormComponent],
  bootstrap: [AppComponent],
  exports: [CommonModule, FormsModule, ReactiveFormsModule],
})
export class AppModule {}
