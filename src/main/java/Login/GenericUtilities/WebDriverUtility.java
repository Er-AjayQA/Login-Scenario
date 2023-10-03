package Login.GenericUtilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void implicitWait(WebDriver driver, int waitTime) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
	}
	
	public void explicitWaitForElementClickable(WebDriver driver, int waitTime, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void openUrl(WebDriver driver, String baseUrl) {
		driver.get(baseUrl);
	}
	
	public void mouseHoverOnElement(WebDriver driver, WebElement element) {
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void mouseRightClick(WebDriver driver, WebElement element) {
		Actions act= new Actions(driver);
		act.contextClick(element);
	}
	
	public void selectByvalueDropdown(WebElement element, String value) {
		Select sel= new Select(element);
		sel.selectByValue(value);
	}
	
	public void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
	}

}
