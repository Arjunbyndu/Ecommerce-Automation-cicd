package page_object_modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitsUtil;

public class OrderConfirmationPage extends WaitsUtil{

	WebDriver driver;

	public OrderConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
}
