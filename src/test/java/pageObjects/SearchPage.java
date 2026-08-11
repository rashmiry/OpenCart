package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage
{
	
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(xpath = "//input[@placeholder='Search']") WebElement search_box;
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']") WebElement search_btn;
	
	 public void searchProduct(String productName)
	 {
		 search_box.clear();
		 search_box.sendKeys(productName);
		 
	 }
	 
	 public void clickSearchButton()
	 {
		 search_btn.click();
     }
}
