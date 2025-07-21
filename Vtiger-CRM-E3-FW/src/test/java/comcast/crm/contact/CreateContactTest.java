package comcast.crm.contact;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_utility.FileUtility;
import generic_utility.WebdriverUtility;

public class CreateContactTest {
	public static void main(String[] args) throws IOException {

		FileUtility fUtil = new FileUtility();
		String BROWSER = fUtil.getDataFromPropertiesFile("bro");
		String URL = fUtil.getDataFromPropertiesFile("url");
		String USERNAME = fUtil.getDataFromPropertiesFile("un");
		String PASSWORD = fUtil.getDataFromPropertiesFile("pwd");
		
		WebDriver driver = null;
		
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}else {
			driver = new ChromeDriver();
		}
		
		
//		driver.manage().window().maximize();
		
		WebdriverUtility wdUtil = new WebdriverUtility(driver);
		wdUtil.maxWin();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(URL);

//		Logging into Vtiger crm application
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys(USERNAME);

		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys(PASSWORD);

		driver.findElement(By.id("submitButton")).click();

//		Click on contact link
		driver.findElement(By.linkText("Contacts")).click();

//		Click on plus icon
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

//		Enter the valid data into the form
		WebElement ln = driver.findElement(By.name("lastname"));
		String lastName = "kumar";
		ln.sendKeys(lastName); 

//		Save 
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

//		Verification
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();

		if (actLastName.equals(lastName)) {
			System.out.println("Contact created successfully....");
		}

//		Logging out 
		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

//		Actions act = new Actions(driver);
//		act.moveToElement(profile).build().perform();

		wdUtil.hover(profile);
		
		driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();
	}
}
