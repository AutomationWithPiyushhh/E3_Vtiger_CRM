package extra;

import org.testng.annotations.Test;

public class TwoDimension {
	@Test
	public Object[][] stringArray() {
		Object[][] students = new Object[5][2];
		
		students[0][0] = "Mayank";
		students[0][1] = "Verma";

		students[1][0] = "Nikhil";
		students[1][1] = "Rawal";

		students[2][0] = "Owias";
		students[2][1] = "Thakur";

		students[3][0] = "Pankaj";
		students[3][1] = "Upadhyay";

		students[4][0] = "Saloni";
		students[4][1] = "V";
		
		return students;
	}
}
