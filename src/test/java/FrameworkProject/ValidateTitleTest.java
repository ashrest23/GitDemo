package FrameworkProject;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.LandingPage;
import resources.base;

public class ValidateTitleTest extends base {
	private static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver; // this is needed to run test in parallel mode
	LandingPage LandingP;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized.");

		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page.");

	}

	@Test
	public void basePageText() throws IOException {

		// Accessing methods of another class
		// 1. Inheritance
		// 2. Creating object of that other class and invoke methods
		LandingP = new LandingPage(driver);

		// Compare text from the browser with the actual text - Assertions
		Assert.assertEquals(LandingP.getTitle().getText(), "Featured Courses");
		log.info("Successfully validated Feature Courses test message.");

	}

	@Test(dependsOnMethods={"basePageText"})
	// TestNG will execute this method before basePageText() because it is alphabetically before 
	// That is why the dependsOnMethods annotation was added 
	public void baseHeaderText() throws IOException {

		// Compare text from the browser with the actual text - Assertions
		Assert.assertEquals(LandingP.getHeader().getText(), "An Academy to Learn Earn & Shine  in your QA Career");
		log.info("Successfully validated Header test message.");
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
