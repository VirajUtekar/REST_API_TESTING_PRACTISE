package Resources;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Base implements ITestListener {
	
	public ExtentReports extent = ExtentReporterNG.getReportObject();
	
	public ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}
	
	public void onTestPass(ITestResult result) {
		test.log(Status.PASS,"Test Case is Passed");
	}
	
	public void onTestFail(ITestResult result) {
		test.fail(result.getThrowable());
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
