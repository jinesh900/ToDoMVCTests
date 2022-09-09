package library;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import definitions.TestBase;

public class Utility extends TestBase implements ITestListener{
	
	WebDriver driver;
		    
    public void onTestFailure(ITestResult result) {
    	//String methodName=result.getMethod().toString().trim();
        driver = TestBase.getDriver();
    	takeScreenShot("result", driver);
    	driver.quit();
    }
    
    public void takeScreenShot(String methodName, WebDriver driver) {
    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         
            try {
            	FileHandler.copy(scrFile, new File("./Screenshots/result"+System.currentTimeMillis()+".png"));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
    }
    
    public void onTestSuccess(ITestResult result) {
    	driver = TestBase.getDriver();
    	driver.quit();
    }

}



