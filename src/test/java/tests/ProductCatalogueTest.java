package tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page_object_modules.LoginPage;
import page_object_modules.ProductCataloguePage;
import test_components.baseTest;
import utilities.JsonDataReader;

public class ProductCatalogueTest extends baseTest
{

	@Test(dataProvider = "jsondata")
	// TC_Product_001: Verify all 3 items are displayed correctly with name, price, and image.
	
	public void check_All_Item_Present(HashMap<String ,String> input) throws IOException
	{
		int requiredProductCOunt = 3;
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginApplication(input.get("validUseremail"), input.get("ValidUserpwd"));
		
		ProductCataloguePage homePage = new ProductCataloguePage(driver);
		int actualProductCount = homePage.getProductCount();
	
		System.out.println("Product count in home page is " + actualProductCount );
		
		Assert.assertEquals(actualProductCount, requiredProductCOunt , "The number of products displayed does not match the expected count.");
		
	}
	
	
	
	
	
	@DataProvider

	public Object[][] jsondata() throws IOException
	{
		JsonDataReader jsonDataReader = new JsonDataReader();
		//JsonDataReader.jsonDataReader();
		
		List<HashMap<String , String>> data = jsonDataReader.jsonDataReader(System.getProperty("user.dir")+ "\\src\\test\\java\\testdata\\userlogin.json");
		return new Object[][] { { data.get(0)}  };
		
	}
}
