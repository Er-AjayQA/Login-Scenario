package LoginObejctRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Login.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{

	@FindBy(xpath= "//a[contains(.,'Log out')]") private WebElement logoutButton;
	@FindBy(xpath= "//p[@class='has-text-align-center']/child::strong") private WebElement successfullLoginMsgText;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSuccessfullLoginMsgText() {
		return successfullLoginMsgText;
	}
	
	public WebElement getLogoutButton() {
		return logoutButton;
	}
	
	// Business Library

	public void logout(WebDriver driver) {
		logoutButton.click();
	}

	
	public void validateSuccessfullLoginUrl(WebDriver driver, String expectedUrl) {
		String actualUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	public void validateSuccessfullLoginMsg(WebDriver driver, String expectedMsg) {
		String actualMsg= successfullLoginMsgText.getText();
		Assert.assertEquals(actualMsg, expectedMsg);
	}
	
}
