package pages;

import java.math.BigDecimal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	public WebDriver driver;
	public By FirstItemInCartQuantity = By.xpath("//div[@class ='cart_list']/child::div[3]/child::div[1]");
	public By SecondItemInCartQuantity = By.xpath("//div[@class ='cart_list']/child::div[4]/child::div[1]");
	public By BikeLightPriceTagInCart = By.xpath("//div[@class ='cart_list']/child::div[3]/child::div[2]/child::div[2]/child::div[1]");
	public By OnesiePriceTagInCart = By.xpath("//div[@class ='cart_list']/child::div[4]/child::div[2]/child::div[2]/child::div[1]");
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public int QuantityOfParticularItemInCart(By NumberOfSameItems) {
		String NoOfItems = driver.findElement(NumberOfSameItems).getText();
		int item = Integer.parseInt(NoOfItems);
			return item;
	}
	
	public double PriceOfParticularItemInCart(By PriceOfItem) {
		String ItemPrice = driver.findElement(PriceOfItem).getText();
		Double item = Double.parseDouble(ItemPrice);
			return item;
	}
}
