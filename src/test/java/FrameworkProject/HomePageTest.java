package FrameworkProject;

import org.testng.annotations.Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePageTest extends base{
	private static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;	//this is needed to run test in parallel mode
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
		
	}	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password, String text) throws IOException, InterruptedException {

		driver.get(prop.getProperty("url"));
		// Accessing methods of another class
		// 1. Inheritance
		// 2. Creating object of that other class and invoke methods
		LandingPage LandingP = new LandingPage(driver);
		LoginPage LoginP = LandingP.getLogin();
		
		LoginP.getEmail().sendKeys(username);
		LoginP.getPassword().sendKeys(password);
		log.info(text);		
		LoginP.getLogin().click();
		//Thread.sleep(5000);
		
		ForgotPasswordPage forgotPage = LoginP.forgotPassword();
		Thread.sleep(5000);
		log.info("Clicked forgot password.");	
		forgotPage.getEmail().sendKeys("rahul@sheety.academy");
		forgotPage.sendInstructions().click();
		
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		// Row stand for how many different data types test should run
		// Column stands for how many values per each test
		// row e.g. two tests - restricted user and un-restricted user
		// column e.g. email, password, user text 
		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestricted@user.com";
		data[0][1] = "nonrestricted-PW";
		data[0][2] = "Non Restricted User";
		
		data[1][0] = "restricted@user.com";
		data[1][1] = "restricted-PW";
		data[1][2] = "Restricted User";
		
		return data;		
		
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
