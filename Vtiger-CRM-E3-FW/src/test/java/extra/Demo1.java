package extra;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo1 {

	@Test
	public void add() {
		System.out.println("Hey there!!!");
		Reporter.log("Hello world!!!",true);
	}
	

}
