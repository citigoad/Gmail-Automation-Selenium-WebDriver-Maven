package Selenium.Gmail;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperImpl implements Helper{
	public WebDriver driver;
	
	public  WebDriver DriverSetting(String URL, String browser){ //removed static here
		
		if(browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver.exe");
			driver = new ChromeDriver();	
		}
		
		driver.get(URL);
		return driver;
}
	
	public void waitForElement(WebDriver driver, int timeOutInSeconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void takeScreenshot(String filename){
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("Screenshots\\"+filename +".jpg"));
		} catch (IOException e) {
			System.out.println("Buddy!! unable to create a file in the directory");
			e.printStackTrace();	
		}
		 System.out.println("Screenshot captured");
	}

}
