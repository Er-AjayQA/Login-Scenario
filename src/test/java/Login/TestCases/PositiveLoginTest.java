package Login.TestCases;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import Login.GenericUtilities.BaseClassUtility;
import LoginObejctRepository.LoginPage;
import LoginObejctRepository.HomePage;

public class PositiveLoginTest extends BaseClassUtility{
	
	@Test
	public void positiveLoginTest() throws EncryptedDocumentException, IOException {		
		String userName= eUtil.getExcelFileData("Login-Credentials", 1, 2);
		String password= eUtil.getExcelFileData("Login-Credentials", 1, 3);
		String expectedUrl= eUtil.getExcelFileData("Login-Credentials", 1, 4);
		String actualValidationMsg= eUtil.getExcelFileData("Login-Credentials", 1, 5);
		
		LoginPage lp= new LoginPage(driver);
		lp.loginWithGivenCredentials(driver, userName, password);
		
		HomePage hp= new HomePage(driver);
		hp.validateSuccessfullLoginUrl(driver, expectedUrl);
		hp.validateSuccessfullLoginMsg(driver, actualValidationMsg);
		hp.logout(driver);
	}
}
