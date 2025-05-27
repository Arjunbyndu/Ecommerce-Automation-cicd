package tests;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import page_object_modules.LoginPage;

public class maintest 
{

	@Test
	//(description = "TC_Login_001: Verify successful login with valid username and password")
	public void verifySuccessfulLogin()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/client/");
		String useremail = "javaprogram56@gmail.com";
		String userpwd = "Java@1234";
		
	
		
		
	}
}
