package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(name="removefromcart")
	WebElement removeCheck;
	@FindBy(name="updatecart")
	WebElement updateCartBtn;
	@FindBy(css="input.qty-input valid")
	public WebElement quantityTxt;
	@FindBy(css ="span.product-subtotal")
	public WebElement totalLbl;
	@FindBy(id ="checkout")
	public WebElement checkoutBtn;
	@FindBy(id ="termsofservice")
	public WebElement agreeCheckBox;
	
	public void removeProductFromCart()
	{
		clickButton(removeCheck);
		clickButton(updateCartBtn);
	}
	public void updateProductquantityInCart(String quantity)
	{
		clearText(quantityTxt);
		setTextElementText(quantityTxt, quantity);
		clickButton(updateCartBtn);
	}
	public void openCheckOutPage() throws InterruptedException
	{
		
		Thread.sleep(1000);
		clickButton(agreeCheckBox);
		clickButton(checkoutBtn);
	}
}
