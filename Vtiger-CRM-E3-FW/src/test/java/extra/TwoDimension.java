package extra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TwoDimension {

	@Test(dataProvider = "getData")
	public void loginToFB(String user, String password) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.facebook.com/");

//		String user = "Shivang";
		driver.findElement(By.id("email")).sendKeys(user);
		driver.findElement(By.id("pass")).sendKeys(password);

		driver.findElement(By.name("login")).click();

		System.out.println(user + " is Logged in successfully");

		driver.quit();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] students = new Object[3][2];

		students[0][0] = "Mayank";
		students[0][1] = "Verma";

		students[1][0] = "Nikhil";
		students[1][1] = "Rawal";

		students[2][0] = "Owias";
		students[2][1] = "Thakur";

		return students;
	}
}
