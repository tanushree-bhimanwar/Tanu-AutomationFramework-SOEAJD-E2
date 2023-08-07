package Vtiger.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws Throwable {
		// step 1-- load the file in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\VtigerData.xlsx");
		
		// step 2-- create the workbook for the file loaded
		Workbook book = WorkbookFactory.create(fis);
		
		// step 3-- navigate to required sheet
		Sheet sh = book.getSheet("Organization");
		
		//step 4--navigate to required row
		Row rw = sh.getRow(1);
		
		// step 5-- navigate to required cell
		Cell cl = rw.getCell(2);
		
		// step 6-- capture the data from cell
		String data = cl.getStringCellValue();
		System.out.println(data);

	}

}
