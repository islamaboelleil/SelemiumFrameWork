package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends PageBase{

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="input.button-1.checkout-as-guest-button")
	WebElement guestBtn;
	@FindBy(id="BillingNewAddress_FirstName")
	WebElement fnTxt;
	@FindBy(id="BillingNewAddress_LastName")
	WebElement lnTxt;
	@FindBy(id="BillingNewAddress_Email")
	public WebElement emailTxt;
	@FindBy(id ="BillingNewAddress_CountryId")
	public WebElement countryList;
	@FindBy(id ="BillingNewAddress_PhoneNumber")
	public WebElement phoneTxt;
	@FindBy(id ="BillingNewAddress_City")
	public WebElement cityTxt;
	@FindBy(id ="BillingNewAddress_Address1")
	public WebElement addressTxt;
	@FindBy(id ="BillingNewAddress_ZipPostalCode")
	public WebElement postCodeTxt;
	@FindBy(css ="input.button-1.new-address-next-step-button")
	public WebElement continueBtn;
	@FindBy(id ="shippingoption_1")
	public WebElement shippingMethodRdo;
	@FindBy(css ="input.button-1.shipping-method-next-step-button")
	public WebElement continueshippingBtn;
	@FindBy(css ="input.button-1.payment-method-next-step-button")
	public WebElement continuepaymentBtn;
	@FindBy(css ="input.button-1.payment-info-next-step-button")
	public WebElement continueInfoBtn;
	@FindBy(css ="a.product-name")
	public WebElement productName;
	@FindBy(css ="input.button-1.confirm-order-next-step-button")
	public WebElement confirmBtn;
	@FindBy(css ="h1")
	public WebElement Thankyoulbl;
	@FindBy(css ="div.title")
	public WebElement successMessage;
	@FindBy(linkText ="Click here for order details.")
	public WebElement orderdetailsLinkk;

	public void RegisteredUserCheckOutProduct(String countryName, String address, 
			String postcode, String phone, String city, String productName) throws InterruptedException
	{
		selcet = new Select(countryList);
		selcet.selectByVisibleText(countryName);
		setTextElementText(cityTxt, city);
		setTextElementText(addressTxt, address);
		setTextElementText(postCodeTxt, postcode);
		setTextElementText(phoneTxt, phone);
		clickButton(continueBtn);
		clickButton(shippingMethodRdo);
		clickButton(continueshippingBtn);
		Thread.sleep(1000);
		clickButton(continuepaymentBtn);
		Thread.sleep(1000);
		clickButton(continueInfoBtn);
	}
	public void confirmOrder() throws InterruptedException
	{
		Thread.sleep(1000);
		clickButton(confirmBtn);
	}
	public void printOrder() throws InterruptedException
	{
		Thread.sleep(1000);
		clickButton(orderdetailsLinkk);
	}
	
	public void GuestCheckOutProduct(String firstName, String lastName, String countryName, String email, String address, 
			String postcode, String phone, String city, String productName) throws InterruptedException
	{
		clickButton(guestBtn);
		setTextElementText(fnTxt, firstName);
		setTextElementText(lnTxt, lastName);
		setTextElementText(emailTxt, email);
		selcet = new Select(countryList);
		selcet.selectByVisibleText(countryName);
		setTextElementText(cityTxt, city);
		setTextElementText(addressTxt, address);
		setTextElementText(postCodeTxt, postcode);
		setTextElementText(phoneTxt, phone);
		clickButton(continueBtn);
		clickButton(shippingMethodRdo);
		clickButton(continueshippingBtn);
		Thread.sleep(1000);
		clickButton(continuepaymentBtn);
		Thread.sleep(1000);
		clickButton(continueInfoBtn);
	}

}
