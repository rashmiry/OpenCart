package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.SearchPage;

public class TC_004_SearchPageTest extends BaseClass
{
	@Test(groups = {"Sanity","Regression","Master"})
	public void verifySearchProduct()
	{
		logger.info("Starting Search Product Test");
		 driver.get(p.getProperty("appURL"));
		
		SearchPage search = new SearchPage(driver);
		search.searchProduct("Android");
		
		logger.info("Product name entered in search box");
		
		search.clickSearchButton();
		
		logger.info("Clicked Search button");
		
		Assert.assertTrue(driver.getPageSource().contains("Android"));
		
		logger.info("Search Product Test Passed");
	}
	

}
