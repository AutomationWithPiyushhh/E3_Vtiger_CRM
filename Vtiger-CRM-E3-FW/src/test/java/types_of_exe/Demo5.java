package types_of_exe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo5 {
	@Test(groups = "smoke")
	public void case1() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(groups = "smoke")
	public void case2() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(1000);
		driver.quit();
	}
}
