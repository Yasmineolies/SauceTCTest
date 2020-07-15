package login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;

public class LoginTest {
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
	
	@Test(priority=1)
	public void NoCredentialsEnteredAttemptLogin() {
		HomePage home = new HomePage(driver);
		home.ClickLoginButton();
		String message = home.SeeMessageDisplayedUponLoginClick();
		Assert.assertEquals(message, "Epic sadface: Username is required", "The login without credentials did not give expected result");
	}
		
	@Test(priority=2)
	public void OnlyPasswordEnteredLoginAttempt() {
		HomePage home = new HomePage(driver);
		home.InputCredentials("","secret_sauce");
		home.ClickLoginButton();
		String message = home.SeeMessageDisplayedUponLoginClick();
		Assert.assertEquals(message, "Epic sadface: Username is required", "The login without credentials did not give expected result");
	}
	
	@Test(priority=3)
	public void OnlyUsernameEnteredLoginAttempt() {
		HomePage home = new HomePage(driver);
		home.InputCredentials("standard_user","");
		home.ClickLoginButton();
		String message = home.SeeMessageDisplayedUponLoginClick();
		Assert.assertEquals(message, "Epic sadface: Password is required", "The login without credentials did not give expected result");
	}
		
	@AfterMethod
	public void Refresh() {
		driver.navigate().refresh();
	}
}
