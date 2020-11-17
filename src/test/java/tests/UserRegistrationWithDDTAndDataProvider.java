package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndDataProvider extends TestBase
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	@DataProvider(name="testData")
	public static Object [] [] userData()
	{
		return new Object [] [] {
			{"Islam30", "AboElLeil", "test130@gmail.com", "12345678"},
			{"Ahmed30", "Ali", "testuser30@gmail.com", "123456"}};
	}
	@Test(priority = 1,alwaysRun = true,dataProvider = "testData")
	public void UserCanRegisterSuccessfully(String fname, String lname, String email, String password) throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.UserRegistration(fname, lname, email, password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		Thread.sleep(1000);
		registerObject.userlogout();
		Thread.sleep(1000);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userlogout();
	}
	
}
