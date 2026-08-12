package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.SearchPage;
import utilities.ExtentReportManager;

public class TC_004_SearchPageTest extends BaseClass
{
	@Test(groups = {"Sanity","Regression","Master"})
	public void verifySearchProduct()
	{
		 driver.get(p.getProperty("appURL"));
		
		SearchPage search = new SearchPage(driver);
		search.searchProduct("Android");
		
		search.clickSearchButton();
		
		 // Check if "no product" message is displayed
		List<WebElement> noProductMsg = driver.findElements(By.xpath
				("//div[@id='content']//p[contains(text(),'There is no product that matches the search criteria.')]"));
		
		if (!noProductMsg.isEmpty()) {

		    String message = noProductMsg.get(0).getText();

		    logger.info("Search Result: " + message);
		    System.out.println("Search Result: " + message);

		} else {

		    logger.info("Search Result: Product(s) found successfully.");
		    System.out.println("Search Result: Product(s) found successfully.");
		}

			
			
// *********************this is to get the msg from the search windo after searching
//		String message = driver.findElement(
//				By.xpath("//div[@id='content']//p[2]")
//				).getText();
//			System.out.println("Message: " + message);
//			Assert.assertEquals(
//				    message,
//				    "There is no product that matches the search criteria."
//				);
		
		
//		Assert.assertTrue(driver.getPageSource().contains("Android"));

	}
	

}
