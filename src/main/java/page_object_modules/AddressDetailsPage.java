package page_object_modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitsUtil;

public class AddressDetailsPage extends WaitsUtil{
	
	WebDriver driver;

	public AddressDetailsPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

}
