package com.revature.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopChefsHomePage {
	public static final String title = "PantryMeals";
	
	@FindBy(xpath = "//auto-complete[@id='search']")
	public WebElement ingredient;
	
	@FindBy(xpath ="//span[@id='login")
	public WebElement loginButton;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement addIngredientButon;
	
	public void loginButtonClick() {
		this.loginButton.click();
	}
	
	public void searchIngredients(String ingredients) {
		this.ingredient.sendKeys(ingredients);
		this.addIngredientButon.click();
	}
 
}
