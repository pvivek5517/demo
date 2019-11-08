package SeleniumHDFC.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WelcomePage {


	WebDriver driver;
	@FindBy(how = How.LINK_TEXT,using = "Register")
	WebElement registerLink;
	@FindBy(how = How.LINK_TEXT,using = "Log in" )
	WebElement loginLink;

	public String clickRegisterLink()
	{
		registerLink.click();
		return driver.getTitle();
	}

	public String clickLoginLink()
	{
		loginLink.click();
		return driver.getCurrentUrl();
	}

	public WelcomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

}
