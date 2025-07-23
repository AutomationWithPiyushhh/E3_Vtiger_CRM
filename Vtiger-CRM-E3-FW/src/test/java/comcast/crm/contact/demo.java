package comcast.crm.contact;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo {
	public static void main(String[] args) throws MalformedURLException {
		WebDriver driver = new ChromeDriver();
		
		URL url = new URL("https://www.instagram.com/");
		driver.navigate().to(url);
	}
}
