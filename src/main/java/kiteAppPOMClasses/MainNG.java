package kiteAppPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainNG {
	@FindBy(xpath="//span[@class='user-id']") private WebElement userID;
	@FindBy(xpath="//a[@target='_self']") private WebElement LogOutButton;
	
	public MainNG(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public String getactualuserid() 
	{
		
		String actualID = userID.getText();
		return actualID;
		
	}
	//we will verify using testNG assert so not use if else statement
	public void clickLogoutButton() throws InterruptedException {
		userID.click();
		Thread.sleep(1000);
		LogOutButton.click();
		
		
		
		
		
	}

}
