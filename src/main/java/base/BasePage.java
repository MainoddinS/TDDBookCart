package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public static WebDriver driver;
	private ChromeOptions co;
	private EdgeOptions eo;
	public static String highlight;
	
	
	/**
	 * @author : Mainoddin
	 * @throws IOException 
	 * @Description: Method to Launch browser
	 * @returnType : driver
	 * @date : 2024
	 */
	public WebDriver launchBrowser() throws IOException{
		highlight= this.getPropertyFileData("highlight").trim();
		
		if(this.getPropertyFileData("browser").trim().equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver=new ChromeDriver();
			driver=new ChromeDriver(getChromeOptions());
			System.out.println("Launched Chrome Browser");
		}
		else if(this.getPropertyFileData("browser").trim().equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			//driver=new EdgeDriver();
			driver=new EdgeDriver(getEdgeOptions());
			System.out.println("Launched Edge Browser");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(this.getPropertyFileData("url"));
		System.out.println("Navigated to URL");
		return driver;
	}
	
	
	
    /**
	 * @author : Mainoddin
     * @throws IOException 
	 * @Description: Method to read data from Properties file
	 * @returnType : String
	 * @date : 2024
	 */
	public String getPropertyFileData(String Key) throws IOException{
		
		try {Properties props = new Properties();
			FileInputStream reader = new FileInputStream(
					System.getProperty("user.dir")+"\\src\\main\\resources\\PropertyFile.properties");
			props.load(reader);
			String Value = props.getProperty(Key);
			return Value;
		}catch(FileNotFoundException e){
			e.printStackTrace(); 
		}
		return Key;
	}
	
	
	public ChromeOptions getChromeOptions() throws IOException{
		co = new ChromeOptions();
		if((Boolean.parseBoolean(this.getPropertyFileData("--headless").trim())))
			{
			System.out.println("====> Running in Headless chrome");
			co.addArguments("--headless");
			}
		if((Boolean.parseBoolean(this.getPropertyFileData("--incognito").trim())))co.addArguments("--incognito");
		return co;
	}
	
	public EdgeOptions getEdgeOptions() throws IOException{
		eo = new EdgeOptions();
		if((Boolean.parseBoolean(this.getPropertyFileData("--headless").trim())))eo.addArguments("--headless");
		if((Boolean.parseBoolean(this.getPropertyFileData("--incognito").trim())))eo.addArguments("--incognito");
		return eo;
	}

	

	/*
	 * Screenshot method
	 */
	public static String getScreenshot() {
		File scrFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
		File destination = new File(path);
		try {
			FileHandler.copy(scrFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}return path;
	}
}
