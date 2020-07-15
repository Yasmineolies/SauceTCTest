package purchaing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.InventoryPage;

public class PurchasingItemsTest {
	private WebDriver driver;
	
	@BeforeClass
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//executable//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		//driver.findElement(By.xpath("//button[@id='details-button']")).click();
		//driver.findElement(By.xpath("//*[@id='proceed-link']")).click();
	}
	
	
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
