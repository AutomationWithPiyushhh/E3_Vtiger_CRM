package base_utility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import generic_utility.FileUtility;
import object_repository.HomePage;
import object_repository.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sdriver ;
	FileUtility fUtil = new FileUtility();

	@BeforeSuite
	public void repConfig() {
//		System.out.println("DB conn + Rep config.");
	}

	@BeforeTest
	public void preCon() {
		System.out.println("Pre conditions");
	}

	@BeforeClass
	public void openBro() throws IOException {

		String BROWSER = fUtil.getDataFromPropertiesFile("bro");
		String URL = fUtil.getDataFromPropertiesFile("url");

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		sdriver = driver;

//		driver.manage().window().maximize();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(URL);
	}

	@BeforeMethod
	public void login() throws IOException {

		String USERNAME = fUtil.getDataFromPropertiesFile("un");
		String PASSWORD = fUtil.getDataFromPropertiesFile("pwd");

//		Logging into Vtiger crm application
		LoginPage lp = new LoginPage(driver);

		WebElement username = lp.getUsername();
		username.sendKeys(USERNAME);

		WebElement password = lp.getPassword();
		password.sendKeys(PASSWORD);

		lp.getLogibBtn().click();
	}

	@AfterMethod
	public void logout() {

		HomePage hp = new HomePage(driver);
		WebElement profile = hp.getProfile();

		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();

		hp.getSignOut().click();

	}

	@AfterClass
	public void closeBro() {
		driver.quit();
	}

	@AfterTest
	public void postCon() {
		System.out.println("Post conditions");
	}

	@AfterSuite
	public void repBackup() {
//		System.out.println("DB conn close + Rep Backup");
	}

}
