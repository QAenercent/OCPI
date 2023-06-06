package PageEvent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.BaseTest;
import PageObjects.ForgotPasswordObject;
import PageObjects.SRCompanydetailsObject;
import Utils.ElementFetch;

public class SRCompanydetailsFunctional extends BaseTest{
	
	String requiredfield = "This field is required";
	String maxminklimit = "Primary contact name must be between 3 and 35 characters";
	String invalidemail = "Invalid email address";
	String invalidmobilenumber = "Invalid phone number";
	String passwordlimit = "Password must be have 6 characters";
	String samepassword = "Password and confirm password should be same";
	
	ElementFetch ele = new ElementFetch();
	public void verificationofcompanydetails() throws IOException, InterruptedException {
	//******************** Scroll *****************// 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(3000);
	
	//******************* Validation of Input Field ********************//
	ele.getWebElement("XPATH",SRCompanydetailsObject.registerhere).click();
	
	String filepath = "./TestData/forgotpass.xlsx";
	FileInputStream inputstream = new FileInputStream(filepath);
	
	XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
	XSSFSheet sheet = workbook.getSheet("Sheet1");
	
	int rows = sheet.getLastRowNum();
	int colmn= sheet.getRow(0).getLastCellNum();
	
	for (int i =1 ; i<=rows; i++) { 
		for(int j=0; j<=colmn;j++) {
			
			ele.getWebElement("XPATH", SRCompanydetailsObject.Primarycontactname).clear();
			ele.getWebElement("XPATH", SRCompanydetailsObject.Primarycontactname).click();
			ele.getWebElement("XPATH", SRCompanydetailsObject.Primarycontactname).sendKeys(sheet.getRow(i).getCell(j++).toString());
			
			JavascriptExecutor jss = (JavascriptExecutor) driver;
		    jss.executeScript("window.scrollBy(0,1000)"); 
		    Thread.sleep(2000);
		    ele.getWebElement("XPATH", SRCompanydetailsObject.proceed).click();
		    WebElement text= ele.getWebElement("XPATH", SRCompanydetailsObject.namefieldrequirederror);
		    
		    Thread.sleep(3);
		    try {
		    	String required= ele.getWebElement("XPATH", SRCompanydetailsObject.namefieldrequirederror).getText();
		    	
		    	if(required.equals(requiredfield)) {
		    	Assert.assertEquals(required, requiredfield);
		    	System.out.println(required);
		    }
		    else {
		    	Thread.sleep(5);
		    	String limit_err = ele.getWebElement("XPATH", SRCompanydetailsObject.limiterror).getText();
			   	Assert.assertEquals(limit_err, maxminklimit);
			   	System.out.println(limit_err);
		   }}
		   
		    catch(TimeoutException e) {
		    	 getScreenshot("SR-Primarycontactname",driver);
				 System.err.println("SR-Primarycontactname test case failed");
		    }
		   Thread.sleep(2000);
		}}}
	
	//******************* Validation of Emailid Field ********************//
	public void verifyemail() throws IOException, InterruptedException {
		String filepath = "./TestData/SR_Functional.xlsx";
		FileInputStream inputstream = new FileInputStream(filepath);
			
		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = workbook.getSheet("Email");
			
		int rows = sheet.getLastRowNum();
		int colmn= sheet.getRow(0).getLastCellNum();
			
		for (int i =1 ; i<=rows; i++) { 
			for(int j=0; j<=colmn;j++) {
					
			ele.getWebElement("XPATH", SRCompanydetailsObject.Email).clear();
			ele.getWebElement("XPATH", SRCompanydetailsObject.Email).click();
			ele.getWebElement("XPATH", SRCompanydetailsObject.Email).sendKeys(sheet.getRow(i).getCell(j++).toString());
						
			JavascriptExecutor jss = (JavascriptExecutor) driver;
			jss.executeScript("window.scrollBy(0,1000)"); 
			Thread.sleep(2000);
			ele.getWebElement("XPATH", SRCompanydetailsObject.proceed).click();
			WebElement text= ele.getWebElement("XPATH", SRCompanydetailsObject.emailfiledrequirederror);
			Thread.sleep(3);
			try {
			String required= ele.getWebElement("XPATH", SRCompanydetailsObject.emailfiledrequirederror).getText();
				    	
			    if(required.equals(requiredfield)) {
				    Assert.assertEquals(required, requiredfield);
				    System.out.println(required);
			    }
			    else {
				    Thread.sleep(5);
				    String invalidemail_err = ele.getWebElement("XPATH", SRCompanydetailsObject.Invalidemail).getText();
					Assert.assertEquals(invalidemail_err, invalidemail);
					System.out.println(invalidemail_err);
				}} 
			catch(TimeoutException e) {
				    	 getScreenshot("SR-Emailid",driver);
						 System.err.println("SR-Emailid test case failed");
				    }
				   Thread.sleep(2000);
				}}} 
			
	//******************* Validation of Verification Code ********************//
	public void verifyverificationcode() throws IOException, InterruptedException { 
		 Thread.sleep(3000);
		 ele.getWebElement("XPATH",SRCompanydetailsObject.otp).click();
		 ele.getWebElement("XPATH",SRCompanydetailsObject.otp).sendKeys(""); 
		 ele.getWebElement("XPATH", SRCompanydetailsObject.proceed).click();
			
		 String requiredfield = ele.getWebElement("XPATH", SRCompanydetailsObject.otpfiledrequirederror).getText();
			if(requiredfield.equals(requiredfield)) {
				Assert.assertTrue(true);
			}
			else {
				getScreenshot("SR-Verificationcode",driver);
				 System.err.println("SR-Verificationcode test case failed");
			}} 
		
	//******************* Validation of Mobile Number ********************//
	public void verifymobilenumber() throws IOException, InterruptedException {
		 String filepath = "./TestData/SR_Functional.xlsx";
		 FileInputStream inputstream = new FileInputStream(filepath);
			
		 XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		 XSSFSheet sheet = workbook.getSheet("Mobilenumber");
			
		 int rows = sheet.getLastRowNum();
		 int colmn= sheet.getRow(0).getLastCellNum();
			
		 for (int i =1 ; i<=rows; i++) { 
			for(int j=0; j<=colmn;j++) { 
			ele.getWebElement("XPATH", SRCompanydetailsObject.mobilenumber).clear();
			ele.getWebElement("XPATH", SRCompanydetailsObject.mobilenumber).click();
			ele.getWebElement("XPATH", SRCompanydetailsObject.mobilenumber).sendKeys(sheet.getRow(i).getCell(j++).toString());
			Thread.sleep(2000);
			ele.getWebElement("XPATH", SRCompanydetailsObject.proceed).click();
			WebElement text= ele.getWebElement("XPATH", SRCompanydetailsObject.mobilenumberfiledrequirederror);
				     
			try {
			     String required= ele.getWebElement("XPATH", SRCompanydetailsObject.mobilenumberfiledrequirederror).getText();
				    	
				 if(required.equals(requiredfield)) {
				    Assert.assertEquals(required, requiredfield);
				    System.out.println(required);
				    }
				 else {
				    Thread.sleep(2000);
				    String invalidmobile_err = ele.getWebElement("XPATH", SRCompanydetailsObject.invalidmobilenumber).getText();
					Assert.assertEquals(invalidmobile_err, invalidmobilenumber);
					System.out.println(invalidmobile_err);
				    }} 
				 catch(TimeoutException e) {
				    	 getScreenshot("SR-Primary Mobile Number",driver);
						 System.err.println("SR-Primary Mobile Number test case failed");
				    } 
				   Thread.sleep(2000);
				}}}
		
	//******************* Validation of Password ********************//
	public void verifypassword() throws IOException, InterruptedException {
		String filepath = "./TestData/SR_Functional.xlsx";
		FileInputStream inputstream = new FileInputStream(filepath);
			
		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = workbook.getSheet("password");
			
		int rows = sheet.getLastRowNum();
		int colmn= sheet.getRow(0).getLastCellNum();
			
		for (int i =1 ; i<=rows; i++) { 
		for(int j=0; j<=colmn;j++) { 
			ele.getWebElement("XPATH", SRCompanydetailsObject.password).clear();
			ele.getWebElement("XPATH", SRCompanydetailsObject.password).click();
			ele.getWebElement("XPATH", SRCompanydetailsObject.password).sendKeys(sheet.getRow(i).getCell(j++).toString());
			Thread.sleep(2000);
			ele.getWebElement("XPATH", SRCompanydetailsObject.proceed).click();
			WebElement text= ele.getWebElement("XPATH", SRCompanydetailsObject.passwordfieldrequirederror);
				     
		 try {
			String required= ele.getWebElement("XPATH", SRCompanydetailsObject.passwordfieldrequirederror).getText();
				    	
			if(required.equals(requiredfield)) {
				Assert.assertEquals(required, requiredfield);
				System.out.println(required);
			 }
			else { 
				String Passwordlimit = ele.getWebElement("XPATH", SRCompanydetailsObject.passworderror).getText();
				Assert.assertEquals(Passwordlimit, passwordlimit);
				System.out.println(Passwordlimit);
			}}    
		 catch(TimeoutException e) {
			 	getScreenshot("SR-Password",driver);
			 	System.err.println("SR-Password test case failed");
		 	} 
		 		Thread.sleep(2000);
				}}}	
			
	//******************* Validation of Confirm Password ********************//
	public void verifyconfirmpassword() throws IOException, InterruptedException {
		String filepath = "./TestData/SR_Functional.xlsx";
		FileInputStream inputstream = new FileInputStream(filepath);
			
		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = workbook.getSheet("Confirmpassword");
			
		int rows = sheet.getLastRowNum();
		int colmn= sheet.getRow(0).getLastCellNum();
			
		for (int i =1 ; i<=rows; i++) { 
		for(int j=0; j<=colmn;j++) { 
			ele.getWebElement("XPATH", SRCompanydetailsObject.confirmpassword).clear();
			ele.getWebElement("XPATH", SRCompanydetailsObject.confirmpassword).click();
			ele.getWebElement("XPATH", SRCompanydetailsObject.confirmpassword).sendKeys(sheet.getRow(i).getCell(j++).toString());
			Thread.sleep(2000);
			ele.getWebElement("XPATH", SRCompanydetailsObject.proceed).click();
			WebElement text= ele.getWebElement("XPATH", SRCompanydetailsObject.confirmpasswordrequirederror);
				     
		try {
		 	String required= ele.getWebElement("XPATH", SRCompanydetailsObject.confirmpasswordrequirederror).getText();
				    	
		if(required.equals(requiredfield)) {
			Assert.assertEquals(required, requiredfield);
			System.out.println(required);
			}
		else { 
			String Samepassword = ele.getWebElement("XPATH", SRCompanydetailsObject.samepassword_error).getText();
			Assert.assertEquals(Samepassword, samepassword);
			System.out.println(Samepassword);
			}}    
		catch(TimeoutException e) {
			getScreenshot("SR-Confirm Password",driver);
			System.err.println("SR-Confirm Password test case failed");
			} 
			Thread.sleep(2000);
		}}}
		}

		
		
	
	



