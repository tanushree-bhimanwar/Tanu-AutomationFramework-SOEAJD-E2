package Vtiger.practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractiseTest {
	
	@Test(retryAnalyzer = Vtiger.GenericUtilities.RetryAnalyserImplementation.class)
	public void sample()
	{
		Assert.fail();
		System.out.println("Hi");
	}

}
