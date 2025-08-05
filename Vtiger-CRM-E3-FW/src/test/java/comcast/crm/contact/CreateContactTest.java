package comcast.crm.contact;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base_utility.BaseClass;

//@Listeners(listeners_utility.List_imp.class)
public class CreateContactTest extends BaseClass {

	@Test
	public void createConTest() throws IOException {

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

		Assert.assertEquals(actLastName, lastName);
		
//		if (actLastName.equals(lastName)) {
//			System.out.println("Contact created successfully....");
//		}

	}
}