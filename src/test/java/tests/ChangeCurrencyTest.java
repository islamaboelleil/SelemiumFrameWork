package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{
	
	HomePage homeObject;
	ProductDetailsPage detailsObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	
	@Test(priority = 1)
	public void UserCanChangeCurrency()
	{
		homeObject = new HomePage(driver);
		homeObject.changeCurrency();
	}
		@Test(priority = 2)
		public void UserCanSearchwithAutoSuggest()
		{
			try {
				searchObject = new SearchPage(driver);
				searchObject.ProductSearchUsingAutoSuggest("MacB");
				detailsObject = new ProductDetailsPage(driver);
				Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
				Assert.assertTrue(detailsObject.productPricelbl.getText().contains("€"));
			} catch (Exception e) {
				System.out.println("Error occurred"+e.getMessage());
			}
	}

}
