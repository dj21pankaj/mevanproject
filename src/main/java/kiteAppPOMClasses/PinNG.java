package kiteAppPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PinNG 
{    
	@FindBy(xpath="//input[@id='pin']") private WebElement Pin;
    @FindBy(xpath="//button[@type='submit']") private WebElement CountinousButton;
	
	public PinNG(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	
	public void sendpin(String pin) {
		Pin.sendKeys(pin);
	}
	
	public void clickCountiButton() {
     CountinousButton.click();
	
	}

}
