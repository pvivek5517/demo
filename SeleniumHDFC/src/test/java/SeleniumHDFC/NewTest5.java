package SeleniumHDFC;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest5 {

	@Test(groups = {"smoke"})
	public void testDropDown(){
		
	System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	//driver.get("https://www.icicibank.com/");
	driver.get("https://www.hdfcbank.com/");
	driver.manage().window().maximize();
	
	WebElement accounts=driver.findElement(By.xpath("//li[contains(text(),'Accounts')]"));
	WebElement deposits=driver.findElement(By.xpath("//li[contains(text(),'Deposits')]"));
	
	//Explicite 
	JavascriptExecutor js= (JavascriptExecutor) driver;
	//js.executeScript("alert('Welcome')");
	js.executeScript("arguments[0].click()", new Object[] {accounts});
	
	//multiple selection --Array
	js.executeScript("arguments[0].click();arguments[1].click();", new Object[] {accounts, deposits});
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	js.executeScript("document.getElementById('chatTogglerImg').click()");
	
	//Try to close the pop-up
	
	
	}
}
