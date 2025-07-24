package extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo1 {

	@Test(invocationCount = 10,threadPoolSize = 5)
	public void create() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Reporter.log("Create Noida",true);
		driver.quit();
	}
	
	@Test(enabled = false)
	public void delete() {
		Reporter.log("Delete Noida",true);
	}
}
