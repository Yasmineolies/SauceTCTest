package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
	
		private WebDriver driver;
		private By menuToAccessLogOut = By.xpath("//button[contains(text(),'Open Menu')]");
		private By logoutButton = By.xpath("//a[@id='logout_sidebar_link']");
		private By itemsInCart = By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']");
		private By BikeLightButton = By.xpath("//div[@class =\"inventory_list\"]/child::div[2]/child::div[3]/button");
		private By OnesieButton = By.xpath("//div[@class =\"inventory_list\"]/child::div[5]/child::div[3]/button");
		private By ShoppingCart = By.xpath("//div[@class =\"shopping_cart_container\"]");
		private By CartQuantityOnCartElement = By.xpath("//span[@class =\"fa-layers-counter shopping_cart_badge\"]");
				
		public InventoryPage(WebDriver driver) {
			this.driver = driver;
		}
		
		public String getPageUrl() {
			return driver.getCurrentUrl();
		}
		
		public void logOut() {
			driver.findElement(menuToAccessLogOut).click();
			driver.findElement(logoutButton).click();
		}
		
		public  void ItemsInCart() {
			driver.findElement(itemsInCart);
		}
		
		public void AddBikeLightToCart() {
			driver.findElement(BikeLightButton).click();
		}
		
		public void AddOnesieToCart() {
			driver.findElement(OnesieButton).click();
		}
		
		public CartPage ClickOnShoppingCart() {
			driver.findElement(ShoppingCart).click();
			return new CartPage(driver);
		}
				
		public void NumberOfItemsInCart() {
		 	driver.findElement(CartQuantityOnCartElement).getSize();
		}
		
		public boolean areThereItemsInCart() {
			try {
				if (driver.findElement(CartQuantityOnCartElement).isDisplayed()) {
					return true;
				}
				else {
					return false;
				}
			} 
			catch (NoSuchElementException e) {
				return false;
			}
		}
		
		public int howManyItemsAreInCart() {
				String cartItems = driver.findElement(CartQuantityOnCartElement).getText();
				int item = Integer.parseInt(cartItems);
					return item;
		}
}
