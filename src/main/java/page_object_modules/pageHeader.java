package page_object_modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageHeader {
	WebDriver driver;
	public pageHeader(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//page factory
	@FindBy(xpath="(//button[contains(@class,'btn btn-custom')])[1]") WebElement homeButton;
	@FindBy(xpath="(//button[contains(@class,'btn btn-custom')])[2]") WebElement orderButton;
	@FindBy(xpath="(//button[contains(@class,'btn btn-custom')])[3]") WebElement cartButton;
	@FindBy(xpath="(//button[contains(@class,'btn btn-custom')])[4]") WebElement signoutButton;

	//actions 
	
	public void homeButton()
	{
		homeButton.click();
	}

	public void orderButton()
	{
		orderButton.click();
	}
	public void cartButton()
	{
		cartButton.click();
	}
	public void signoutButton()
	{
		signoutButton.click();
	}
	
}
