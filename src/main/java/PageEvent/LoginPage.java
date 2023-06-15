package PageEvent;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.BaseTest;
import PageObjects.LoginPageObject;
import Utils.ElementFetch;

public class LoginPage extends BaseTest {
	 
	 
	 ElementFetch ele = new ElementFetch();
	 
	 public void verifyifloginpageisloaded() {
		 
		 Assert.assertTrue(ele.getWebElements("XPATH",LoginPageObject.loginbutton).size()>0, "Page Not Loaded Properly");
	 }
 
	 public void entercredentials() throws InterruptedException {
		 ele.getWebElement("XPATH", LoginPageObject.email).sendKeys("jay.kumar@enercent.co");
		 ele.getWebElement("XPATH", LoginPageObject.password).sendKeys("Enercent$3");
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,1000)"); 
		 WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(3));
		 wait.until(ExpectedConditions.elementToBeClickable(ele.getWebElement("XPATH", LoginPageObject.loginbutton)));
		 ele.getWebElement("XPATH", LoginPageObject.loginbutton).click();
		 
	 }
}
	