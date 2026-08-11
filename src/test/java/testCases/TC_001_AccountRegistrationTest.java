package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.AccountRegistration;
import pageObjects.HomePage;

public class TC_001_AccountRegistrationTest extends BaseClass
{
	@Test(groups = {"Regression", "Master"})
	public void verify_account_registration()
	{
		logger.info("***** Staring TC_001_AccountRegistrationTest *****");
		
		try
		{
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			
			logger.info("****** clicked on my account link ****");
			hp.clickRegister();
			logger.info("clicked on register link");
			
			AccountRegistration ar = new AccountRegistration(driver);
			logger.info("Providing cx details");
		//		ar.setFirstName("rqwerty");
		//		ar.setLasttName("asdfg");
		//		ar.setEmail("phr@gmail.com");
		//		ar.setTelephone("7894561233");
		//		
		//		ar.setPassword("mnb123");
		//		ar.setConfirmPwd("mnb123");
			
			ar.setFirstName(randomString().toUpperCase());
			ar.setLasttName(randomString().toUpperCase());
			ar.setEmail(randomString() + "@gmail.com");
			ar.setTelephone(randomNumber());
			
			String password = randomPwd();
			ar.setPassword(password);
			ar.setConfirmPwd(password);
			
			ar.setPrivacyPolicy();
			ar.clickContinue();
			
			logger.info("Validating expected message");
			String confmsg = ar.getConfirmMsg();
//			if(confmsg.equals("Your Account Been Created!")) // INTENSIONALLY FAILING THE TEST CASE
			if(confmsg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Test Failed...");
				logger.debug("Debug logs....");
				Assert.assertFalse(false);
			}
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
//			logger.error("Test Failed...");
//			logger.debug("Debug logs....");
			Assert.fail();
		}
		logger.info("***** Finished TC_001_AccountRegistrationTest ****");
	}
	

}
