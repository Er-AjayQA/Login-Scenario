package LoginObejctRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Login.GenericUtilities.WebDriverUtility;

public class LoginPage extends WebDriverUtility{

	@FindBy(xpath= "//input[@id='username' and @name='username']") private WebElement userNameTextField;
	@FindBy(xpath= "//input[@id='password' or @name='password']") private WebElement passwordTextField;
	@FindBy(xpath= "//button[contains(.,'Submit')]") private WebElement submitButton;
	@FindBy(xpath= "//div[@id='error']") private WebElement actualErrorText;
	

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getActualErrorText() {
		return actualErrorText;
	}


	// Business Library


	public void loginWithGivenCredentials(WebDriver driver, String userName, String password) {
		userNameTextField.sendKeys(userName);
		passwordTextField.sendKeys(password);
		submitButton.click();
	}
	
	public void validateErrorMsg(WebDriver driver, String expectedErrorMsg) {
		String actualtErrorMsg= actualErrorText.getText();
		Assert.assertEquals(actualtErrorMsg, expectedErrorMsg);
	}
	
	
}
