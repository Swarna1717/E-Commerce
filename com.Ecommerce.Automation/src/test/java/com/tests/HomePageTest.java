package com.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import com.pages.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class HomePageTest extends BaseClass{
	 private ExtentReports extent;
	    private ExtentTest test;

	    @BeforeClass
	    public void setupReport() {
	        ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReports/HomepageTestReport.html");
	        extent = new ExtentReports();
	        extent.attachReporter(spark);
	    }

	   
	    @Test(priority = 1)
	    public void Test1() {
	        test = extent.createTest("Test1 - Validate URL");
	        String url = hp.getAppUrl();
	        Assert.assertEquals(url, "https://www.demoblaze.com/", "URL mismatch");
	        test.info("URL Matched");
	    }


	    @Test(priority = 2)
	    public void validateSignup() throws InterruptedException {
	        test = extent.createTest("Validate Signup");
	        System.out.println("Validating Signup process");
	        hp.signUp("Vihaan", "Swarna@1234");
	        System.out.println("Signup successful");
	        test.pass("Signup successful");
	    }

	    @Test(priority = 3)
	    public void validateLogin() throws InterruptedException {
	        test = extent.createTest("Validate Login");
	        System.out.println("Validating Login process");
	        hp.login("Vihaan", "Swarna@1234");
	        System.out.println("Login successful");
	        test.pass("Login successful");
	    }

	    @Test(priority = 4)
	    public void validateNumberOfCategories() {
	        test = extent.createTest("Validate Number of Categories");
	        System.out.println("Validating total categories");
	        int totalCategories = hp.getTotalCategories();
	        System.out.println("Total categories found: " + totalCategories);
	        Assert.assertEquals(totalCategories, 3, "Number of categories not matched");
	        System.out.println("Number of categories validated successfully");
	        test.pass("Validated number of categories successfully");
	    }

	    @Test(priority = 5)
	    public void validateListOfCategories() {
	        test = extent.createTest("Validate List of Categories");
	        System.out.println("Validating list of categories");
	        hp.getTextOfCategories();
	        System.out.println("List of categories validated successfully");
	        test.pass("List of categories validated successfully");
	    }

	    @Test(priority = 6)
	    public void validatePhoneProducts() {
	        test = extent.createTest("Validate Phone Products");
	        System.out.println("Validating phone products");
	        hp.phonesProduct();
	        int totalPhones = hp.totalPhoneproducts();
	        System.out.println("Total phone products found: " + totalPhones);
	        Assert.assertTrue(totalPhones > 0, "Phone products not found");
	        hp.listOfPhones();
	        System.out.println("Phone products validated successfully");
	        test.pass("Phone products validated successfully");
	    }

	    @Test(priority = 7)
	    public void validateLaptopProducts() {
	        test = extent.createTest("Validate Laptop Products");
	        System.out.println("Validating laptop products");
	        hp.laptopsProduct();
	        int totalLaptops = hp.totalLaptopsproducts();
	        System.out.println("Total laptop products found: " + totalLaptops);
	        Assert.assertTrue(totalLaptops > 0, "Laptop products not found");
	        hp.listOfLaptops();
	        System.out.println("Laptop products validated successfully");
	        test.pass("Laptop products validated successfully");
	    }

	    @Test(priority = 8)
	    public void validateMonitorProducts() {
	        test = extent.createTest("Validate Monitor Products");
	        System.out.println("Validating monitor products");
	        hp.monitorsProduct();
	        int totalMonitors = hp.totalMonitorproducts();
	        System.out.println("Total monitor products found: " + totalMonitors);
	        Assert.assertTrue(totalMonitors > 0, "Monitor products not found");
	        hp.listOfMonitors();
	        System.out.println("Monitor products validated successfully");
	        test.pass("Monitor products validated successfully");
	    }

	    @AfterMethod
	    public void captureScreenshotAfterTest(ITestResult result) {
	        try {
	            String baseDir = "C:\\SAMBIT\\Users\\Sam\\Swarna_SeleniumDemos\\com.Ecommerce.Automation\\Screenshots"+".png";
	            File screenshotDir = new File(baseDir);
	            if (!screenshotDir.exists()) {
	                screenshotDir.mkdirs();
	            }

	            // Capture screenshot
	            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            String screenshotPath = baseDir + "\\" + result.getName() + "_" + (result.getStatus() == ITestResult.SUCCESS ? "PASS" : "FAIL") + ".png";
	            File destination = new File(screenshotPath);
	            Files.copy(screenshot.toPath(), destination.toPath());

	            // Log the screenshot to ExtentReports
	            if (result.getStatus() == ITestResult.FAILURE) {
	                test.fail(result.getThrowable());
	                test.addScreenCaptureFromPath(screenshotPath, "Failed Test Screenshot");
	            } else if (result.getStatus() == ITestResult.SUCCESS) {
	                test.pass("Test passed");
	                test.addScreenCaptureFromPath(screenshotPath, "Passed Test Screenshot");
	            }

	            // Print confirmation
	            System.out.println("Screenshot saved at: " + destination.getAbsolutePath());
	        } catch (IOException e) {
	            System.err.println("Error capturing screenshot: " + e.getMessage());
	        }
	    }

	    @AfterTest
	    public void tearDown() {
	        // End the test report
	        extent.flush();
	        driver.quit();
	    }
	}      