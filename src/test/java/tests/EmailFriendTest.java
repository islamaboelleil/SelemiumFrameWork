package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase{
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailPage emailObject;
	
	//1- User Registration
	@Test(priority = 1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.UserRegistration("islam28", "AboElLeil", "test128@gmail.com", "12345678");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	//2- Search For Product
	@Test(priority = 2)
	public void UserCanSearchwithAutoSuggest()
	{
		try {
			searchObject = new SearchPage(driver);
			detailsObject = new ProductDetailsPage(driver);
			searchObject.ProductSearchUsingAutoSuggest("MacB");
			Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
		} catch (Exception e) {
			System.out.println("Error occurred"+e.getMessage());
		}
		
	}
	//3- Email To Friend
	@Test(priority = 3)
	public void RegisterUserCanSendProductToFriend()
	{
		detailsObject.openSendEmail();
		emailObject = new EmailPage(driver);
		emailObject.sendEmailToFriend("aaa@gmail.com", "Hello my friend , check this product");
		Assert.assertTrue(emailObject.messageNotification.getText().contains("Your message has been sent"));
	}
	//4- Logout
	@Test(priority = 4)
	public void RegisterUserCanLogout()
	{
		registerObject.userlogout();
	}

}
