package Selenium.Gmail;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingleEmailTest extends HelperImpl{
WebDriver driver;
MainPage main_page;

@Test
public void SingleEMailTest(){
main_page = new MainPage(driver);
main_page.newEmail();
}

}