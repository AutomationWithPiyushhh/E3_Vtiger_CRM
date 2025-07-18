package extra;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataBackToExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\git\\E3_Vtiger_CRM\\Vtiger-CRM-E3-FW\\src\\test\\resources\\testScriptData.xlsx");

		Workbook wb = WorkbookFactory.create(fis);

		Sheet sh = wb.getSheet("org");

		Row row = sh.getRow(11);

		Cell cell = row.createCell(3);

		cell.setCellValue("www.thales.com");

//		save 
		FileOutputStream fos = new FileOutputStream(
				"C:\\Users\\User\\git\\E3_Vtiger_CRM\\Vtiger-CRM-E3-FW\\src\\test\\resources\\testScriptData.xlsx");
		wb.write(fos);
		
		wb.close();
	}
}
