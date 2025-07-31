package base_utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import object_repository.HomePage;
import object_repository.LoginPage;

public class BaseClass {

	
	
	WebDriver driver;
	
	@BeforeSuite
	public void repConfig() {
		System.out.println("DB conn + Rep config.");
	}

	@BeforeTest
	public void preCon() {
		System.out.println("Pre conditions");
	}

	@BeforeClass
	public void openBro() {
		System.out.println("Browser open");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	}

	@BeforeMethod
	public void login() {
		System.out.println("login");
		driver.get("http://49.249.28.218:8888/");
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys("admin");
		lp.getPassword().sendKeys("admin");
		lp.getLogibBtn().click();
	}


	@AfterMethod
	public void logout() {
		System.out.println("logout");

		HomePage hp = new HomePage(driver);
		WebElement profile = hp.getProfile();

		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		
		hp.getSignOut().click();
		
	}

	@AfterClass
	public void closeBro() {
		System.out.println("Browser close");
		driver.quit();
	}

	@AfterTest
	public void postCon() {
		System.out.println("Post conditions");
	}

	@AfterSuite
	public void repBackup() {
		System.out.println("DB conn close + Rep Backup");
	}
	
	@Test
	public void vtiger() {
		System.out.println("run");
	}
}
