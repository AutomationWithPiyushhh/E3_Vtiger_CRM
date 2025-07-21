package generic_utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebdriverUtility {
	
	WebDriver driver;
	Actions act;
	
	public WebdriverUtility(WebDriver driver){
		this.act = new Actions(driver);
		this.driver = driver;
	}
	
	public void hover(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	
	public void rightClick(WebElement element) {
		act.contextClick(element).build().perform();
	}


	public void maxWin() {
		driver.manage().window().maximize();
	}
	
	public void clickByJS(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", element);
	}
	
	public void sendKeysByJS(WebElement element, String value) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value=arguments[1]", element, value);
	}
}
