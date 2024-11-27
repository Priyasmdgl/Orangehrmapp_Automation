package testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import pageObjects.AdminPage;

public class Admin extends CommonFunctions {
	public static Logger logger = Logger.getLogger(Admin.class);
	public void userspage() {
		PageFactory.initElements(driver, AdminPage.class);
		Actions actions = new Actions(driver);
		actions.moveToElement(AdminPage.Admin);
		actions.moveToElement(AdminPage.UserManagement);
		actions.moveToElement(AdminPage.Users);
		actions.click().build().perform();
	}
	
	public void username() {
		PageFactory.initElements(driver, AdminPage.class);
		AdminPage.username.sendKeys("Admin");
	}

	public void userrole() {
		PageFactory.initElements(driver, AdminPage.class);
		Select selectrole = new Select(AdminPage.userrole);
		selectrole.selectByVisibleText("Admin");	
	}
	
	public void status() {
		PageFactory.initElements(driver, AdminPage.class);
		Select selectstatus = new Select(AdminPage.status);
		selectstatus.selectByVisibleText("Enabled");
	}
	
	@Test
	public void search() {
		logger.info("Navigating to users page");
		userspage();
		logger.info("Selecting the desired options");
		username();
		userrole();
		status();
		PageFactory.initElements(driver, AdminPage.class);
		AdminPage.search.click();
	String role = AdminPage.userrolevalue.getText();
	String status = AdminPage.userstatusvalue.getText();
	logger.info("Verifying the result");
	Assert.assertEquals(role, "Admin");
	Assert.assertEquals(status, "Enabled");
	logger.info("End of the test");
	}
}
