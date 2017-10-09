package Selenium.Gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LaunchPage extends HelperImpl
{
WebDriver driver;

public LaunchPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

@FindBy (how = How.XPATH, using= "//*[contains(text(),'Sign In')]")
public WebElement signIn;

public void clickSignIn(){
	signIn.click();
}

}
