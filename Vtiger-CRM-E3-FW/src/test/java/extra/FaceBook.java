package extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FaceBook {

	@Test(invocationCount = 3)
	public void logibFbTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");
		
		WebElement username = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));
		WebElement loginBtn = driver.findElement(By.name("login"));

		username.sendKeys("admin");
		password.sendKeys("admin");
		loginBtn.click();

		Thread.sleep(3000);
		
		driver.quit();
	}
}
