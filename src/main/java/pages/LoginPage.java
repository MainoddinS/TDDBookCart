package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eUtil;
	
	//Page Locators :
	private By loc_btnLoginHome = By.xpath("//button[@class='mat-mdc-tooltip-trigger mdc-button mdc-button--unelevated mat-mdc-unelevated-button mat-primary mat-mdc-button-base ng-star-inserted']");
	private By loc_btnRegister = By.xpath("//span[text()='Register']/parent::button");
	private By loc_fieldUsername = By.xpath("//input[@class='mat-mdc-input-element ng-tns-c19-1 mat-mdc-form-field-input-control mdc-text-field__input ng-pristine ng-invalid cdk-text-field-autofill-monitored ng-touched']");
	private By loc_fieldPass = By.xpath("//input[@class='mat-mdc-input-element ng-tns-c19-2 mat-mdc-form-field-input-control mdc-text-field__input ng-untouched ng-pristine ng-invalid cdk-text-field-autofill-monitored']");
	
	
	//Page Constructor :
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eUtil = new ElementUtil(driver);
	}
	
	
	//Page Methods/Actions :
	
	
	/**
	 * @author : Mainoddin
	 * @Description: Method to click On Login Button Of Home Page
	 * @returnType : 
	 * @date : 2024
	 */
	public boolean clickOnLoginButtonOfHomePage(){
		eUtil.waitForElementPresence(loc_btnLoginHome, 4);
		eUtil.getElement(loc_btnLoginHome).click();
		boolean clickRes=eUtil.getElement(By.xpath("//span[text()='New User? ']")).isDisplayed();
		return clickRes;
	}
	
	
	/**
	 * @author : Mainoddin
	 * @Description: 
	 * @returnType : 
	 * @date : 2024
	 */
	public void enterUserNameToLogin(String user){
		eUtil.waitForElementPresence(loc_fieldUsername, 4);
		eUtil.getElement(loc_fieldUsername).sendKeys(user);
	}
	
	
	/**
	 * @author : Mainoddin
	 * @Description: 
	 * @returnType : 
	 * @date : 2024
	 */
	public void enterPasswordToLogin(String pass){
		eUtil.getElement(loc_fieldPass).sendKeys(pass);
	}
	
	
	
	/**
	 * @author : Mainoddin
	 * @Description: Method to navigate to Register page 
	 * @returnType : 
	 * @date : 2024
	 */
	public RegisterPage navigateToRegisterPage(){
		eUtil.doClick(loc_btnRegister);
		return new RegisterPage(driver);
	}

}
