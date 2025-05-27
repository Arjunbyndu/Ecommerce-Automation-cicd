package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import test_components.baseTest;
import utilities.ExtentReporter;

public class TestListeners extends baseTest implements ITestListener {

	ExtentReports extent =ExtentReporter.extentReports();
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		
		 test =extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "pass");
		
		// initalize driver to ss method
				try {	
				driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
				} catch (Exception e) {
					e.printStackTrace();
				}
		// setting path for screenshot
				String path = null;
				try 
				{
					 path = getScreenShot(result.getMethod().getMethodName() , driver);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
	test.fail(result.getThrowable());
	// initalize driver to ss method
	
			try {
				
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
	
	
	// setting path for screenshot
		
			String path = null;
			try 
			{
				 path = getScreenShot(result.getMethod().getMethodName() , driver);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
			
	
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	

}
