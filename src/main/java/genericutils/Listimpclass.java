package genericutils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listimpclass implements ITestListener
{

	
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result)
	{//Execution starts from here
		
		String MethodName=result.getMethod().getMethodName();
		
		 test = report.createTest(MethodName);
		 Reporter.log(MethodName+"--------Execution starts");
		
		 
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		String  MethodName=result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"-------Testscript Passed");
		Reporter.log(MethodName+ "-----executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		try 
		{
			String  MethodName=result.getMethod().getMethodName();
			String src=WebDriverUtils.getScreenShot(Baseclass.sdriver,MethodName);
			test.log(Status.FAIL, MethodName+"-------Testscript failed");
			test.log(Status.FAIL, result.getThrowable());
			Reporter.log(MethodName+ "-----failed");
			test.addScreenCaptureFromPath(src);
		} 
		
		catch (Throwable e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String  MethodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"-------Testscript Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+ "-----Skipped");
	}

	@Override
	public void onStart(ITestContext context) 
	{
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExternalReport/report.html");
		htmlreport.config().setDocumentTitle("Sdet-54");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("Online Banking System");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		
		report.setSystemInfo("base platform", "windows 11");
		report.setSystemInfo("Base Browser", "chrome");
		report.setSystemInfo("Base URL", "http:localhost:8888");
		report.setSystemInfo("Reporter Name", "Sahana");
			
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		report.flush();
		
	}
	
	
      

}
