package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	public HomePage(WebDriver driver)
	{
		super(driver); // Without super(driver), the parent class would not receive the driver, so page elements would not be initialized correctly.
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']") WebElement lnkAccount;
	 
//	@FindBy(xpath="((//a[normalize-space()='Register'])[1]") WebElement lnkRegister;
	@FindBy(linkText="Register") WebElement lnkRegister;
	
//	@FindBy(linkText="Login") WebElement lnkLogin;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement lnkLogin;
	
	public void clickMyAccount()
	{
		lnkAccount.click();
	}
	
	public void clickRegister()
	{
		lnkRegister.click();
	}

	public void clickLogin()
	{
		lnkLogin.click();
	}
	
	
	
}
