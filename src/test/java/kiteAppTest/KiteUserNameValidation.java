package kiteAppTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import kiteAppPOMClasses.BaseClass1;
import kiteAppPOMClasses.LoginNG;
import kiteAppPOMClasses.MainNG;
import kiteAppPOMClasses.PinNG;
import kiteAppPOMClasses.Utility1;

public class KiteUserNameValidation extends BaseClass1
{
	LoginNG login;
	PinNG pin;
	MainNG main;
	
	@BeforeClass
	public void browserlunch() 
	{
		lunchBrowser();
		login=new LoginNG(driver);
		pin=new PinNG(driver);
		main=new MainNG(driver);
	}
	
	@BeforeMethod
	public void loginToKiteApp() throws EncryptedDocumentException, IOException 
	
	{
		login.senduserid(Utility1.readDataFromExcel(0, 0));
		login.sendpassword(Utility1.readDataFromExcel(0, 1));
		login.clickloginButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		
		pin.sendpin(Utility1.readDataFromExcel(0, 2));
		pin.clickCountiButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		
	}
	 @Test
    public void validateuUserName() throws EncryptedDocumentException, IOException 
    {
		 int TCID=100;
		 String actualuserID = main.getactualuserid();
    	 String expectedUserID = Utility1.readDataFromExcel(0, 0);
    	 Assert.assertEquals(expectedUserID, actualuserID,"Actual and Expected Not Equal TC Fail");
    	 Utility1.takescreenshot(driver, TCID);
    	 Reporter.log("validate userID",true);
    
    }
	 
    @AfterMethod
    public void logoutKiteApp() throws InterruptedException 
    {
    	main.clickLogoutButton();
    	Reporter.log("logout Kite App",true);
    	
    }
	 @AfterClass
	 public void closingBrowser() 
	 {
		 closeBrowser();
		 Reporter.log("close Browser",true);
	 }
	 
	 
	 
	 
}
