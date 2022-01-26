package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	 private By signIn = By.cssSelector("a[href*='sign_in']");
	 private By title = By.xpath("//h2[contains(text(), 'Featured Courses')]");
	 private By navLinks = By.cssSelector("ul[class='navigation clearfix']");
	 private By header = By.cssSelector("div[class*='col-md-6 text-left'] h2");
	
	public LoginPage getLogin() {
		driver.findElement(signIn).click();
		LoginPage LoginP = new LoginPage(driver);
		return LoginP;
 
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavLinks() {
		System.out.println("Trying to identify navigation bars.");
		return driver.findElement(navLinks);
	}
	

	public WebElement getHeader() {
		return driver.findElement(header);
	}
}
