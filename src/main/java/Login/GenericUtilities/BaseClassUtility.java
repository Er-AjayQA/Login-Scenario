package Login.GenericUtilities;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassUtility {

	public ExcelFileUtility eUtil= new ExcelFileUtility();
	public PropertyFileUtility pUtil= new PropertyFileUtility();
	public WebDriverUtility wUtil= new WebDriverUtility();
	public WebDriver driver= null;
	
	@BeforeClass
	public void beforeClass() throws IOException {
		String browserValue= pUtil.getPropertyFileValue("Browser");
		String baseUrl= pUtil.getPropertyFileValue("BaseUrl");
		
		if(browserValue.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(browserValue.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if(browserValue.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		else {
			System.out.println("Invalid browser value.");
		}
		
		wUtil.implicitWait(driver, 10);
		wUtil.maximizeWindow(driver);
		wUtil.openUrl(driver, baseUrl);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
