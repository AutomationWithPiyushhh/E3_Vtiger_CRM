package comcast.crm.org;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import object_repository.HomePage;
import object_repository.OrgPage;
import object_repository.VerOrgPage;


//@Listeners(listeners_utility.List_imp.class)
public class CreateOrgTest extends BaseClass {

	@Test
	public void createOrgTest() throws EncryptedDocumentException, IOException, InterruptedException {
		FileUtility fUtil = new FileUtility();
		String orgName = fUtil.getDataFromExcelFile("org", 1, 0) + JavaUtility.genRanNum();

//		Click on org link
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

//		Click on plus icon
		OrgPage op = new OrgPage(driver);
		op.getPlusIcon().click();

//		Enter the valid data into the form
		op.getOrg().sendKeys(orgName);

//		Save 
		op.getSaveBtn().click();

//		Verification
		VerOrgPage vop = new VerOrgPage(driver);
		String actOrgName = vop.getActOrgName().getText();

		Assert.assertEquals(actOrgName, orgName);
		
//		if (actOrgName.equals(orgName)) {
//			System.out.println("Organization created successfully....");
//		} else {
//			System.out.println("Org didn't create...");
//		}
	}
}
