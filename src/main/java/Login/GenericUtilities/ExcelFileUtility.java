package Login.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	public String getExcelFileData(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream file= new FileInputStream(IConstantutility.excelFilePath);
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		return cell.getStringCellValue();
	}
	
	public int getExcelFileIntData(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream file= new FileInputStream(IConstantutility.excelFilePath);
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		return (int) cell.getNumericCellValue();
	}
	
	public void writeIntoExcelFile(String sheetName, String cellValue, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream file= new FileInputStream(IConstantutility.excelFilePath);
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.createSheet(sheetName);
		Row row = sheet.createRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(cellValue);
		
		FileOutputStream fileOut= new FileOutputStream(IConstantutility.excelFilePath);
		book.write(fileOut);
		book.close();
	}
}
