package extra;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteDataBackToProperties {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\git\\E3_Vtiger_CRM\\Vtiger-CRM-E3-FW\\src\\test\\resources\\cd.properties");

		Properties pObj = new Properties();
		pObj.load(fis);

//		String vill = pObj.getProperty("Village");
//		System.out.println(vill);

		pObj.setProperty("State", "The UP");

		FileOutputStream fos = new FileOutputStream(
				"C:\\Users\\User\\git\\E3_Vtiger_CRM\\Vtiger-CRM-E3-FW\\src\\test\\resources\\cd.properties");
		pObj.save(fos, "The state has beeen added!!!");
	}
}
