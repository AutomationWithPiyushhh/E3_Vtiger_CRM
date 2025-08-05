package working_with_listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base_utility.BaseClass;

@Listeners(listeners_utility.List_imp.class)
public class DemoTest extends BaseClass {
	@Test
	public void vtiger1() {
		Assert.assertTrue(true);
	}

	@Test
	public void vtiger2() {
		Assert.assertTrue(false);
	}

	@Test
	public void vtiger3() {
		Assert.assertTrue(true);
	}
}
