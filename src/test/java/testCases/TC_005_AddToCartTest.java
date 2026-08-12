package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.AddToCart;

public class TC_005_AddToCartTest extends BaseClass
{

	    @Test(groups = {"Sanity", "Regression", "Master"})
	    public void verifyAddHPProductToCart() {

	        logger.info("***** Starting TC_005_AddToCartTest *****");

	        // Create object of AddToCart Page
	        AddToCart atc = new AddToCart(driver);

	        // click on Laptops & Notebooks
	        atc.click_L_N();
	        
	        // Click Show All Laptops & Notebooks
	        atc.click_show_all();

	        // Click HP LP3065
	        atc.click_HP_LP3065();

	        // Click Add to Cart
	        atc.click_AddToCart();

	        // Get success message
	        String message = atc.getSuccessMessage();

	        logger.info("Success Message: " + message);

	        // Verify product added successfully
	        Assert.assertTrue(
	            message.contains("Success: You have added HP LP3065 to your shopping cart!"),
	            "HP LP3065 was not added to cart"
	        );

	        logger.info("HP LP3065 successfully added to cart");

	        logger.info("***** Finished TC_005_AddToCartTest *****");
	    }
	}
