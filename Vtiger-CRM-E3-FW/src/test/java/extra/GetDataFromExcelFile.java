package extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\git\\E3_Vtiger_CRM\\Vtiger-CRM-E3-FW\\src\\test\\resources\\testScriptData.xlsx");

		Workbook wb = WorkbookFactory.create(fis);

//		Sheet sh = wb.getSheet("org");
//
//		
//		Row row = sh.getRow(11);
//
//		Cell cell = row.getCell(0);
//
//		String value = cell.getStringCellValue();

		String orgName = wb.getSheet("org").getRow(10).getCell(0).getStringCellValue();
//		long phone = (long)(wb.getSheet("org").getRow(5).getCell(1).getNumericCellValue());
		String phoneStr = wb.getSheet("org").getRow(5).getCell(1).getStringCellValue();

		System.out.println(orgName);
//		System.out.println(phone);
		System.out.println(phoneStr);

//		int lastRowNum = sh.getLastRowNum();
//		Multiple data fetch
//		for (int i = 0; i <= lastRowNum ; i++) {
//			you need to print
//		}
		
		wb.close();
	}
}
