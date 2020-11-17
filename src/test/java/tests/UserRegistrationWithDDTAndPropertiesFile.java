package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndPropertiesFile extends TestBase
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String firstName = LoadProperties.userData.getProperty("firstname");
	String lastName = LoadProperties.userData.getProperty("lastname");
	String emaiL = LoadProperties.userData.getProperty("email");
	String passworD = LoadProperties.userData.getProperty("password");
	
	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		Thread.sleep(1000);
		registerObject.UserRegistration(firstName, lastName, emaiL, passworD);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userlogout();
		Thread.sleep(1000);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(emaiL, passworD);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userlogout();
	
	}
}
