package FrameworkProject;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class ValidateNavLinks extends base{
	private static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;	//this is needed to run test in parallel mode
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test
	public void basePageNavLinks() throws IOException {
		
		// Accessing methods of another class
		// 1. Inheritance
		// 2. Creating object of that other class and invoke methods
		LandingPage LandingP = new LandingPage(driver);
		
		// Verify if the links at the top of page is displaying 
		AssertJUnit.assertTrue(LandingP.getNavLinks().isDisplayed());
		log.info("Navigation Links are displayed.");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
}
