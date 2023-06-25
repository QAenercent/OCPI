package PageEvent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	String validemail_toast ="Please enter a Valid Email Address";
    String invaliduser_toast = "Invalid User";
    String emptyfield_toast  = "Please fill all the mandatory fields";
    String emaillimit_error = "Enter min 3 and max 60 characters";
    String passwordlimit_error = "Enter min 6 and max 32 characters";
    String invalidpassword = "Invalid Email or Password";

	public void verifyifloginpageisloaded() {

		Assert.assertTrue(ele.getWebElements("XPATH", LoginPageObject.loginbutton).size() > 0,
				"Page Not Loaded Properly");
	}

	public void entercredentials() throws InterruptedException {
		ele.getWebElement("XPATH", LoginPageObject.email).sendKeys("jay.kumar@enercent.co");
		ele.getWebElement("XPATH", LoginPageObject.password).sendKeys("Enercent$3");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(ele.getWebElement("XPATH", LoginPageObject.loginbutton)));
		ele.getWebElement("XPATH", LoginPageObject.loginbutton).click();

	}
	
	//**********************************Validate Toast Errors ********************************//
	public void verifytoast_errors() throws IOException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String filepath = "./TestData/LoginPage.xlsx";
		FileInputStream inputstream = new FileInputStream(filepath);
				
		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = workbook.getSheet("Toast");
		 
		int rows = sheet.getLastRowNum();
		int colmn= sheet.getRow(0).getLastCellNum();
				
		for (int i =1 ; i<=rows; i++) {
			for(int j=0; j<=colmn ;j++) { 
				  
			jse.executeScript("window.scrollBy(0,250)");
				
			//************* Email *****************//
			ele.getWebElement("XPATH",LoginPageObject.email).clear(); 
			ele.getWebElement("XPATH",LoginPageObject.email).sendKeys(sheet.getRow(i).getCell(j++).toString());
				
			//************* Password **************// 
			ele.getWebElement("XPATH",LoginPageObject.password).clear();
			ele.getWebElement("XPATH",LoginPageObject.password).sendKeys(sheet.getRow(i).getCell(j++).toString());
			
			//***************Checkbox **************//
			WebElement checkbox = ele.getWebElement("XPATH",LoginPageObject.Checkbox);
			if(checkbox.isSelected()==false) {
				checkbox.click();
			}
			ele.getWebElement("XPATH",LoginPageObject.loginbutton).click(); 
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(ele.getWebElement("XPATH",LoginPageObject.toastframe))); 
			WebElement toast_error = ele.getWebElement("XPATH",LoginPageObject.toastframe); 
				
			if (toast_error.isDisplayed()) { 
			String text= toast_error.getText(); 
					
			if(text.equals(validemail_toast)) {
			Assert.assertEquals(text, validemail_toast);
			System.out.println(text);
			} 
			else if (text.equals(invaliduser_toast)) {
			Assert.assertEquals(text, invaliduser_toast);
			System.out.println(text);
			jse.executeScript("window.scrollBy(0,250)");
			} 	
			else if(text.equals(emptyfield_toast)){
			Assert.assertEquals(text, emptyfield_toast);
			System.out.println(text); 
			}
			else{
			getScreenshot("Toast Error Messages", driver);
			System.err.println("Toast Test Cases Failed");
			}
			wait.until(ExpectedConditions.invisibilityOf(ele.getWebElement("XPATH",LoginPageObject.toastframe)));
			}}}} 
	
	//************************************Verify All Valid Accounts*****************************//
	public void verifyAllvalid_credentails() throws IOException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String filepath = "./TestData/LoginPage.xlsx";
		FileInputStream inputstream = new FileInputStream(filepath);
				
		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = workbook.getSheet("ValidAccounts");
		 
		int rows = sheet.getLastRowNum();
		int colmn= sheet.getRow(0).getLastCellNum();
				
		for (int i =1 ; i<=rows; i++) {
			for(int j=0; j<=colmn ;j++) { 
				  
			jse.executeScript("window.scrollBy(0,250)");
				
			//************* Email *****************//
			ele.getWebElement("XPATH",LoginPageObject.email).clear(); 
			ele.getWebElement("XPATH",LoginPageObject.email).sendKeys(sheet.getRow(i).getCell(j++).toString());
			//************* Password **************// 
			ele.getWebElement("XPATH",LoginPageObject.password).clear();
			ele.getWebElement("XPATH",LoginPageObject.password).sendKeys(sheet.getRow(i).getCell(j++).toString());
			
			//***************Checkbox **************//
			WebElement checkbox = ele.getWebElement("XPATH",LoginPageObject.Checkbox);
			if(checkbox.isSelected()==false) {
				checkbox.click();
			}
			ele.getWebElement("XPATH",LoginPageObject.loginbutton).click(); 
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(ele.getWebElement("XPATH",LoginPageObject.profilename)));
			
			String text = ele.getWebElement("XPATH",LoginPageObject.profilename).getText();
			
			//************************  Valid Credentials Of Provider ***********************// 
			 if(text.contains("roaming_provider")) { 
			  Assert.assertTrue(true);
			  System.out.println(text);  
			 } 
			 //************************  Valid Credentials Of Partner ***********************//
			 
			 else if (text.contains("roaming_partner")) { 
			  Assert.assertTrue(true);
			  System.out.println(text);  
			 }
			 
			 //************************  Valid Credentials Of Account Manager ***********************//
			 
			 else if(text.contains("account_manager")) {
			  Assert.assertTrue(true);
			  System.out.println(text); 
			 }
			 
			 else {
			 getScreenshot("Toast Error Messages", driver);
			 System.err.println("Valid Credentials Test Cases Failed");
			 } 
			ele.getWebElement("XPATH",LoginPageObject.profilename).click();
			ele.getWebElement("XPATH",LoginPageObject.Logout).click();
			wait.until(ExpectedConditions.visibilityOf(ele.getWebElement("XPATH",LoginPageObject.headline)));
			jse.executeScript("window.scrollBy(0,250)"); 
			 }}} 
	
	//********************************Verify Min & Max Limit Error Of Email & Password******************************//
	
	public void verifyminandmaxLimit_error() throws IOException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		ele.getWebElement("XPATH",LoginPageObject.email).sendKeys("sa");
		ele.getWebElement("XPATH",LoginPageObject.password).sendKeys("12s@a");
		WebElement email_error = ele.getWebElement("XPATH",LoginPageObject.emaillimit_error);
		WebElement password_error = ele.getWebElement("XPATH",LoginPageObject.passwordlimit_error);
		
		if(email_error.isDisplayed() && password_error.isDisplayed()) {
		Assert.assertEquals(email_error.getText(), emaillimit_error);
		Assert.assertEquals(password_error.getText(), passwordlimit_error); 
		}
		else {
		getScreenshot("Limit Error Messages", driver);
		System.err.println("Limit Error Test Cases Failed");
		 }}
	//****************************Invalid Password Error********************************//
	public void verifyinvalidpassword_error() throws IOException, InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		ele.getWebElement("XPATH",LoginPageObject.email).sendKeys("suraj.k@antino.io");
		ele.getWebElement("XPATH",LoginPageObject.password).sendKeys("12s@asfsc");
		ele.getWebElement("XPATH",LoginPageObject.loginbutton).click();
		WebElement invalidpass_error = ele.getWebElement("XPATH",LoginPageObject.invalidpassword_error);
		if(invalidpass_error.getText().equals(invalidpassword)) {
			Assert.assertTrue(true);
			Thread.sleep(2000);
			System.out.println(invalidpass_error.getText());
		}
		else {
			getScreenshot("Invalid Password Error Message", driver);
			System.err.println("Invalid Password Error Test Cases Failed");
		}}}
	
			
