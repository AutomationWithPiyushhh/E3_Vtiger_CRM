package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	
	public String getDataFromPropertiesFile(String key) throws IOException {
//		Get the data from properties file
		FileInputStream fis1 = new FileInputStream(
				"C:\\Users\\User\\git\\E3_Vtiger_CRM\\Vtiger-CRM-E3-FW\\src\\test\\resources\\commonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis1);
		String value = pObj.getProperty(key);
		return value;
	}

	public String getDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
//		Get the data from excel file
		FileInputStream fis2 = new FileInputStream(
				"C:\\Users\\User\\git\\E3_Vtiger_CRM\\Vtiger-CRM-E3-FW\\src\\test\\resources\\testScriptData.xlsx");

		Workbook wb = WorkbookFactory.create(fis2);
		String value = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
	}
}
