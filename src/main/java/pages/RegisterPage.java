package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ElementUtil;

public class RegisterPage {
	private WebDriver driver;
	private ElementUtil eUtil;
	
	//Page Locators :
	private By loc_btnLoginHome = By.xpath("//button[@class='mat-mdc-tooltip-trigger mdc-button mdc-button--unelevated mat-mdc-unelevated-button mat-primary mat-mdc-button-base ng-star-inserted']");
	private By loc_btnRegister = By.xpath("//span[text()='Register']/parent::button");
	private By loc_fieldFirstName = By.xpath("//input[@formcontrolname='firstname']");
	private By loc_fieldLastName = By.xpath("//input[@formcontrolname='lastname']");
	private By loc_fieldUserName = By.xpath("//input[@formcontrolname='username']");
	private By loc_fieldPassW = By.xpath("//input[@formcontrolname='password']");
	private By loc_fieldConfirmPassW = By.xpath("//input[@formcontrolname='confirmPassword']");
	private By loc_btnGenderMale = By.xpath("//label[normalize-space()='Male']");
	private By loc_btnGenderFemale = By.xpath("//label[normalize-space()='Female']");
	private By loc_headerLoginWindow = By.xpath("//span[text()='New User? ']");
	
	
	//Page Constructor :
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		eUtil = new ElementUtil(driver);
	}
	
	
	//Page Methods/Actions :
	
	
	/**
	 * @author : Mainoddin
	 * @Description: Method to click On Register Button 
	 * @returnType : 
	 * @date : 2024
	 */
	public void registerUser(String firstname, String lastname, String username, String password, String gender){
		eUtil.waitForElementPresence(loc_fieldFirstName, 5).sendKeys(firstname);
		eUtil.doSendKeys(loc_fieldLastName, lastname);
		eUtil.doSendKeys(loc_fieldUserName, username);
		eUtil.doSendKeys(loc_fieldPassW, password);
		eUtil.doSendKeys(loc_fieldConfirmPassW, password);
		
		if(gender.equalsIgnoreCase("Male")) {
			eUtil.doClick(loc_btnGenderMale);
		}else {
			eUtil.doClick(loc_btnGenderFemale);
		}
		
		eUtil.doClick(loc_btnRegister);
		eUtil.waitForElementPresence(loc_headerLoginWindow, 3).isDisplayed();
		System.out.println("User successfully registered");
		
		String HeaderMsg =eUtil.doElementGetText(loc_headerLoginWindow);
		System.out.println(HeaderMsg);
		if(HeaderMsg.contains("New")) {
			eUtil.waitForElementPresence(loc_btnRegister, 2).click();;
		}
	}
	
	
	

}
