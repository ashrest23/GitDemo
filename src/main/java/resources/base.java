package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
	// Always label driver as global variable 
	// This way the driver object is only created once
	public WebDriver driver;
	
	public Properties prop;
	
	// Initialize driver - browser invocation
	public WebDriver initializeDriver() throws IOException {
		// Chrome
		// Firefox

		// Create Global Parameter for browser driver
		prop = new Properties();

		// Create a data.properties files at the src/main/java level
		// Create a FileInputStream object and give the location of the data.properties
		// file
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/data.properties");
		//FileInputStream fis = new FileInputStream("/Users/anish/Documents/eclipse-workspace/FrameworkProject/src/main/java/resources/data.properties");
		// Load the data.properties files
		prop.load(fis);
		
		// Get browser choice from maven - change prop.getProperty to System.getProperty
		String browserName = System.getProperty("browser");
		//mvn test -Dbrowser=chrome     this is the command to invoke in chrome
		
		// Below will get the value for the browser in properties file
		//String browserName = prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			// execute in chrome driver
			//String path = System.getProperty("user.dir") + "/src/main/java/resources/chromedriver";
			System.setProperty("webdriver.chrome.driver", "/Users/anish/Documents/eclipse-workspace/chromedriver");
			
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			
			// add options parameter to run in headless mode
			driver = new ChromeDriver(options);
		} else if (browserName.equals("firefox")) {
			// execute in firefox driver
			
		} else if (browserName.equals("IE")) {
			// execute in IE driver
		}
		
		// Apply timeout to all test cases in the framework
		// Gives amount of second to wait before failing the test case
		// Good for application with lots of data to load e.g. images, videos 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Send the driver object back to calling class
		return driver;

	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String scDestition = System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(scDestition));
		return scDestition;
		
	}
}
