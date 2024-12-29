package com.pages;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage {
	WebDriver driver ;

    //constructor
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements( driver , this);
	}
	
	//locators
	
	@FindBy (xpath="//*[@id=\"signin2\"]") WebElement Signup;
	@FindBy (id="sign-username") WebElement username;
	@FindBy (id="sign-password") WebElement pswd;
	@FindBy (xpath="//*[@id=\"signInModal\"]/div/div/div[3]/button[2]") WebElement Signupbtn;
	@FindBy (xpath="//*[@id=\"signInModal\"]/div/div/div[1]/button/span") WebElement closesignUpwin;
		//locators to login
	
	@FindBy (id="login2") WebElement loginbtn;
	@FindBy (id="loginusername") WebElement loginusername;
	@FindBy (id="loginpassword") WebElement loginpassword;
	@FindBy (xpath = "//*[@id=\"logInModal\"]/div/div/div[3]/button[2]") WebElement loginbtn2;
	
	// locators of other options
	@FindBy (xpath="//a[@id='itemc']") List<WebElement>options;
	@FindBy (xpath="//*[@id=\"cartur\"]") WebElement cart;
	@FindBy (xpath="//div[@id='contcont']//a[2]")  WebElement phones;
	@FindBy (xpath="//a[text()='Laptops']")  WebElement Laptops;
	@FindBy (xpath="//a[text()='Monitors']")  WebElement Monitors;
	
	@FindBy (xpath="//div[@class='col-lg-9']//h4") List<WebElement> phonesOptions;
	@FindBy (xpath="//div[@id='tbodyid']//h4") List<WebElement> laptopsOptions;
	@FindBy (xpath="//div[@class='card-block']//a") List<WebElement> monitorsOptions;
	
	
	public String getAppUrl() {
		return driver.getCurrentUrl();
	}
	
		//actionmethods
	
	public void signUp(String user,String password) throws InterruptedException {
		Signup.click();
		Thread.sleep(2000);
		username.clear();
		username.sendKeys(user);
		
		pswd.sendKeys(password);
		Signupbtn.click();
		Thread.sleep(2000);
		 Alert alt = driver.switchTo().alert();
		 System.out.println("Alert text is : " +alt.getText());
		   alt.accept();
		   closesignUpwin.click();
		
	}
	
	
	public void login(String userlogin,String pswdlogin) throws InterruptedException {
		loginbtn.click();
		Thread.sleep(2000);
		loginusername.sendKeys(userlogin);
		loginpassword.sendKeys(pswdlogin);
		loginbtn2.click();
		Thread.sleep(2000);		
	}
	
	public void getTextOfCategories() {
		for(WebElement op:options) {
			System.out.println(op.getText());
			
		}
	}
	
	public void selectacategory(String choice) {
		for(WebElement op:options) {
			if(op.getText().contains(choice)){
				op.click();
				break;
			}
		}
		
	}
	
	public int getTotalCategories() {
		int categories = options.size();
		System.out.println("Total no of categories are :"+options.size());
		return categories;
	}
	
			
 public void clickSignup() {
		Signup.click();
		
	}
 
 public void enterUsername(String user) {
	   username.sendKeys(user);
 }
			
 public void enterPassword(String password) {
	  pswd.sendKeys(password);
 }
 
 public void clickSignupbtn() {
		Signupbtn.click();
	}
 
 public void swichToAlert(WebDriver driver) {
	   Alert alt = driver.switchTo().alert();
	   alt.accept();
 }
 
 public void clickLoginbtn() {
		loginbtn.click();
	}
 public void enterLoginUsername(String userlogin) {
	loginusername.sendKeys(userlogin);
 }
 
 public void enterLoginpswd(String pswdlogin) {
		loginpassword.sendKeys(pswdlogin);
	   }
 
 
 public void clickLoginbtn2() {
		loginbtn2.click();
	}
 

 public void phonesProduct() {
	   phones.click();
	   
 }

 public void laptopsProduct() {
	   Laptops.click();  	   
 }
 
 public void monitorsProduct() {
	Monitors.click();   
 }
 
 public int totalPhoneproducts() {
		return phonesOptions.size();	
		}
	
	public void listOfPhones() {
		System.out.println("List of Phones in Product Store is: ");
		for(WebElement ph:phonesOptions) {
			System.out.println(ph.getText());
			//ph.click();
		}
	}
	
	public void clicklistOfPhones() {
		System.out.println("List of Phones in Product Store is: ");
		for(WebElement ph:phonesOptions) {
			System.out.println(ph.getText());
			ph.click();
			
		}
	}
	

	public int totalLaptopsproducts() {
		return laptopsOptions.size();	
		}
	
	public void listOfLaptops() {
		System.out.println("List of Laptops in Product Store is: ");
		for(WebElement lp:laptopsOptions) {
			System.out.println(lp.getText());
		}
	}

	public int totalMonitorproducts() {
		return monitorsOptions.size();	
		}
	
	public void listOfMonitors() {
		System.out.println("List of Monitors in Product Store is: ");
		for(WebElement mo:monitorsOptions) {
			System.out.println(mo.getText());
		}
	}
}