package working_with_assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WorkingWithSoftAssert {
	@Test
	public void case1() {

		SoftAssert sa = new SoftAssert();

		String a = "Hardik";
		String b = "Hardik";
		String c = "Nikhil";

		sa.assertEquals(a, b);
		sa.assertNotEquals(a, b);
		System.out.println("assert equals methods done");

		sa.assertTrue(a.equals(b)); //
		sa.assertTrue(a.equals(b)); //
		sa.assertFalse(a.equals(c)); //
		sa.assertFalse(a.equals(c)); //
		System.out.println("assert boolean methods done");

		Object obj1 = null;
		Object obj2 = new Object();

		sa.assertNull(obj1);
		sa.assertNotNull(obj2);
		System.out.println("assert null methods done");

		
		
//		It should be always last line of the code
//		sa.assertAll();
	}
}
