package PageEvent;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.BaseTest;
import PageObjects.UIForgotpasswordObject;
import Utils.ElementFetch;

public class UIForgotpasswordpage extends BaseTest {

	ElementFetch ele = new ElementFetch();
	//**************************UI Validation of Headline1 ****************************//
	
	public void verifyheadline1() throws InterruptedException {
		ele.getWebElement("XPATH",UIForgotpasswordObject.forgotpasswordlink).click(); 
		Thread.sleep(10);
		String actualtext = ele.getWebElement("XPATH",UIForgotpasswordObject.forgotpassheadline).getText();
		System.out.println(actualtext);
		Assert.assertEquals(actualtext, "No worries, we will send you the reset instructions");
	}
	//***************************UI Validation of Sub-headline**************************//
	public void verifysubheading() {
		String actualtext = ele.getWebElement("XPATH",UIForgotpasswordObject.noworriesline).getText();
		Assert.assertEquals(actualtext, "No worries, we will send you the reset instructions");
	}
	//***************************UI Validation of Email-Headline**************************//
	public void verifyemailheadline() {
		String actualtext = ele.getWebElement("XPATH",UIForgotpasswordObject.emailtitle).getText();
		Assert.assertEquals(actualtext, "Email");
	}
	//***************************UI Validation of Email field **************************//
	public void verifyemailplaceholder() {
		String actualtext = ele.getWebElement("XPATH",UIForgotpasswordObject.email).getAttribute("placeholder");
		System.out.println(actualtext);
		Assert.assertEquals(actualtext, "Enter your email");
	 
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable (By.xpath("//input[@placeholder='Enter your email']")));
			System.out.println("Email is clickable");
		}
		catch(TimeoutException e) {
			System.out.println("Email Not is clickable");
		} 
		}
	//***************************UI Validation of Resetpassword button**************************//
	public void verifyresetpassword() throws IOException { 
			String color = driver.findElement(By.xpath("//input[@value='Reset Password']")).getCssValue("background-color");
			String hex = Color.fromString(color).asHex();
			System.out.println(hex);
			String Actual_hex = "#000000";
			Assert.assertEquals(Actual_hex, hex);
			
			if(hex.equals(Actual_hex)) {
				System.out.println("Resetpassword BG color is proper");
			}
			else {
				getScreenshot("Logo-bg-color",driver);
				System.out.println("Resetpassword button color is Not proper");
			}
			String text = driver.findElement(By.xpath("//input[@value='Reset Password']")).getAttribute("value");
			String actualtext1 = "Reset Password";
			if (actualtext1.equals(text)) {
				Assert.assertTrue(true);
			}
			else {
				getScreenshot("Resetpassword text",driver);
				System.out.println("Resetpassword button text is Not proper");
			}
		}
	//***************************UI Validation of Backtologin**************************//
	public void verifybacktologin() throws IOException, InterruptedException {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
	      js.executeScript("window.scrollBy(0,1500)"); 
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable (By.xpath("//div[contains(text(),'Back to Login')]")));
			driver.findElement(By.xpath("//div[contains(text(),'Back to Login')]")).click();
			Thread.sleep(2000);
			WebElement text1 = driver.findElement(By.xpath("//p[contains(text(),'Please enter')]"));
			 text1.getText(); 
			 String actual = "Please enter your details to access your eMSP account";
			 if(actual.equals(text1.getText())) {
				 Assert.assertTrue(true);
			 }
			 else {
					getScreenshot("backtologin-link",driver);
					System.out.println("Backtologin link is clickable");
				} 
		}
		catch(TimeoutException e) { 
		} 
	  driver.findElement(By.xpath("//p[@class='style_forgotPasswordPara__1XcgL']")).click(); 
	}
	//***************************UI Validation of Footer**************************//
	public void verifyfooter() throws IOException {
		boolean image = driver.findElement(By.xpath("//img[@alt='jio-Things']")).isDisplayed();
	    if(image == true) {
	    	System.out.println("Footer is visible");
	    }
	    else {
	    	getScreenshot("Footer image",driver);
			System.out.println("Footer image is not visible");
	    }
	}
	}

 
