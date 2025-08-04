package working_with_assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WorkingWithHardAssert {
	@Test
	public void case1() {

		String a = "Hardik";
		String b = "Hardik";
		String c = "Nikhil";

		Assert.assertEquals(a,b);
		Assert.assertNotEquals(a,c);
		System.out.println("assert equals methods done");
		
		Assert.assertTrue(a.equals(b)); // 
		Assert.assertTrue(a.equals(b)); // 
		Assert.assertFalse(a.equals(b)); // 
		Assert.assertFalse(a.equals(c)); //
		System.out.println("assert boolean methods done");

		Object obj1 = null;
		Object obj2 = new Object();

		Assert.assertNull(obj1);
		Assert.assertNotNull(obj2);
		System.out.println("assert null methods done");

	}
}
