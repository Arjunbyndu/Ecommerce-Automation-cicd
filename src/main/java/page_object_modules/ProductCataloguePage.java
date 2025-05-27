package page_object_modules;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitsUtil;

public class ProductCataloguePage extends WaitsUtil{

	WebDriver driver;

	public ProductCataloguePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="(//div[@class='row'])[3]") WebElement allCatalogProduct;
	@FindBy(xpath="//div[@class='card']") List<WebElement> productItems;
	
	
	
	
	//action 
	
	public boolean waitForProductCatalogLoad()
	{
		waitForVisibilityOfElements(allCatalogProduct);
		return allCatalogProduct.isDisplayed() && !productItems.isEmpty();
	}
	
	public int getProductCount()
	{
		waitForProductCatalogLoad();
		return  productItems.size();
		
		
	}
}
