package com.revature.testng;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.revature.pages.TopChefsLogin;
import com.revature.pages.TopChefsProfile;

public class TopChefsTest {
	
	public WebDriver driver;
	public final String url ="http://localhost:4200/login";
	
  @BeforeClass
  public void beforeClass() {
	  File file = new File("src/test/resources/chromedriver.exe");
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
  
  
  @DataProvider(name = "credentials")
  public Object[][] loginCredentials() {
	  Object[][] data = null;
	  
	  try (Workbook wb = new XSSFWorkbook(new FileInputStream("src/test/resources/TopChefsData.xlsx"))) {
		  Sheet sheet1 = wb.getSheet("Sheet1");
		 
		  
		  int rowcount = sheet1.getLastRowNum();
		  
		  data = new String[rowcount][2];
		  
		  for(int i = 0; i < rowcount; i++) {
			  Row row = sheet1.getRow(i + 1);
			  data[i] = new String[] { row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue() };
		  }
	  } catch(IOException e) {
		  e.printStackTrace();
	  }
	  return data;  
	  }
  
  @Test(dependsOnMethods = {"confirmLoginPage"}, dataProvider = "credentials")
  public void loginWorks(String username, String password) 
  {
	  
	  WebDriverWait wait1 = new WebDriverWait(driver, 5);
	  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='PantryMeals']")));
	  TopChefsLogin tcl = new TopChefsLogin(driver);
	 
	tcl.loginToTopChefs(username, password);
	  
	  
	  TopChefsProfile tcp = new TopChefsProfile(driver);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.visibilityOf(tcp.header));
	
	  assertEquals(driver.getTitle(), TopChefsProfile.title);
	  
	  tcp.signOffLink.click();
	  tcl.homeLink.click();
  }
}
  

