package extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropFile {
	public static void main(String[] args) throws IOException {
//		Step 1 : Get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\git\\E3_Vtiger_CRM\\Vtiger-CRM-E3-FW\\src\\test\\resources\\commonData.properties");
		
//		step 2 : By using the object of Properties class, call load() and load all keys
		Properties pObj = new Properties();
		pObj.load(fis);
		
//		Step 3 : By using getProperty(), fetch the value
		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
	}
}
