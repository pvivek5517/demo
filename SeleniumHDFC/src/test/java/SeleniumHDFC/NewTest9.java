package SeleniumHDFC;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class NewTest9 {
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeClass
	public void beforeClass()
	{
		String reportPath=System.getProperty("user.dir")+"/extent-reports/report1.html";
		htmlReporter=new ExtentHtmlReporter(reportPath);
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);

	}
	@Test
	public void testForPass()
	{
		test=reports.createTest("testForPass");
		test.log(Status.PASS, "this test is passed");
		Assert.assertTrue(true);
	}
	@Test
	public void testForFail()
	{

		test=reports.createTest("testForFail");
		test.log(Status.FAIL, "this test is failed");
		Assert.assertTrue(false);
		
	}
	@Test
	public void testForSkip()
	{

		test=reports.createTest("testForSkip");
		test.log(Status.SKIP, "this test is skipped");
		throw new SkipException("skip exception");
	}
	@AfterClass
	public void afterClass()
	{
		reports.flush();
	}
	

}
