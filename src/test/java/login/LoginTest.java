package login;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.InventoryPage;

public class LoginTest extends BaseTest {
	
	@Test(priority=1)
	public void NoCredentialsEnteredAttemptLogin() {
		HomePage home = getDriver();
		home.ClickLoginButton();
		String message = home.SeeMessageDisplayedUponLoginClick();
		Assert.assertEquals(message, "Epic sadface: Username is required", "The login without credentials did not give expected result");
	}
		
	@Test(priority=2)
	public void OnlyPasswordEnteredLoginAttempt() {
		HomePage home = getDriver();
		 home.InputCredentials("","secret_sauce");
		home.ClickLoginButton();
		String message = home.SeeMessageDisplayedUponLoginClick();
		Assert.assertEquals(message, "Epic sadface: Username is required", "The login without credentials did not give expected result");
	}
	
	@Test(priority=3)
	public void OnlyUsernameEnteredLoginAttempt() {
		HomePage home = getDriver();
		home.InputCredentials("standard_user","");
		home.ClickLoginButton();
		String message = home.SeeMessageDisplayedUponLoginClick();
		Assert.assertEquals(message, "Epic sadface: Password is required", "The login without credentials did not give expected result");
	}
	
	@Test(priority=4)
	public void EnterWrongPassword() {
		HomePage home = getDriver();
		home.InputCredentials("standard_user","wrong_password");
		home.ClickLoginButton();
		String message = home.SeeMessageDisplayedUponLoginClick();
		Assert.assertEquals(message, "Epic sadface: Username and password do not match any user in this service", "Login with wrong password did not give expected results");
	}
	
	@Test(priority=5)
	public void EnterWrongUsername() {
		HomePage home = getDriver();
		home.InputCredentials("wrong_username","secret_sauce");
		home.ClickLoginButton();
		String message = home.SeeMessageDisplayedUponLoginClick();
		Assert.assertEquals(message, "Epic sadface: Username and password do not match any user in this service", "Login with wrong password did not give expected results");
	}
	
	@Test(priority=6)
	public void CorrectCredentialsLoginEnterKey() {
		HomePage home = getDriver();
		home.InputCredentials("standard_user","secret_sauce");
		InventoryPage inventory = home.EnterKey();
		String ActualPage = inventory.getPageUrl();
		Assert.assertEquals(ActualPage, "https://www.saucedemo.com/inventory.html", "User is not on the inventory page");
		home.BackButton();
	}
		
	@AfterMethod
	public void Refresh() {
		driver.navigate().refresh();
	}
}
