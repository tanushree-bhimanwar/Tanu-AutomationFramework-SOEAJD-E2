package Vtiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation of IRetryAnalyser interface
 * @author 91942
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {

	                                                    //pass  fail
	public boolean retry(ITestResult result) {
	
		int count=1;
		int retryCount=3;
		// 1<=3, 2<-3, 3<=3, 4<=3
		while(count<=retryCount)
		{
			count++;     // 2, 3, 4
			return true;  // retry, retry, retry            
		}
		return false;    // don't retry                     
	}

}
