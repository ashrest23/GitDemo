package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {

	public WebDriver driver;
	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By email = By.cssSelector("[name='email']");
	private By next = By.cssSelector("input[value='Next']");
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement sendInstructions() {
		return driver.findElement(next);
	}
}

