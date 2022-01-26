package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By email = By.cssSelector("[id='email']");
	private By password = By.cssSelector("[name='password']");
	private By loginBtn = By.cssSelector("[value='Login']");
	private By forgotPass = By.cssSelector("a[href*='forgot']");
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLogin() {
		return driver.findElement(loginBtn);
	}
	
	public ForgotPasswordPage forgotPassword() {
		driver.findElement(forgotPass).click();
		return new ForgotPasswordPage(driver); 
	}
	
}

