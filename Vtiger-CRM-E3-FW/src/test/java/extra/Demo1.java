package extra;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo1 {
	WebDriver driver;
	
//	@BeforeSuite
//	public void configRep() {
//		System.out.println("DB connectivity + Report Configuration");
//	}
//	
//	@BeforeTest
//	public void preCon() {
//		System.out.println("Pre conditions + Prior Data");
//	}
	
	@Parameters("browser")
	@BeforeClass
	public void openBro(String bro) {
		
		String BROWSER = bro;
		
		System.out.println("Open the browser");
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
//	@BeforeMethod
//	public void login() {
//		System.out.println("login");
//		
//		driver.get("http://49.249.28.218:8888/");
//		
//		LoginPage lp = new LoginPage(driver);
//		lp.getUsername().sendKeys("admin");
//		lp.getPassword().sendKeys("admin");
//		lp.getLogibBtn().click();
//	}
	
	
	@Test
	public void case1Test() throws InterruptedException {
		System.out.println("Organization created and verified successfully!!!");
	}
	
//	@AfterMethod
//	public void logOut() {
//		System.out.println("logout");
//		HomePage hp = new HomePage(driver);
//
////		hover on profile
//		WebDriverUtility wdUtil = new WebDriverUtility(driver);
//		wdUtil.hover(hp.getProfile());
//
////		click on signout link
//		hp.getSignOut().click();
//	}
//	
//	@AfterClass
//	public void closeBro() throws InterruptedException {
//		System.out.println("close the browser");
//		Thread.sleep(3000);
//		driver.quit();
//	}
//	
//	@AfterTest
//	public void postCon() {
//		System.out.println("Post condition");
//	}
//	
//	@AfterSuite
//	public void repBackup() {
//		System.out.println("DB close + Rerort Backup");
//	}

}
