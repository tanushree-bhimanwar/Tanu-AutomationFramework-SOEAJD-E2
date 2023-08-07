package Vtiger.practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractise {
	
	@Test(dataProvider = "Phones")
	public void addToCartTest(String name, int price, String model)
	{
		System.out.println("Phone name is" +name+ "Price is"+price+  "Model is" +price);
	}
	
	@DataProvider(name="Phones")
	public Object[][] getData()
	{
		Object[][] data=new Object[3][3];
		
		data[0][0]="Iphone";   //1st set of data
		data[0][1]=20000;
		data[0][2]="S13";
		
		data[1][0]="Samsung";  //2nd set of data
		data[1][1]=15000;
		data[1][2]="A80";
		
		data[2][0]="Vivo";
		data[2][1]=10000;
		data[2][2]="Y21";
		
		return data;
	}

}
