package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopChefsProfile {
	
public static final String title = "PantryMeals";
	
	@FindBy(xpath = "//h3[text()='Login Successfully']")
	public WebElement header;
	
	@FindBy(linkText = "Logout")
	public WebElement signOffLink;
	
	public TopChefsProfile(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
