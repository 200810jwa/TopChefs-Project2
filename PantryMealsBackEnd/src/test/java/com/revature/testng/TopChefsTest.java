package com.revature.testng;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.revature.pages.TopChefsLogin;

public class TopChefsTest {
	
	public WebDriver driver;
	public final String url ="http://localhost:4200/login";
	
  @BeforeClass
  public void beforeClass() {
	  File file = new File("src/main/resources/chromedriver.exe");
	  System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	  this.driver = new ChromeDriver();
	  driver.get(url);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

  
  @Test
  public void confirmLoginPage() {
	  assertEquals(driver.getTitle(), TopChefsLogin.title);
  }
}
