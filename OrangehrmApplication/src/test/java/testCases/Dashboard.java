package testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
@Listeners(AllureTestNg.class)
public class Dashboard extends CommonFunctions{
	
	public static Logger logger = Logger.getLogger(Dashboard.class);
	public void login() {
		logger.info("Login to the application");
		PageFactory.initElements(driver, LoginPage.class);
		LoginPage.username.sendKeys(properties.getProperty("username"));
		LoginPage.password.sendKeys(properties.getProperty("password"));
		LoginPage.login.click();
	}

	@Test
	public void leavedata() {
	    login();
	    logger.info("Verifying whether the text is displayed or not");
		PageFactory.initElements(driver, DashboardPage.class);
	    String text = DashboardPage.leavedata.getText();
	    Assert.assertEquals(text, "No Employees are on Leave Today");
	   
	}
}
