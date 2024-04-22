package baseTest;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import base.BasePage;
import pages.LoginPage;
import pages.RegisterPage;

public class BaseTest extends BasePage{
	
	BasePage objBasePage;
	WebDriver driver;
	protected LoginPage objLoginPage; // protected to have some restriction that it should only be called in the respective child classes
	protected RegisterPage objRegisterPage;
	
	
	@BeforeTest
	public void setUp() throws IOException {
	 objBasePage = new BasePage();
	 driver=objBasePage.launchBrowser();  //this driver will not be null as it would be fetching driver value from base page
	 objLoginPage =new LoginPage(driver); // we created object of login page here to avoid same object creation in every test script of loginPagetest
	}
	
	
/*	@BeforeClass
	public void doLogin() {
		objLoginPage =new LoginPage(driver);
		boolean btnClicked = objLoginPage.clickOnLoginButtonOfHomePage();
		Assert.assertEquals(btnClicked, true);
	}*/
	
	@AfterTest
	public void tearDown()  {
	driver.quit();
  }

}
