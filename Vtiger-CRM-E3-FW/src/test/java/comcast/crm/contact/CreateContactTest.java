package comcast.crm.contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactTest {
	public static void main(String[] args) throws IOException {

//		Step 1 : Get the java representation object of the physical file
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\git\\E3_Vtiger_CRM\\Vtiger-CRM-E3-FW\\src\\test\\resources\\commonData.properties");

//		step 2 : By using the object of Properties class, call load() and load all keys
		Properties pObj = new Properties();
		pObj.load(fis);

//		Step 3 : By using getProperty(), fetch the value
		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");

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
		
		
		driver.manage().window().maximize();
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

		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();

		driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();
	}
}
