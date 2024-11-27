package commonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonFunctions {
	
	    public static WebDriver driver = null;
	    public static Properties properties = null;
	    Logger logger = Logger.getLogger(CommonFunctions.class);
	    
	public Properties propertyFile() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
		 properties = new Properties();
		properties.load(fileInputStream);
		return properties;
	}
	@BeforeSuite
	public void openBrowser() throws IOException {
		PropertyConfigurator.configure("src/test/resources/log4j.properties");
		logger.info("Orangehrm test");
		logger.info("Loading property file");
		propertyFile();
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		String location = properties.getProperty("driverlocation");
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver" ,location);
			logger.info("Launching Chrome browser");
			driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\HP\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			logger.info("Launching Edge browser");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		logger.info("Navigate to Orangehrm application");
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterSuite
	public void closeBrowser() {
		logger.info("Execution completed");
		driver.quit();
		}
}
