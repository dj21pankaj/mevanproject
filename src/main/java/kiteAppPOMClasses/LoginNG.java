package kiteAppPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginNG {

	   @FindBy(xpath="//input[@id='userid']") private WebElement userID;
	   @FindBy(xpath="//input[@id='password']") private WebElement Password;
	   @FindBy(xpath="//button[@type='submit']") private WebElement LoginButton;
	   @FindBy(xpath="//span[contains(text(),'User ID should ')]") private WebElement userIDErrorMSG;
	   @FindBy(xpath="//span[contains(text(),'Password should be')]") private WebElement passwordIDErrorMSG;
	   public LoginNG(WebDriver driver) 
	   {
		   PageFactory.initElements(driver,this);
	   }
	   
	   public void senduserid(String uid) 
	   {
		   userID.sendKeys(uid);
	   }
	   
	   public void sendpassword(String pass) 
	   {
		   Password.sendKeys(pass);
	   }
	   
	   public void clickloginButton() 
	   {
		   LoginButton.click();
	   }
	   
	   public String getuserIDErrorMSG() 
	   {
		   String errorMSG = userIDErrorMSG.getText();
		   return errorMSG;
	   }
	   public String getpasswordIDErrorMSG() 
	   {
		   String errorMSG=passwordIDErrorMSG.getText();
		   return errorMSG;
		   
	   }

}
