package Vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provide implementation to ITestListener interface of TestNG
 * Example of Abstraction
 * @author 91942
 *
 */
public class ListenerImplementationClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		 System.out.println("--------Execution Started-------" +methodName);
		 test=report.createTest(methodName);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		//System.out.println("---------Pass---------"+methodName);
		test.log(Status.PASS, "---------Pass---------"+methodName) ;   //----This is optional for above print statement in extent report
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName=result.getMethod().getMethodName();
		//System.out.println("--------FAIL--------" +methodName);
		test.log(Status.FAIL, "--------FAIL--------" +methodName);
		
		// System.out.println(result.getThrowable());
		test.log(Status.INFO, result.getThrowable());
		
		WebdriverUtility wu=new WebdriverUtility();
		JavaUtility ju=new JavaUtility();
		
		String screenShotName=methodName+ju.getSystemDateInFormat();
		
		/* Take screen shot for failed test scripts- to attach with bug rising */
		try {
			
			String path=wu.takeScreenShot(BaseClass.sdriver, screenShotName);
			test.addScreenCaptureFromPath(path);
		}   
		 catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		//System.out.println("-------SKIP-------"+methodName);
		
		test.log(Status.SKIP, "-------SKIP-------"+methodName);
		
		//System.out.println(result.getThrowable());
		
		test.log(Status.INFO, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		// start of <suite> - @BeforeSuite
		
		System.out.println("---- suite execution started ----");
		// Configure the extent report
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReport\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
	    
		htmlReport.config().setDocumentTitle("Vtiger Execution Report");
		htmlReport.config().setReportName("Build 3 Vtiger Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		
		// Report Generation
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Browser", "chrome");
		report.setSystemInfo("Base Platform", "Testing-Env");
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Base OS", "Windows");
		report.setSystemInfo("Reporter", "Tanushree");
		
	}

	public void onFinish(ITestContext context) {
		// end of </suite> - @AfterSuite
		
				System.out.println("---- suite execution ended ----");
				
				//Report Generation
				report.flush();
		
	}

	

}
