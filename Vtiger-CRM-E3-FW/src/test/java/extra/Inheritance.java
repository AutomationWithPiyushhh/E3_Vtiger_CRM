package extra;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

class A {

	@BeforeSuite
	public void bs() {
		System.out.println("inherited method");
	}
}

public class Inheritance extends A{
	@Test
	public void execute() {
		System.out.println("Main execution");
	}

}