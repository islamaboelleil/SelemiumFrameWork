package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}
	@FindBy(css ="a.ico-register")
	WebElement registerLink;
	@FindBy(css ="a.ico-login")
	WebElement loginLink;
	@FindBy(linkText ="Contact us")
	WebElement ContactUsLink;
	@FindBy(id ="customerCurrency")
	WebElement currencydrl;
	@FindBy(linkText ="Computers")
	WebElement computerMenu;
	@FindBy(linkText ="Notebooks")
	WebElement noteBooksMenu;
	
	public void openRegistrationPage()
	
	{
		clickButton(registerLink);
	}
	public void openLoginPage()
	{
		clickButton(loginLink);
	}
	public void openContactUsPage()
	{
		scrollToBottom();
		clickButton(ContactUsLink);
	}
	public void changeCurrency()
	{
		selcet = new Select(currencydrl);
		selcet.selectByVisibleText("Euro");
	}
	public void selectNoteBooksMenu()
	{
		action.moveToElement(computerMenu).moveToElement(noteBooksMenu)
		.click()
		.build()
		.perform();

	}
}
