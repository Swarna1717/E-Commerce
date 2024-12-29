package com.pages;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public abstract class BaseClass {
	
	public static WebDriver driver;
  	public HomePage hp;
  	public  IndexPage In;

  	
  	@BeforeTest
  	public void setup() {
  		ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");

    	System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver-win64\\chromedriver.exe");
    	 driver = new ChromeDriver(options);
		  driver.get("https://www.demoblaze.com/");
  		 //driver = new ChromeDriver();
  		 // driver.get("https://www.demoblaze.com/");
  		  driver.manage().window().maximize();
  		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  		hp=new HomePage(driver);
  		In = new IndexPage(driver);

  	}
  	
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
  	
  

  