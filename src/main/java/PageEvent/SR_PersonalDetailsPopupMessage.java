package PageEvent;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.BaseTest;
import PageObjects.SRCompanydetailsObject;
import PageObjects.SR_PersonalDetailPopupObject;
import Utils.ElementFetch;

//public class SR_PersonalDetailsPopupMessage extends BaseTest{
//
//	
//	ElementFetch ele = new ElementFetch();
//	
////********************************Validate Pop-up Message**********************************//
// public void validatepopupmessage() {
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("window.scrollBy(0,1000)"); 
//			Thread.sleep(3000); 
//		ele.getWebElement("XPATH",SRCompanydetailsObject.registerhere).click();
//		
//		String filepath = "./TestData/SR_Functional.xlsx";
//		FileInputStream inputstream = new FileInputStream(filepath);
//		
//		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
//		XSSFSheet sheet = workbook.getSheet("PDPopuperror");
//		
//		int rows = sheet.getLastRowNum();
//		int colmn= sheet.getRow(0).getLastCellNum();
//		js.executeScript("window.scrollBy(0,300)");
//		
//		for (int i =1 ; i<=rows; i++) { 
//			for(int j=0; j<=colmn;j++) {
//			//**********************PrimaryContactName*******************//
//			ele.getWebElement("XPATH", SRCompanydetailsObject.Primarycontactname).clear();
//			ele.getWebElement("XPATH", SRCompanydetailsObject.Primarycontactname).click();
//			ele.getWebElement("XPATH", SRCompanydetailsObject.Primarycontactname).sendKeys(sheet.getRow(i).getCell(j++).toString());
//				
//			//********************Email id*************************//
//			ele.getWebElement("XPATH", SRCompanydetailsObject.Email).clear();
//			ele.getWebElement("XPATH", SRCompanydetailsObject.Email).click();
//			ele.getWebElement("XPATH", SRCompanydetailsObject.Email).sendKeys(sheet.getRow(i).getCell(j++).toString());
//				
//			//********************Generate Code To Verify*****************//
//			WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(30));
//			wait.until(ExpectedConditions.visibilityOf(ele.getWebElement("XPATH",SR_PersonalDetailPopupObject.confirmcodelink))); 
//				
//			//********************OTP*****************************//
//			ele.getWebElement("XPATH", SRCompanydetailsObject.otp).clear();
//			ele.getWebElement("XPATH", SRCompanydetailsObject.otp).click();
//			ele.getWebElement("XPATH", SRCompanydetailsObject.otp).sendKeys(sheet.getRow(i).getCell(j++).toString());
//				
//			//********************MobileNumber*********************//
//			ele.getWebElement("XPATH", SRCompanydetailsObject.mobilenumber).clear();
//			ele.getWebElement("XPATH", SRCompanydetailsObject.mobilenumber).click();
//			ele.getWebElement("XPATH", SRCompanydetailsObject.mobilenumber).sendKeys(sheet.getRow(i).getCell(j++).toString());
//				
//			//*********************Password***********************//
//			ele.getWebElement("XPATH", SRCompanydetailsObject.password).clear();
//			ele.getWebElement("XPATH", SRCompanydetailsObject.password).click();
//			ele.getWebElement("XPATH", SRCompanydetailsObject.password).sendKeys(sheet.getRow(i).getCell(j++).toString());
//				
//			//*********************ConfirmPassword*****************//
//			ele.getWebElement("XPATH", SRCompanydetailsObject.confirmpassword).clear();
//			ele.getWebElement("XPATH", SRCompanydetailsObject.confirmpassword).click();
//			ele.getWebElement("XPATH", SRCompanydetailsObject.confirmpassword).sendKeys(sheet.getRow(i).getCell(j++).toString());
//				
//			ele.getWebElement("XPATH", SRCompanydetailsObject.proceed).click(); 
//			Thread.sleep(2000); 
//			    
////			try {
////			    	if(wait.until(ExpectedConditions.visibilityOf(ele.getWebElement("XPATH",SR_PersonalDetailPopupObject.emailexists)))) {
////			    		
////			    	}
////			     
////			    	 
////			    		
////			    	
////			    	String text= ele.getWebElement("XPATH",SR_PersonalDetailPopupObject.emailexists).getText();
////			    	
////			    	if(required.equals(requiredfield)) {
////			    	Assert.assertEquals(required, requiredfield);
////			    	System.out.println(required);
////			    
////			    else {
////			    	Thread.sleep(5);
////			    	String limit_err = ele.getWebElement("XPATH", SRCompanydetailsObject.limiterror).getText();
////				   	Assert.assertEquals(limit_err, maxminklimit);
////				   	System.out.println(limit_err);
////			   }}
////			   
////			    catch(TimeoutException e) {
////			    	 getScreenshot("SR-Primarycontactname",driver);
////					 System.err.println("SR-Primarycontactname test case failed");
////			    }
////			   Thread.sleep(2000);
////			}}}
//
