package Login.TestCases;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import Login.GenericUtilities.BaseClassUtility;
import LoginObejctRepository.LoginPage;

public class NegativePasswordLoginTest extends BaseClassUtility{
	
	@Test
	public void negativePasswordLoginTest() throws EncryptedDocumentException, IOException {		
		String userName= eUtil.getExcelFileData("Login-Credentials", 3, 2);
		String password= eUtil.getExcelFileData("Login-Credentials", 3, 3);
		String expectedErrorMsg= eUtil.getExcelFileData("Login-Credentials", 3, 5);
		
		
		LoginPage lp= new LoginPage(driver);
		lp.loginWithGivenCredentials(driver, userName, password);
		lp.validateErrorMsg(driver, expectedErrorMsg);
	}
}
