package Selenium.Gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends HelperImpl{
	 WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (how = How.XPATH, using= "//*[contains(text(),'COMPOSE')]")
	public WebElement compose;
	
	@FindBy (how = How.XPATH, using= ".//textarea[@name='to' and @role='combobox']")
	public WebElement to;
	
	@FindBy (how = How.XPATH, using= ".//input[@name='subjectbox']")
	public WebElement subject;
	
	@FindBy (how = How.XPATH, using= ".//div[@aria-label='Message Body']")
	public WebElement message;
	
	@FindBy (how = How.XPATH, using= ".//div[contains(text(), 'Send') and @role='button']")
	public WebElement send;
	
	public void newEmail(){
		waitForElement(driver, 10, compose);
		compose.click();
	}
	public void singleEmail(String t, String s, String m){
		waitForElement(driver, 60, to);
		to.sendKeys(t);
		subject.sendKeys(s);
		message.sendKeys(m);
		send.click();
	}

}
