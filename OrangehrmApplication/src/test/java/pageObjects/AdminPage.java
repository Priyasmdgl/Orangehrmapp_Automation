package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage {
	
    @FindBy(linkText = "Admin")
	public static WebElement Admin;
    @FindBy(linkText = "User Management ")
    public static WebElement UserManagement;
    @FindBy(linkText = "Users")
    public static WebElement Users;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
    public static WebElement username;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]")
    public static WebElement userrole;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[1]")
    public static WebElement status;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
    public static WebElement search;
    @FindBy(xpath = "//tr/td[3]")
    public static WebElement userrolevalue;
    @FindBy(xpath = "//tr/td[5]")
    public static WebElement userstatusvalue;
}
