package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private By userName = By.xpath("//*[@id='user-name']");
	private By passWord = By.xpath("//*[@id='password']");
	private By loginButton = By.xpath("//*[@class='btn_action']");
	private By displayText = By.xpath("//h3[@data-test]");
		
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void InputCredentials(String username, String password) {
		driver.findElement(userName).sendKeys(username); 
		driver.findElement(passWord).sendKeys(password);
	} 
	
	public String SeeMessageDisplayedUponLoginClick() {
		return driver.findElement(displayText).getText();
	}
	
	public void ClickLoginButton() {
		driver.findElement(loginButton).click();
	}
	
	public InventoryPage PressLoginButtonPass() {
		driver.findElement(loginButton).click();
		return new InventoryPage(driver);
	}
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public InventoryPage EnterKey() {
		driver.findElement(loginButton).sendKeys(Keys.ENTER);
		return new InventoryPage(driver);
	}
	
	public void BackButton() {
		driver.navigate().back();
	}
}
