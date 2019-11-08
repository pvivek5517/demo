package SeleniumHDFC;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class NewTest11 {
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	@BeforeClass
	public void beforeClass()
	{
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-ms");
		String reportPath=System.getProperty("user.dir")+"/extent-reports/"+sdf.format(new Date())+".html";
		htmlReporter=new ExtentHtmlReporter(reportPath);
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);

		htmlReporter.config().setTheme(Theme.DARK);


	}
	@BeforeMethod
	public void beforeMethod(ITestResult result)
	{
		test=reports.createTest(result.getMethod().getMethodName());
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "this "+result.getMethod().getMethodName()+" is passed");
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			TakesScreenshot ss=(TakesScreenshot) driver;
			File srcFile=ss.getScreenshotAs(OutputType.FILE);
			String imagePath=System.getProperty("user.dir")+"/extent-reports/images/"+result.getMethod().getMethodName()+".png";
			try {
				FileUtils.copyFile(srcFile,new File(imagePath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			test.log(Status.FAIL, "this "+result.getMethod().getMethodName()+" is failed");
			
			test.log(Status.FAIL, result.getThrowable().getMessage());
			test.addScreenCaptureFromPath(imagePath, "ScreenCapture");
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "this "+result.getMethod().getMethodName()+" is skipped");
		}
	}
	@Test(enabled = false)
	public void testForPass()
	{
		Assert.assertTrue(true);
	}
	@Test
	public void testDemoWebShopLogin()
	{
		driver.get("http://demowebshop.tricentis.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("Email")).sendKeys("askmail@email.com");
		driver.findElement(By.id("Pass")).sendKeys("abc123");
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed());
		driver.findElement(By.linkText("Log out")).click();

	}
	@Test(enabled = false)
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
