package comcast.crm.org;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.OrgPage;
import object_repository.VerOrgPage;

public class CreateOrgTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {

		FileUtility fUtil = new FileUtility();

		String BROWSER = fUtil.getDataFromPropertiesFile("bro");
		String URL = fUtil.getDataFromPropertiesFile("url");
		String USERNAME = fUtil.getDataFromPropertiesFile("un");
		String PASSWORD = fUtil.getDataFromPropertiesFile("pwd");

		String orgName = fUtil.getDataFromExcelFile("org", 1, 0) + JavaUtility.genRanNum();

		WebDriver driver = null;

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

		driver.get(URL);

//		Logging into Vtiger crm application
//		WebElement un = driver.findElement(By.name("user_name"));
		LoginPage lp = new LoginPage(driver);
		WebElement un = lp.getUsername();
		driver.navigate().refresh();
		un.sendKeys(USERNAME);

//		WebElement pwd = driver.findElement(By.name("user_password"));
		WebElement pwd = lp.getPassword();
		pwd.sendKeys(PASSWORD);

//		driver.findElement(By.id("submitButton")).click();
		lp.getLogibBtn().click();

//		Click on org link
//		driver.findElement(By.linkText("Organizations")).click();
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

//		Click on plus icon
//		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		OrgPage op = new OrgPage(driver);
		op.getPlusIcon().click();

//		Enter the valid data into the form
//		WebElement org = driver.findElement(By.name("accountname"));
//		String orgName = "qspiders_" + (int)(Math.random()*9999);
		op.getOrg().sendKeys(orgName);

//		Save 
//		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		op.getSaveBtn().click();

//		Verification
//		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();

		VerOrgPage vop = new VerOrgPage(driver);
		String actOrgName = vop.getActOrgName().getText();

		if (actOrgName.equals(orgName)) {
			System.out.println("Organization created successfully....");
		}

		Thread.sleep(3000);
//		Logging out 
//		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

		WebElement profile = hp.getProfile();

		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();

//		wdUtil.hover(profile);

//		driver.findElement(By.linkText("Sign Out")).click();
		hp.getSignOut().click();

		driver.quit();
	}
}
