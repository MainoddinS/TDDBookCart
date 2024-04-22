package pagesTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseTest.BaseTest;

public class LoginPageTest extends BaseTest{
	
	@DataProvider
	public Object[][] getLoginCredentialsData(){
		return new Object[][] {
			{"ABC12345", "Abc12345$"}	
		};
	}
	
	
	@Test(dataProvider="getLoginCredentialsData")
	public void LoginTest(String UName, String PassW) {
		objLoginPage.clickOnLoginButtonOfHomePage();
		objLoginPage.enterUserNameToLogin(UName);
		objLoginPage.enterPasswordToLogin(PassW);
	}

}
