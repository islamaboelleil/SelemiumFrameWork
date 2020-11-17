package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css="td.product")
	public WebElement productCell;
	@FindBy(css="h1")
	public WebElement wishlistHeader;
	@FindBy(name="updatecart")
	WebElement updatewishListBtn;
	@FindBy(name="removefromcart")
	WebElement removefromcartCheck;
	@FindBy(css="div.no-data")
	public WebElement emptyCartLbl;
	
	public void removeProductFromWishlist()
	{
		clickButton(removefromcartCheck);
		clickButton(updatewishListBtn);
	
	}
}
