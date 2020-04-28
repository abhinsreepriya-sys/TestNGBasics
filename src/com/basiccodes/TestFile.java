package com.basiccodes;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestFile {
	
    public WebDriver driver ; 
    public String driverPath;
    public String baseUrl;
    
  @BeforeMethod
  public void setBrowserUp() {
	  baseUrl = "http://demo.guru99.com/test/newtours/";
	  System.out.println("launching chrome browser"); 
      System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
      driver = new ChromeDriver();
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
      driver.get(baseUrl);
  }
    
    
  @Test
  public void verifyHomepageTitle() {
       
      String expectedTitle = "Welcome: Mercury Tours";
      String actualTitle = driver.getTitle();
      AssertJUnit.assertEquals(actualTitle, expectedTitle);
      
}
  
 
  @AfterMethod
	public void tearDown() {
	  driver.quit();
	}
}
