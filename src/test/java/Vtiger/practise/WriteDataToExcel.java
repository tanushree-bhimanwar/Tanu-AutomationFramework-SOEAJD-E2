package Vtiger.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcel {

	public static void main(String[] args) throws Throwable {
		// step 1-- load the file in java readable format
				FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\VtigerData.xlsx");
				
				// step 2-- create the workbook for the file loaded
				Workbook book = WorkbookFactory.create(fis);
				
				// step 3-- create sheet
				Sheet sh = book.createSheet("Trial");
				
				//step 4--create row
				Row rw = sh.createRow(4);
				
				// step 5-- create cell
				Cell cl = rw.createCell(3);
				
				//step 6--set value into cell
				cl.setCellValue("Spider man");
				
				// Step 7-- open the file in java write format
				FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\VtigerData.xlsx");
				
				// step 8-- call the write method
				book.write(fos);
				System.out.println("data updated");
				
				//step 9--close workbook
				book.close();
				System.out.println("workbook closed");
				
				

	}

}
