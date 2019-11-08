package SeleniumHDFC;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest3 {
	
	@Test
	public void testClearTripKeyBoard () throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		
		WebElement fromcity=driver.findElement(By.id("FromTag"));
		Actions act1= new Actions(driver);
		//act1.sendKeys(fromcity, "hyd").pause(3000).sendKeys(Keys.ENTER).perform();
		act1.keyDown(fromcity, Keys.SHIFT).sendKeys("hyd").pause(3000).sendKeys(Keys.ENTER).perform();
		
		WebElement tocity=driver.findElement(By.id("ToTag"));
		tocity.sendKeys("ban");
		//Explicitwait--to handle in dynamic way
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.id("ui-id-2"), By.className("list")));
		WebElement ul=driver.findElement(By.id("ui-id-2"));
		//import from util
		List<WebElement>  li=ul.findElements(By.tagName("li"));
		Assert.assertEquals(li.size(), 10);

		for(WebElement e:li)
		{
			if(e.getText().contains("BGR"))
			{
				e.click();
				break;
			}
		}
		
	}

}
