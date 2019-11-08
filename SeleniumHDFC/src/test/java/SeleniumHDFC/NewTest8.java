package SeleniumHDFC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest8 {
	
	static WebDriver driver;
	public static void testExcelData() throws IOException
	{
		File file=new File("src/test/resources/TestData/Book1.xlsx");
		try {
			InputStream is=new FileInputStream(file);
			XSSFWorkbook workbook=new XSSFWorkbook(is);
			XSSFSheet sheet1=workbook.getSheet("Sheet1");
			for(int i=1;i<=sheet1.getLastRowNum();i++)
			{
				String username=sheet1.getRow(i).getCell(0).getStringCellValue();
				System.out.print(sheet1.getRow(i).getCell(0).getStringCellValue());
				String password=sheet1.getRow(i).getCell(1).getStringCellValue();
				System.out.print(sheet1.getRow(i).getCell(1).getStringCellValue());
				testLoginInfo(username, password);
				/*
				 * for(int j=0;j<sheet1.getRow(i).getPhysicalNumberOfCells();j++) {
				 * System.out.print(sheet1.getRow(i).getCell(j).getStringCellValue()); }
				 * System.out.println("");
				 */
			}
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	@Parameters("browser")
	public void testLogin(String browserName) throws IOException {
		
		if(browserName.contentEquals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (browserName.contentEquals("ie"))
		{
		System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		}
		else if (browserName.contentEquals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			}
		driver.get("http://demowebshop.tricentis.com/login");
		driver.manage().window().maximize();
		testExcelData();
	}

	public static void testLoginInfo(String email,String password)
	{
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed());
		driver.findElement(By.linkText("Log out")).click();
		driver.findElement(By.linkText("Log in")).click();
	}

}
