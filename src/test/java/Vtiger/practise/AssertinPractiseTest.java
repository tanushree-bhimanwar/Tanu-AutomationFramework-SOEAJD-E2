package Vtiger.practise;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertinPractiseTest {
	@Test
	public void sampleTest()
	{
		int a=1; //expected
		int b=2; //Actual
		SoftAssert sa=new SoftAssert();
		System.out.println("step 1");
		sa.assertEquals(false, true);  // fail
		System.out.println("step 2");
		
		Assert.assertEquals(b, a); //failed
		
		System.out.println("step 3");
		System.out.println("step 4");
		
		sa.assertTrue(false);
		System.out.println("Execution and validation completed");
		sa.assertAll();
		
		
		
		
	}
	

}
