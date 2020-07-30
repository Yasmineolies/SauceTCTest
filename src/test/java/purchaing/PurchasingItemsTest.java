package purchaing;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.InventoryPage;

public class PurchasingItemsTest extends BaseTest {
		
	@Test
	public void LoginVerifyAddedItemToCartIsDisplayed() {
		HomePage home = new HomePage(driver);
		home.InputCredentials("standard_user","secret_sauce");
		InventoryPage inventory = home.PressLoginButtonPass();
		String ActualPage = inventory.getPageUrl();
		Assert.assertEquals(ActualPage, "https://www.saucedemo.com/inventory.html", "User is not on the inventory page");
		System.out.println("https://www.saucedemo.com/inventory.html = " + ActualPage + ". Inventory assert passed");
		boolean isCartEmtpy = inventory.areThereItemsInCart();
		Assert.assertFalse(isCartEmtpy);
		inventory.AddBikeLightToCart();
		int oneItem = inventory.howManyItemsAreInCart();
		Assert.assertEquals(oneItem, 1);
		inventory.AddOnesieToCart();
		int twoItems = inventory.howManyItemsAreInCart();
		Assert.assertEquals(twoItems, 2);
		CartPage cart = inventory.ClickOnShoppingCart();
		int bikeAmount = cart.QuantityOfParticularItemInCart(cart.FirstItemInCartQuantity);
		Assert.assertEquals(1, bikeAmount);
		double bikePrice = cart.PriceOfParticularItemInCart(cart.BikeLightPriceTagInCart);
		Assert.assertEquals(9.99, bikePrice);
		int onesieAmount = cart.QuantityOfParticularItemInCart(cart.SecondItemInCartQuantity);
		Assert.assertEquals(1, onesieAmount);
		double onesiePrice = cart.PriceOfParticularItemInCart(cart.OnesiePriceTagInCart);
		Assert.assertEquals(7.99, onesiePrice);
	}
}
