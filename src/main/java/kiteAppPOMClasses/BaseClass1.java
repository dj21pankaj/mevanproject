package kiteAppPOMClasses;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

public class BaseClass1 
{
	protected WebDriver driver;
    public void lunchBrowser() 
    {
    	 Reporter.log("Lunching Chrome Browser",true);
   	    System.setProperty("webdriver.chrome.driver","C:\\Users\\Pankaj\\Desktop\\Testing\\Automation\\chromedriver_win32\\chromedriver.exe");
   	    ChromeOptions opt=new ChromeOptions();
   	    opt.addArguments("--disable-notifications");
   	    driver=new ChromeDriver(opt);
   	    driver.get("https://kite.zerodha.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		driver.manage().window().maximize(); 
		Reporter.log("Browser Lunch Succesful",true);
    }
    
    public void closeBrowser() 
    {
    	Reporter.log("Closing Browser",true);
	    driver.close();
    }
}
