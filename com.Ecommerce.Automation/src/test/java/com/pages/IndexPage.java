package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	 private WebDriver driver;

	    // Constructor
	    public IndexPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    // Locators
	    @FindBy(xpath = "//div[@class='list-group']//a")
	    private List<WebElement> allCategory;

	    @FindBy(xpath = "//div[@id='tbodyid']//h4/a")
	    private List<WebElement> allOptions;

	    @FindBy(xpath = "//*[@id='tbodyid']/div[2]/div/a")
	    private WebElement addToCartButton;

	    @FindBy(xpath = "//a[text()='Cart']")
	    private WebElement cartLink;

	    @FindBy(xpath = "//tbody[@id='tbodyid']//td[2]")
	    private List<WebElement> cartProducts;
	  
		
		//Cart Locator
		By cartMenu = By.id("cartur");
		
	   // Place Order Form Fields
	    By nameField = By.id("name");
	    By countryField = By.id("country");
	    By cityField = By.id("city");
	    By creditCardField = By.id("card");
	    By monthField = By.id("month");
	    By yearField = By.id("year");
	    By purchaseButton = By.xpath("//button[contains(text(),'Purchase')]");
	    By confirmationOK = By.xpath("//button[text()='OK']");
		By logout =By.id("logout2");
		
		
		
		//Methods
	
	    public String getCurrentUrl() {
	        return driver.getCurrentUrl();
	    }

	    public void selectProduct(int index) {
	        allOptions.get(index).click(); // Select a product by index
	    }

	    public void addToCart() {
	        addToCartButton.click();
	        try {
	            Thread.sleep(2000); // Wait for alert to appear
	            driver.switchTo().alert().accept(); // Accept the alert
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	 
	  public void clickOnCart() {
			 driver.findElement(cartMenu).click();
		 }
	 public void DeleteItem() throws InterruptedException {
		 driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr[1]/td[4]/a")).click();
		 System.out.println("ASUS Full HD deleted successfully.");
		 Thread.sleep(3000);
	 }
	 
	 public void placeOrderBtn() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		Thread.sleep(2000);
		 }
	 
	// Fill Order Details and Purchase
	    public void OrderDetails(String name, String country, String city, String card, String month, String year) throws InterruptedException {
	        driver.findElement(nameField).sendKeys(name);
	        driver.findElement(countryField).sendKeys(country);
	        driver.findElement(cityField).sendKeys(city);
	        driver.findElement(creditCardField).sendKeys(card);
	        driver.findElement(monthField).sendKeys(month);
	        driver.findElement(yearField).sendKeys(year);
	        driver.findElement(purchaseButton).click();
	        Thread.sleep(2000);
	        driver.findElement(confirmationOK).click();
	        }

		public void logout() {
			driver.findElement(logout).click();
	        System.out.println("Logged out successfully");
			}

		public boolean isProductInCart(String string) {
			// TODO Auto-generated method stub
			return false;
		}

	}