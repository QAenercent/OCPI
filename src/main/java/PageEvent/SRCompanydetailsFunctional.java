package PageEvent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.BaseTest;
import PageObjects.SRCompanyDetailsObject;
import PageObjects.SRPersonaldetailsObject;
import Utils.ElementFetch;

public class SRCompanydetailsFunctional extends BaseTest{
	
	ElementFetch ele = new ElementFetch(); 
	String required_error = "This field is required";
	String namelimit_error = "Company name must be between 3 and 35 characters";
	String phonenumberlimit_error = "Invalid phone number";
	String invalidemail = "Invalid email address";
	String companyaddresslimit = "Company address must be between 3 and 50 characters and only / , . - are allowed";
	String invalidpincode = "Invalid email address";

	public void enterpersonaldetails() throws InterruptedException {
		// ******************** Scroll *****************//
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		
		//********************Enter All details of personal details page********************************//
		ele.getWebElement("XPATH", SRPersonaldetailsObject.registerhere).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele.getWebElement("XPATH", SRPersonaldetailsObject.Primarycontactname))).isDisplayed();
		ele.getWebElement("XPATH", SRPersonaldetailsObject.Primarycontactname).sendKeys("suraj");
		ele.getWebElement("XPATH", SRPersonaldetailsObject.Email).sendKeys("alert@enercent.co");
		ele.getWebElement("XPATH", SRPersonaldetailsObject.generatecodelink).click();
		wait.until(ExpectedConditions.visibilityOf(ele.getWebElement("XPATH", SRPersonaldetailsObject.confirmationcode)));
		ele.getWebElement("XPATH", SRPersonaldetailsObject.otp).sendKeys("121212");
		js.executeScript("window.scrollBy(0,250)");
		wait.until(ExpectedConditions.visibilityOf(ele.getWebElement("XPATH", SRPersonaldetailsObject.confirmpassword)));
		ele.getWebElement("XPATH", SRPersonaldetailsObject.mobilenumber).sendKeys("1212121212");
		ele.getWebElement("XPATH", SRPersonaldetailsObject.password).sendKeys("aaaaaaaa");
		ele.getWebElement("XPATH", SRPersonaldetailsObject.confirmpassword).sendKeys("aaaaaaaa");
		ele.getWebElement("XPATH", SRPersonaldetailsObject.proceed).click();
	}
	
	//****************************Company Details Page -Verify all type of errors****************************//
	
	//**************************Validation of Company Name********************************//
	public void verifycomapnynamefield() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele.getWebElement("XPATH", SRCompanyDetailsObject.companyname)));
		
		String filepath = "./TestData/SR_Functional.xlsx";
		FileInputStream inputstream = new FileInputStream(filepath);

		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = workbook.getSheet("CompanyName");

		int rows = sheet.getLastRowNum();
		int colmn = sheet.getRow(0).getLastCellNum();

		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j <= colmn; j++) {
			ele.getWebElement("XPATH", SRCompanyDetailsObject.companyname).clear();
			ele.getWebElement("XPATH", SRCompanyDetailsObject.companyname).sendKeys(sheet.getRow(i).getCell(j++).toString());
			ele.getWebElement("XPATH", SRCompanyDetailsObject.proceed).click(); 
			try { 
				String required = ele.getWebElement("XPATH", SRCompanyDetailsObject.companynamedrequired_error).getText();
				if (required.equals(required_error)) {
					Assert.assertEquals(required, required_error);
					System.out.println(required);
				} 
				else { 
				String namelimiterror = ele.getWebElement("XPATH", SRCompanyDetailsObject.companynamelimit_error).getText();
					Assert.assertEquals(namelimiterror, namelimit_error);
					System.out.println(namelimiterror);
				}
			} catch (TimeoutException e) {
				getScreenshot("Company Name Field Error", driver);
				System.err.println("Company Name Field Error test case failed");
			}
			}}}
		//**************************Validation of Company Phone Number********************************//
	 public void companyphonenumber() throws IOException {
		 String filepath = "./TestData/SR_Functional.xlsx";
		 FileInputStream inputstream = new FileInputStream(filepath);

		 XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		 XSSFSheet sheet = workbook.getSheet("CompanyPhoneNo");

		 int rows = sheet.getLastRowNum();
		 int colmn = sheet.getRow(0).getLastCellNum();

		 for (int i = 1; i <= rows; i++) {
			 for (int j = 0; j <= colmn; j++) {
				ele.getWebElement("XPATH", SRCompanyDetailsObject.companyphonenumber).clear();
				ele.getWebElement("XPATH", SRCompanyDetailsObject.companyphonenumber).sendKeys(sheet.getRow(i).getCell(j++).toString());
				ele.getWebElement("XPATH", SRCompanyDetailsObject.proceed).click(); 
				try { 
				String required = ele.getWebElement("XPATH", SRCompanyDetailsObject.phonenumberrequired_error).getText();
				if (required.equals(required_error)) {
					Assert.assertEquals(required, required_error);
					System.out.println(required);
					} 
				else { 
					String numberlimiterror = ele.getWebElement("XPATH", SRCompanyDetailsObject.phonenumberlimit_error).getText();
						Assert.assertEquals(numberlimiterror, phonenumberlimit_error);
						System.out.println(numberlimiterror);
					}}		
				 catch (TimeoutException e) {
					getScreenshot("Company phone number Field Error", driver);
					System.err.println("Company phone numbers test case failed");
			}}}}
					 		
	//**************************Validation of Company Email Address********************************//
	public void verifycompanyemailid() throws IOException {
		
		 String filepath = "./TestData/SR_Functional.xlsx";
		 FileInputStream inputstream = new FileInputStream(filepath);

		 XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		 XSSFSheet sheet = workbook.getSheet("CompanyEmail");

		 int rows = sheet.getLastRowNum();
		 int colmn = sheet.getRow(0).getLastCellNum();

		 for (int i = 1; i <= rows; i++) {
			 for (int j = 0; j <= colmn; j++) {
				ele.getWebElement("XPATH", SRCompanyDetailsObject.email).clear();
				ele.getWebElement("XPATH", SRCompanyDetailsObject.email).sendKeys(sheet.getRow(i).getCell(j++).toString());
				ele.getWebElement("XPATH", SRCompanyDetailsObject.proceed).click(); 
				try { 
				String required = ele.getWebElement("XPATH", SRCompanyDetailsObject.emailrequired_error).getText();
				if (required.equals(required_error)) {
					Assert.assertEquals(required, required_error);
					System.out.println(required);
					} 
				else { 
					String emailerror = ele.getWebElement("XPATH", SRCompanyDetailsObject.invalidemail_error).getText();
						Assert.assertEquals(emailerror, invalidemail);
						System.out.println(emailerror);
					}}		
				 catch (TimeoutException e) {
					getScreenshot("Company email address Error", driver);
					System.err.println("Company email address test case failed");
			}}}}
	
	//**************************Validation of Company Address********************************//
	public void verifycompanyaddress() throws IOException {

		String filepath = "./TestData/SR_Functional.xlsx";
		 FileInputStream inputstream = new FileInputStream(filepath);

		 XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		 XSSFSheet sheet = workbook.getSheet("CompanyAddress");

		 int rows = sheet.getLastRowNum();
		 int colmn = sheet.getRow(0).getLastCellNum();

		 for (int i = 1; i <= rows; i++) {
			 for (int j = 0; j <= colmn; j++) {
				ele.getWebElement("XPATH", SRCompanyDetailsObject.companyaddress).clear();
				ele.getWebElement("XPATH", SRCompanyDetailsObject.companyaddress).sendKeys(sheet.getRow(i).getCell(j++).toString());
				ele.getWebElement("XPATH", SRCompanyDetailsObject.proceed).click(); 
				try { 
				String required = ele.getWebElement("XPATH", SRCompanyDetailsObject.addressrequired_error).getText();
				if (required.equals(required_error)) {
					Assert.assertEquals(required, required_error);
					System.out.println(required);
					} 
				else { 
					String companyaddress_error = ele.getWebElement("XPATH", SRCompanyDetailsObject.companyaddresslimit_error).getText();
						Assert.assertEquals(companyaddress_error, companyaddresslimit);
						System.out.println(companyaddress_error);
					}}		
				 catch (TimeoutException e) {
					getScreenshot("Company address Error", driver);
					System.err.println("Company address test case failed");
		}}}}
	//**************************Validation of Pincode********************************//
	public void verifypincode() throws IOException, InterruptedException {

		String filepath = "./TestData/SR_Functional.xlsx";
		 FileInputStream inputstream = new FileInputStream(filepath);

		 XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		 XSSFSheet sheet = workbook.getSheet("Pincode");

		 int rows = sheet.getLastRowNum();
		 int colmn = sheet.getRow(0).getLastCellNum();

		 for (int i = 1; i <= rows; i++) {
			 for (int j = 0; j <= colmn; j++) {
				ele.getWebElement("XPATH", SRCompanyDetailsObject.pincode).clear();
				ele.getWebElement("XPATH", SRCompanyDetailsObject.pincode).sendKeys(sheet.getRow(i).getCell(j++).toString());
				ele.getWebElement("XPATH", SRCompanyDetailsObject.proceed).click(); 
				try { 
				String required = ele.getWebElement("XPATH", SRCompanyDetailsObject.pincoderequired_error).getText();
				if (required.equals(required_error)) {
					Assert.assertEquals(required, required_error);
					System.out.println(required);
					} 
				else { 
					String pincodeerror = ele.getWebElement("XPATH", SRCompanyDetailsObject.invalidpincode).getText();
						Assert.assertEquals(pincodeerror, invalidpincode);
						System.out.println(pincodeerror);
					}}		
				 catch (TimeoutException e) {
					getScreenshot("Company Pincode Error", driver);
					System.err.println("Company Pincode test case failed");
		}}}
		 ele.getWebElement("XPATH", SRCompanyDetailsObject.statedropdown).click();
		 ele.getWebElement("XPATH", SRCompanyDetailsObject.citydropdown).click();
		 Thread.sleep(2000);		 }
}
