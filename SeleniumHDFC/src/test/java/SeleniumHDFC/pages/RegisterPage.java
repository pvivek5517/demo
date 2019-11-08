package SeleniumHDFC.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {	
	
		
		WebDriver driver;
		@FindBy(how = How.ID,using = "gender-male")
		WebElement gender;
		@FindBy(how = How.NAME,using = "FirstName")
		WebElement firstname;
		@FindBy(how = How.NAME,using = "LastName")
		WebElement lastname;
		@FindBy(how = How.ID,using = "Email")
		WebElement email;
		@FindBy(how = How.ID,using = "Password")
		WebElement password;
		@FindBy(how = How.ID,using = "ConfirmPassword")
		WebElement confpassword;
		@FindBy(how = How.ID,using = "register-button")
		WebElement registerbutton;
		@FindBy(how = How.CLASS_NAME,using = "result")
		//@FindBy(how = How.XPATH,using = "//*[@class='result']")
		WebElement result;
		
		public String sendRgisterInfo()
		{
			gender.click();
			firstname.sendKeys("Aswani");
			lastname.sendKeys("kumar");
			email.sendKeys("askmail@test992.com");
			password.sendKeys("abc123");
			confpassword.sendKeys("abc123");
			registerbutton.click();
			return result.getText();
		}

		public RegisterPage(WebDriver driver) {
			super();
			this.driver = driver;
		}

}
