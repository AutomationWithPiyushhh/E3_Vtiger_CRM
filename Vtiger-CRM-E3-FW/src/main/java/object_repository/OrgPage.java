package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPage {

//	Initialization
	public OrgPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "img[alt='Create Organization...']")
	private WebElement plusIcon;
	
	@FindBy(name = "accountname")
	private WebElement org;
	
	@FindBy(css = "input[title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getPlusIcon() {
		return plusIcon;
	}

	public WebElement getOrg() {
		return org;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
}	
