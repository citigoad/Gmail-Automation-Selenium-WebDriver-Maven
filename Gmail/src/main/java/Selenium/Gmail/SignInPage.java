package Selenium.Gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SignInPage extends HelperImpl{
	WebDriver driver;
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}

	@FindBy(how = How.XPATH, using = ".//*[@id='identifierId']")
	public static WebElement username;
	
	@FindBy(how = How.XPATH, using = ".//span[contains(text(),'Next')]")
	public static WebElement Next;
	
	@FindBy(how = How.XPATH, using = ".//input[@type='password']")
	public static WebElement password;
	
	public void enterDetails(String name , String pwd){
		waitForElement(driver, 5, username);
		username.sendKeys(name);
		Next.click();
		waitForElement(driver, 5, password);
		password.sendKeys(pwd);
		Next.click();
	}
	
}


