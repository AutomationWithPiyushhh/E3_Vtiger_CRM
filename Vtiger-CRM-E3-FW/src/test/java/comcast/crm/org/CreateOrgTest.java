package comcast.crm.org;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgTest {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("http://localhost:8888/");

//		Logging into Vtiger crm application
		WebElement un = driver.findElement(By.name("user_name"));
		un.sendKeys("admin");

		WebElement pwd = driver.findElement(By.name("user_password"));
		pwd.sendKeys("password");

		driver.findElement(By.id("submitButton")).click();

//		Click on org link
		driver.findElement(By.linkText("Organizations")).click();

//		Click on plus icon
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();

//		Enter the valid data into the form
		WebElement org = driver.findElement(By.name("accountname"));
		String orgName = "qspiders_0987dhgfu";
		org.sendKeys(orgName);

//		Save 
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

//		Verification
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();

		if (actOrgName.equals(orgName)) {
			System.out.println("Organization created successfully....");
		}

//		Logging out 
		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();

		driver.findElement(By.linkText("Sign Out")).click();

	}
}
