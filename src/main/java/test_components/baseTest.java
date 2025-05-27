package test_components;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;


public class baseTest {
	public WebDriver driver ;
	
	public WebDriver driverInitalizer() throws IOException
	{
		;
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resorces\\browser.properties");
		prop.load(fis);
		
		String browserName = System.getProperty("browser") !=null ? System.getProperty("browser") :  prop.getProperty("browser");
		if(browserName.contains("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
				if(browserName.contains("headless"))
				{
					options.addArguments("--headless");
				}
			 driver = new ChromeDriver(options);
			
		}else if(browserName.contains("firefox"))
		{
			driver = new FirefoxDriver();
			
		}else if(browserName.contains("edge"))
		{
			driver = new EdgeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	public String getScreenShot(String testcaseName , WebDriver driver) throws IOException
	{
		
		TakesScreenshot ss = (TakesScreenshot)driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		File path = new File(System.getProperty("user.dir")+ testcaseName + ".png");
		FileUtils.copyFile(src, path);
		return System.getProperty("user.dir")+ testcaseName + ".png";
		
	}
	
	
	@BeforeMethod
	public void setup() throws IOException
	{
		driver = driverInitalizer();
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	@AfterMethod
	public void teardown()
	{
		if(driver != null )
		{
			driver.quit();
		}
	}
}
