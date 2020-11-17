package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegistrationPage;

public class RegisteredUserCheckOutProduct extends TestBase{

	OrderDetailsPage ordersObject;
	HomePage homeObject;
	SearchPage searchObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartPage;
	String productName = "Apple MacBook Pro 13-inch";
	CheckOutPage checkoutObject;


	@Test(priority = 1)
	public void UserCanRegisterSuccessfully() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.UserRegistration("islam37", "AboElLeil", "test137@gmail.com", "12345678");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
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
	@Test(priority = 3)
	public void UserCanAddProductToShoppingCart() throws InterruptedException
	{
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddToCart();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com"+"/cart");
		cartPage = new ShoppingCartPage(driver);
		Assert.assertTrue(cartPage.totalLbl.getText().contains("$3,600.00"));
	}
	@Test(priority = 4)
	public void UserCanCheckOutProduct() throws InterruptedException
	{
		checkoutObject = new CheckOutPage(driver);
		cartPage.openCheckOutPage();
		checkoutObject.RegisteredUserCheckOutProduct
		("Egypt", "test address", "123456", "32445566688", "Cairo", productName);
		Assert.assertTrue(checkoutObject.productName.isDisplayed());
		Assert.assertTrue(checkoutObject.productName.getText().contains(productName));
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.Thankyoulbl.isDisplayed());
		Thread.sleep(1000);
		checkoutObject.printOrder();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		ordersObject = new OrderDetailsPage(driver);
		ordersObject.downloadPDFInvoice();
		ordersObject.printOrderDetails();
	}

	@Test(priority = 5)
	public void RegisterUserCanLogout()
	{
		registerObject.userlogout();
	}

}
