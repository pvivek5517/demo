package SeleniumHDFC;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class NewTest10 {
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	@BeforeClass
	public void beforeClass()
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-ms");
		String reportPath=System.getProperty("user.dir")+"/extent-reports/"+sdf.format(new Date())+".html";
		htmlReporter=new ExtentHtmlReporter(reportPath);
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);

		//htmlReporter.config().setTheme(Theme.DARK);


	}
	@BeforeMethod
	public void beforeMethod(ITestResult result)
	{
		test=reports.createTest(result.getMethod().getMethodName());
	}
	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "this "+result.getMethod().getMethodName()+" is passed");
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "this "+result.getMethod().getMethodName()+" is failed");
			test.log(Status.FAIL, result.getThrowable().getMessage());
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "this "+result.getMethod().getMethodName()+" is skipped");
		}
	}
	@Test
	public void testForPass()
	{
		Assert.assertTrue(true);
	}
	@Test
	public void testForFail()
	{
		Assert.assertTrue(false);

	}
	@Test
	public void testForSkip()
	{
		throw new SkipException("skip exception");
	}
	@AfterClass
	public void afterClass()
	{
		reports.flush();
	}


}
