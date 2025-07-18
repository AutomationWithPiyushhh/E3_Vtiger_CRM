package generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility {

	WebDriver driver = null;
	Actions act;

	public WebDriverUtility(WebDriver driver) {
		this.act = new Actions(driver);
		this.driver = driver;
	}

	public void winMax() {
		driver.manage().window().maximize();
	}

	public void hover(WebElement element) {
		act.moveToElement(element).build().perform();
	}

	public void doubleClick(WebElement element) {
		act.doubleClick(element).build().perform();
	}
	
	public void rightClick(WebElement element) {
		act.contextClick(element).build().perform();
	}


}
