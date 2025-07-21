package extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBook {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.facebook.com/");
		
		WebElement loginBtn = driver.findElement(By.name("login"));
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		loginBtn = driver.findElement(By.name("login"));
		loginBtn.click();
		
		Thread.sleep(2000);
		driver.quit();
	}
}
