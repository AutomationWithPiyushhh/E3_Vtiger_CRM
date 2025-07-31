package config_ann;

import org.testng.annotations.Test;

import base_utility.BaseClass;

public class CreateOrgTest extends BaseClass {

	@Test
	public void vtiger() {
		System.out.println("Login to vtiger");
	}

	
	@Test
	public void createOrgWithPhoneNumTest() {
		System.out.println("Perform Task number 3");
	}

	@Test
	public void createConWithPhoneNumTest() {
		System.out.println("Perform Task number 2");
	}	
	
	@Test
	public void createBondWithPhoneNumTest() {
		System.out.println("Perform Task number 1");
	}
}
