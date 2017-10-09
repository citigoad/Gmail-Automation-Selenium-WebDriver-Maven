package Selenium.Gmail;

import org.testng.annotations.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;


public class LoginTest extends HelperImpl{
WebDriver driver;
SignInPage signIn_page;
MainPage main_page;
@BeforeTest
	public void beforeTest(){
		try {
			driver = DriverSetting("https://www.gmail.com","chrome");
			//if you dont give https (fully qualified URL) then it throws an error chrome://browser/content/www.gmail.com
		} catch (Exception e) {
			takeScreenshot(this.getClass().toString());
		}
		} 
@Test(priority=1, description="sign into gmail")
public void beginTest(){
	signIn_page = new SignInPage(driver);
	signIn_page.enterDetails("pinkyatmanand@gmail.com", "Waltermeth1");
	//Assert.assertTrue(driver.findElement(By.xpath(".//input[@aria-label='Search']")).isDisplayed());
}
@Test(priority=2, description="click on compose", dependsOnMethods="beginTest")
public void SingleEMailTest(){
main_page = new MainPage(driver);
main_page.newEmail();
}
@Test(priority=3, description ="write the email and hit send", dependsOnMethods="beginTest")
public void sendEMailTest(){
	main_page.singleEmail("pinkyatmanand@gmail.com","Hi", "Hi from selenium");
}
}
