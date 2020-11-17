package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase{
	
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	WishListPage wishlistObject;
	
	//1- Search For Product
	@Test(priority = 1)
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
	@Test(priority = 2)
	public void UserCanAddProductToWishlist()
	{
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddProductTowishlist();
		driver.navigate().to("https://demo.nopcommerce.com"+ "/wishlist");
		wishlistObject = new WishListPage(driver);
		Assert.assertTrue(wishlistObject.wishlistHeader.isDisplayed());
		Assert.assertTrue(wishlistObject.productCell.getText().contains(productName));
		
	}
	@Test(priority = 3)
	public void UserCanRemoveProductFromCart()
	{
		wishlistObject = new WishListPage(driver);
		wishlistObject.removeProductFromWishlist();
		Assert.assertTrue(wishlistObject.emptyCartLbl.getText().contains("empty!"));
	}	
}
