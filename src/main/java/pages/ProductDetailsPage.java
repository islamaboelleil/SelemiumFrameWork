package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css="strong.current-item")
	public WebElement productNamebreadCrumb;

	@FindBy(css="input.button-2.email-a-friend-button.valid")
     WebElement emailFriendBtn;
	@FindBy(css="span#price-value-4.price-value-4")
    public WebElement productPricelbl;
	
	@FindBy (linkText = "Add your review")
	public WebElement addReviewLink;
	@FindBy (id = "add-to-wishlist-button-4")
	public WebElement addwishlistBtn;
	@FindBy (css = "input.add-to-compare-list-button")
	public WebElement addCompareBtn;
	@FindBy (id = "add-to-cart-button-4")
	public WebElement addToCartBtn;
	public void openSendEmail()
	{
		clickButton(emailFriendBtn);
	}
	public void openAddReviewPage()
	{
		clickButton(addReviewLink);
	}
	public void AddProductTowishlist()
	{
		clickButton(addwishlistBtn);
	}
	public void AddProductToCompare()
	{
		clickButton(addCompareBtn);
	}
	public void AddToCart()
	{
		clickButton(addToCartBtn);
	}
}
