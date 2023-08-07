package VTiger_Organization_Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Vtiger.GenericUtilities.BaseClass;

public class CreateOrganization_DDT extends BaseClass{

	@Test
	public void creatOrg() throws Throwable{
		
	//Read data from Excel sheet-- Test data
    FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\VtigerData.xlsx");
   Workbook book = WorkbookFactory.create(fise);
   Sheet sh = book.getSheet("Organization");
   String ORGNAME= sh.getRow(1).getCell(2).getStringCellValue()+jUtil.getRandomNumber();
  

	}

}
