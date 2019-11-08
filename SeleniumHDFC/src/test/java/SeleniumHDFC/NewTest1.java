package SeleniumHDFC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest1 {
	
	@Test
	public void testHDFCCCLink(){
		
	System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	//driver.get("https://www.icicibank.com/");
	driver.get("https://www.hdfcbank.com/");
	driver.manage().window().maximize();
	
	//Actions are used for 
	Actions act1= new Actions(driver);
	act1.moveToElement(driver.findElement(By.xpath("//a[@title='Pay']"))).pause(2000).perform();
	
	//WebElement LinkByText = driver.findElement(By.linkText("Credit Cards"));
	//LinkByText.click();
	
	driver.findElement(By.xpath("//a[@href='/personal/pay/cards/credit-cards']")).click();
	String title =driver.getTitle();
	Assert.assertTrue(title.startsWith("Credit Cards"));
	
}

}
