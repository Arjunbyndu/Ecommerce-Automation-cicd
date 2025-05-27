package tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_object_modules.LoginPage;
import test_components.baseTest;
import utilities.JsonDataReader;



public class LoginTest extends baseTest 
{
	
	@Test( dataProvider = "jsondata")
	//(description = "TC_Login_001: Verify successful login with valid username and password")
	public void verifySuccessfulLogin(HashMap<String ,String> input) throws IOException
	{
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginApplication(input.get("validUseremail"), input.get("ValidUserpwd"));
			
	}
	@Test(dataProvider = "jsondata")
	// Description = Verify error message with invalid username and valid password.
	public void InvalidLoginDetails(HashMap<String , String> input) throws IOException
	{

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginWithInvalidCredential(input.get("invalidUseremail"), input.get("ValidUserpwd"));
		String errorMessage = driver.findElement(By.xpath("//div[@role='alertdialog']")).getText();
		System.out.println(errorMessage);
		

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

