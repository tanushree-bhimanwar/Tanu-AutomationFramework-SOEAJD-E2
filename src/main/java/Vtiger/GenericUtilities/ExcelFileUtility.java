package Vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic utilities related to excel file
 * @author Tanushree
 *
 */
public class ExcelFileUtility {
	
	/**
	 *  this method will read data from excel sheet based on sheet name, row number 
	 *  and column number given by caller
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return value
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName, int rowNo, int cellNo) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		wb.close();
		return value;
	}
	
	public void writeDataIntoSheet(String sheetName1, int rowNo, int cellno, String data) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet(sheetName1);
		Row rw = sh.createRow(rowNo);
		Cell cl = rw.createCell(cellno);
		cl.setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(IConstants.excelFilePath);
		wb.write(fos);
		wb.close();
		
	}
	
	/**
	 * This method will read all data inside a sheet to used in data provider
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readMultipleData(String sheetName) throws Throwable
	{
	FileInputStream fis = new FileInputStream(IConstants.excelFilePath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	int lastRow=sh.getLastRowNum();    // capture number of rows
	int lastCel=sh.getRow(0).getLastCellNum(); // capture number if cells
	
	Object[][] data=new Object[lastRow][lastCel];
	
	for(int i=0;i<lastRow;i++)
	{
		for(int j=0;j<lastCel;j++)
		{
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	
	return data;
	}

}
