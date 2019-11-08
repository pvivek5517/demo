package SeleniumHDFC.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SeleniumHDFC.pages.LoginPage;
import SeleniumHDFC.pages.RegisterPage;
import SeleniumHDFC.pages.WelcomePage;

public class DemoWebShopTest {
	WebDriver driver;
	LoginPage loginpage;
	WelcomePage welcomepage;
	RegisterPage registerpage;
	
	@BeforeClass
	public void beforeClass()
	{
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demowebshop.tricentis.com/");
		loginpage=PageFactory.initElements(driver, LoginPage.class);
		welcomepage=PageFactory.initElements(driver, WelcomePage.class);
		registerpage=PageFactory.initElements(driver,RegisterPage.class);
		
	}
	@AfterClass
	public void afterClass()
	{
		driver.close();
	}
	@Test(dependsOnMethods = "testRegister")
	public void testLogin()
	{
		String url=welcomepage.clickLoginLink();
		Assert.assertTrue(url.contains("login"));
		loginpage.sendLoginInfo();
		loginpage.logout();
	}
	@Test
	public void testRegister()
	{
		String title=welcomepage.clickRegisterLink();
		Assert.assertTrue(title.contains("Register"));
		String message=registerpage.sendRgisterInfo();
		Assert.assertTrue(message.contains("completed"));
		loginpage.logout();
	}
	
}