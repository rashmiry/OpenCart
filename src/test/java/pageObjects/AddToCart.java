package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCart extends BasePage
{
	public AddToCart(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Laptops & Notebooks']") WebElement lnk_L_N;
	
	public void click_L_N()
	{
		lnk_L_N.click();
	}
	
	@FindBy(xpath = "//a[normalize-space()='Macs (0)']") WebElement lnk_Mac;
	public void click_Mac()
	{
		lnk_Mac.click();
	}
	
	@FindBy(xpath = "//a[normalize-space()='Windows (0)']") WebElement lnk_windows;
	public void click_Windows()
	{
		lnk_windows.click();
	}
	
	@FindBy(linkText = "Show AllLaptops & Notebooks") WebElement lnk_show_all;
	public void click_show_all()
	{
		lnk_show_all.click();
	}
	
	// HP LP3065
    @FindBy(xpath = "//a[normalize-space()='HP LP3065']")
    WebElement lnk_HP_LP3065;

    public void click_HP_LP3065() {
        lnk_HP_LP3065.click();
    }

    // Add to Cart button
    @FindBy(id = "button-cart")
    WebElement btn_addToCart;

    public void click_AddToCart() {
        btn_addToCart.click();
    }

    // Success message
    @FindBy(css = "div.alert.alert-success")
    WebElement msg_success;

    public String getSuccessMessage() {
        return msg_success.getText();
    }
	
}
