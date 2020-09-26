package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopChefsLogin {
	public final static String title = "Login";

	@FindBy(xpath = "//input[@name='username']")
	public WebElement username;
	
	@FindBy(name = "password")
	public WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	public WebElement submitButton;

	@FindBy(linkText="Home")
	public WebElement homeLink;
	
	@FindBy(linkText="Login")
	public WebElement loginLink;
	
	
	public TopChefsLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void loginToTopChefs(String username, String password) {
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		this.submitButton.click();
	}
	
}
