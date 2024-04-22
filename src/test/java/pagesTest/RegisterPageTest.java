package pagesTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseTest.BaseTest;
import utils.ExcelUtil;

public class RegisterPageTest extends BaseTest{
	
	@BeforeClass
	public void registerSetUp() {
		objLoginPage.clickOnLoginButtonOfHomePage();
		objRegisterPage=objLoginPage.navigateToRegisterPage();
	}
	
	
	@DataProvider
	public Object[][] getRegTestData() {
		Object regData[][] = ExcelUtil.getTestData("register");
		return regData;
	}
	
	
	@Test(dataProvider="getRegTestData")
	public void doRegisterTest(String firstname, String lastname, String username, String password, String gender){
		objRegisterPage.registerUser(firstname, lastname, username, password, gender);
	}
	
}
