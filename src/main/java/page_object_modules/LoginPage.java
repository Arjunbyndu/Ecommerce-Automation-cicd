package page_object_modules;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test_components.baseTest;
import utilities.WaitsUtil;

public class LoginPage extends WaitsUtil
{

	WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	// page factory elements
	@FindBy(id="userEmail") WebElement userEmailField;
	@FindBy(id="userPassword") WebElement userPasswordField;
	@FindBy(css="#login") WebElement loginButton;
	@FindBy(xpath="//div[@role='alertdialog']") WebElement errormessage;
	
	// Actions 
	public void loginApplication(String userEmail , String password) throws IOException
	{
		//setup();
		userEmailField.sendKeys(userEmail);
		userPasswordField.sendKeys(password);
		loginButton.click();
	}
	
	public void loginWithInvalidCredential(String userEmail , String password) throws IOException
	{
		userEmailField.sendKeys(userEmail);
		userPasswordField.sendKeys(password);
		loginButton.click();
		waitForVisibilityOfElements(errormessage);
		
		
	}
}
