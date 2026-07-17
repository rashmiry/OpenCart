package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage
{
	public AccountRegistration(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-firstname']") WebElement txtFirstname;
	
	@FindBy(xpath = "//input[@id='input-lastname']") WebElement txtLastname;
	
	@FindBy(xpath = "//input[@id='input-email']") WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='input-telephone']") WebElement txtTelephone;
	
	@FindBy(xpath = "//input[@id='input-password']") WebElement txtPassword;
	
	@FindBy(xpath = "//input[@id='input-confirm']") WebElement txtConfirmPassword;
	
	@FindBy(xpath = "//input[@name='agree']") WebElement checkPolicy;
	
	@FindBy(xpath = "//input[@value='Continue']") WebElement btnContinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;

	public void setFirstName(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void setLasttName(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String phone)
	{
		txtTelephone.sendKeys(phone);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPwd(String pwd)
	{
		txtConfirmPassword.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy()
	{
		checkPolicy.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmMsg()
	{
		try 
		{
			return (msgConfirmation.getText());
			
		} 
		catch (Exception e)
		{
			return (e.getMessage());
		}
	}
}
