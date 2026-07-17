package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

/* Data is valid- login success - test pass - logout
 * Data is valid- login failed - test fail 
 
 * Data is invalid- login success - test fail - logout
 * Data is invalid- login failed - test pass 
 * */

public class TC_003_LoginDDT extends BaseClass
{
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "Datadriven") // getting data provider from different class and package
	public void verify_loginDDT(String email, String pwd, String exp_res) throws InterruptedException
	{
		logger.info("**** starting TC_003_LoginDDT *****");
		try
		{
			// home page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//login page
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLoginBtn();
			
			// my account page
			MyAccountPage macc = new MyAccountPage(driver);
			Boolean targetPage = macc.isMyAccountPageExists();
			
			
			if(exp_res.equalsIgnoreCase("Valid"))
			{
				// Data is valid- login success - test pass - logout
				if(targetPage == true)
				{
					Assert.assertTrue(true);
					macc.clickLogout();
				}
				// Data is valid- login failed - test fail
				else
				{
					Assert.assertTrue(false);
				}	
			}
			if(exp_res.equalsIgnoreCase("Invalid"))
			{
				// Data is invalid- login success - test fail - logout
				if(targetPage == true)
				{
					Assert.assertTrue(false);
					macc.clickLogout();
				}
				// Data is invalid- login failed - test pass 
				else
				{
					Assert.assertTrue(true);
				}
			}
			
		}
		catch (Exception e)
		{
			Assert.fail();
		}
		Thread.sleep(3000);
	logger.info("**** finished TC_003_LoginDDT *****");

	}
}