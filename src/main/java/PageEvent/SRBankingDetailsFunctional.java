package PageEvent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.BaseTest;
import PageObjects.SRBankingDetailsObject;
import PageObjects.SRCompanyDetailsObject;
import PageObjects.SRPersonaldetailsObject;
import Utils.ElementFetch;

public class SRBankingDetailsFunctional extends BaseTest{

	ElementFetch ele = new ElementFetch(); 
	String required_error = "This field is required";
	String accountholdername_error = "Holder name must be between 3 and 25 characters";
	String accountnumber_error = "Account number must be between 6 and 18 digits";
	String samepassword_error = "Account number and confirm account number should be same";
	String invalidifscformat_error = "Invalid IFSC code eg : SBIN0125620";
	String registeraccountnumber_error = "Account number has already been taken";
	String invalidifsc_error = "Ifsc code is invalid";
	String accnumberandifsc_error = "Account number has already been taken, Ifsc code is invalid";
	String imagesize_error = "Image size cannot be more than 250 KB";
	
	 
	public void entercompanydetails() throws InterruptedException, IOException {
		
	//********************Enter All details of Company details page********************************//
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	  wait.until(ExpectedConditions.visibilityOf( ele.getWebElement("XPATH", SRCompanyDetailsObject.companyname)));
	  ele.getWebElement("XPATH", SRCompanyDetailsObject.companyname).sendKeys("TestAutom");
	  ele.getWebElement("XPATH", SRCompanyDetailsObject.companyphonenumber).sendKeys("9893893115"); 
	  ele.getWebElement("XPATH", SRCompanyDetailsObject.email).sendKeys("asasssast@enercent.co");
	  ele.getWebElement("XPATH", SRCompanyDetailsObject.companyaddress).sendKeys("shhdghahgs");
	  ele.getWebElement("XPATH", SRCompanyDetailsObject.statedropdown).sendKeys("maharas");
	  ele.getWebElement("XPATH", SRCompanyDetailsObject.statedropdown).sendKeys(Keys.ENTER);
	  Thread.sleep(1000);
	  ele.getWebElement("XPATH", SRCompanyDetailsObject.citydropdown).sendKeys("nanded");
	  ele.getWebElement("XPATH", SRCompanyDetailsObject.citydropdown).sendKeys(Keys.ENTER);
	  ele.getWebElement("XPATH", SRCompanyDetailsObject.pincode).sendKeys("431603");
	  ele.getWebElement("XPATH", SRCompanyDetailsObject.proceed).click();
	  wait.until(ExpectedConditions.visibilityOf( ele.getWebElement("XPATH", SRCompanyDetailsObject.popup)));
	  if(ele.getWebElement("XPATH", SRCompanyDetailsObject.popup).isDisplayed()) {
		  Assert.assertEquals(ele.getWebElement("XPATH", SRCompanyDetailsObject.popup).getText(),"Company details added successfully");
		  System.out.println(ele.getWebElement("XPATH", SRCompanyDetailsObject.popup).getText());
		  ele.getWebElement("XPATH", SRCompanyDetailsObject.okbutton).click(); 
	  }
	  else {
		  getScreenshot("Company Details Page Error",driver);
		  System.err.println("Company Details Page Error");
	  }}
	  
	//*****************************Verify Account Holder Name Field************************************//
	public void verifyaccountholdername() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele.getWebElement("XPATH", SRBankingDetailsObject.accountholdername)));
		
		String filepath = "./TestData/SR_Functional.xlsx";
		FileInputStream inputstream = new FileInputStream(filepath);

		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = workbook.getSheet("CompanyName");

		int rows = sheet.getLastRowNum();
		int colmn = sheet.getRow(0).getLastCellNum();

		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j <= colmn; j++) {
				ele.getWebElement("XPATH", SRBankingDetailsObject.accountholdername).clear();
				ele.getWebElement("XPATH", SRBankingDetailsObject.accountholdername).sendKeys(sheet.getRow(i).getCell(j++).toString());
				ele.getWebElement("XPATH", SRBankingDetailsObject.proceed).click(); 
				try { 
					String required = ele.getWebElement("XPATH", SRBankingDetailsObject.accountnamerequired_error).getText();
					if (required.equals(required_error)) {
						Assert.assertEquals(required, required_error);
						System.out.println(required);
					} 
					else { 
					String namelimiterror = ele.getWebElement("XPATH", SRBankingDetailsObject.accountnamelimit_error).getText();
						Assert.assertEquals(namelimiterror, accountholdername_error);
						System.out.println(namelimiterror);
					}
				} catch (TimeoutException e) {
					getScreenshot("Account Holder Name Field Error", driver);
					System.err.println("Account Holder Name Field Error test case failed");
				}}}}
				
	//*****************************Verify Account Number Field************************************//
	public void verifyaccountnumber() throws IOException { 
		String filepath = "./TestData/SR_Functional.xlsx";
		FileInputStream inputstream = new FileInputStream(filepath);

		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = workbook.getSheet("AccountNumber");

		int rows = sheet.getLastRowNum();
		int colmn = sheet.getRow(0).getLastCellNum();

		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j <= colmn; j++) {
				ele.getWebElement("XPATH", SRBankingDetailsObject.accountnumber).clear();
				ele.getWebElement("XPATH", SRBankingDetailsObject.accountnumber).sendKeys(sheet.getRow(i).getCell(j++).toString());
				ele.getWebElement("XPATH", SRBankingDetailsObject.proceed).click(); 
			try { 
			String required = ele.getWebElement("XPATH", SRBankingDetailsObject.accounnumberrequired_error).getText();
			if (required.equals(required_error)) {
				Assert.assertEquals(required, required_error);
				System.out.println(required);
				} 
			else { 
				String accnumberlimiterror = ele.getWebElement("XPATH", SRBankingDetailsObject.accountnumberlimit_error).getText();
				Assert.assertEquals(accnumberlimiterror, accountnumber_error);
				System.out.println(accnumberlimiterror);
				}
				} 
			catch (TimeoutException e) {
				getScreenshot("Account Number Field Error", driver);
				System.err.println("Account Number Field Error test case failed");
			}}}}	
	
	//*****************************Verify Confirm Account Number Field************************************//
	public void confirmaccountnumber() throws IOException {
		String filepath = "./TestData/SR_Functional.xlsx";
		FileInputStream inputstream = new FileInputStream(filepath);

		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = workbook.getSheet("ConfirmAccountNumber");

		int rows = sheet.getLastRowNum();
		int colmn = sheet.getRow(0).getLastCellNum();

		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j <= colmn; j++) {
				ele.getWebElement("XPATH", SRBankingDetailsObject.confirmaccountnumber).clear();
				ele.getWebElement("XPATH", SRBankingDetailsObject.confirmaccountnumber).sendKeys(sheet.getRow(i).getCell(j++).toString());
				ele.getWebElement("XPATH", SRBankingDetailsObject.proceed).click(); 
			try { 
			String required = ele.getWebElement("XPATH", SRBankingDetailsObject.confirmaccountrequired_error).getText();
			if (required.equals(required_error)) {
				Assert.assertEquals(required, required_error);
				System.out.println(required);
				} 
			else { 
				String confirmaccounterror = ele.getWebElement("XPATH", SRBankingDetailsObject.confirmaccountnumber_error).getText();
				Assert.assertEquals(confirmaccounterror, samepassword_error);
				System.out.println(confirmaccounterror);
				}
				} 
			catch (TimeoutException e) {
				getScreenshot("Confirm Account Number Field Error", driver);
				System.err.println("Confirm Account Number Field Error test case failed");
			}}}}
	
	//*****************************Verify IFSC Code Field************************************//
	public void verifyifsccode() throws IOException {
		String filepath = "./TestData/SR_Functional.xlsx";
		FileInputStream inputstream = new FileInputStream(filepath);

		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = workbook.getSheet("IFSCCode");

		int rows = sheet.getLastRowNum();
		int colmn = sheet.getRow(0).getLastCellNum();

		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j <= colmn; j++) {
				ele.getWebElement("XPATH", SRBankingDetailsObject.ifsccode).clear();
				ele.getWebElement("XPATH", SRBankingDetailsObject.ifsccode).sendKeys(sheet.getRow(i).getCell(j++).toString());
				ele.getWebElement("XPATH", SRBankingDetailsObject.proceed).click(); 
			try { 
			String required = ele.getWebElement("XPATH", SRBankingDetailsObject.ifsccoderequired_error).getText();
			if (required.equals(required_error)) {
				Assert.assertEquals(required, required_error);
				System.out.println(required);
				} 
			else { 
				String invalidifsc = ele.getWebElement("XPATH", SRBankingDetailsObject.invalidifsccode_error).getText();
				Assert.assertEquals(invalidifsc, invalidifscformat_error);
				System.out.println(invalidifsc);
				}
				} 
			catch (TimeoutException e) {
				getScreenshot("IFSC Code Field Error", driver);
				System.err.println("IFSC Code Field Error test case failed");
			}}}}
	
	//*****************************Verify Banking Details Page POP-Up************************************//
	 public void verifyalltypeofpopup() throws IOException, InterruptedException {
		 String filepath = "./TestData/SR_Functional.xlsx";
		 FileInputStream inputstream = new FileInputStream(filepath);

		 XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		 XSSFSheet sheet = workbook.getSheet("BankingDetailPopupError");

		 int rows = sheet.getLastRowNum();
		 int colmn = sheet.getRow(0).getLastCellNum();

		 for (int i = 1; i <= rows; i++) {
			 for (int j = 0; j <= colmn; j++) {
			ele.getWebElement("XPATH", SRBankingDetailsObject.accountholdername).clear();
			ele.getWebElement("XPATH", SRBankingDetailsObject.accountholdername).sendKeys(sheet.getRow(i).getCell(j++).toString()); 
			ele.getWebElement("XPATH", SRBankingDetailsObject.accountnumber).clear();
			ele.getWebElement("XPATH", SRBankingDetailsObject.accountnumber).sendKeys(sheet.getRow(i).getCell(j++).toString()); 
			ele.getWebElement("XPATH", SRBankingDetailsObject.confirmaccountnumber).clear();
			ele.getWebElement("XPATH", SRBankingDetailsObject.confirmaccountnumber).sendKeys(sheet.getRow(i).getCell(j++).toString()); 
			ele.getWebElement("XPATH", SRBankingDetailsObject.ifsccode).clear();
			ele.getWebElement("XPATH", SRBankingDetailsObject.ifsccode).sendKeys(sheet.getRow(i).getCell(j++).toString());
			ele.getWebElement("XPATH", SRBankingDetailsObject.selectbank).clear();
			Thread.sleep(2000);
			ele.getWebElement("XPATH", SRBankingDetailsObject.selectbank).sendKeys(sheet.getRow(i).getCell(j++).toString());
			ele.getWebElement("XPATH", SRBankingDetailsObject.selectbank).sendKeys(Keys.ENTER);
			Thread.sleep(1000); 
			ele.getWebElement("XPATH", SRBankingDetailsObject.addfile).click();
			ele.getWebElement("XPATH", SRBankingDetailsObject.addfile).sendKeys("./TestData/test.png");
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(ele.getWebElement("XPATH", SRBankingDetailsObject.proceed)));
			ele.getWebElement("XPATH", SRBankingDetailsObject.proceed).click(); 
			wait.until(ExpectedConditions.visibilityOf(ele.getWebElement("XPATH", SRCompanyDetailsObject.okbutton))); 
			
			if(ele.getWebElement("XPATH", SRBankingDetailsObject.popup).isDisplayed()) {
			String popup = ele.getWebElement("XPATH", SRBankingDetailsObject.popup).getText();
				
			//******************************Account number has already been taken Pop-up*******************************************//
			if(popup.equals(registeraccountnumber_error)){ 
				Assert.assertTrue(true);
				System.out.println(ele.getWebElement("XPATH", SRBankingDetailsObject.popup).getText());
			}
			//*******************************IFSC code is invalid Pop-up****************************************//
			else if(popup.equals(invalidifsc_error)) {
				Assert.assertTrue(true);
				System.out.println(ele.getWebElement("XPATH", SRBankingDetailsObject.popup).getText()); 
			}
			//*******************************Account number and IFSC code Pop-up****************************************//
			else if(popup.equals(accnumberandifsc_error)) {
				Assert.assertTrue(true);
				System.out.println(ele.getWebElement("XPATH", SRBankingDetailsObject.popup).getText());  
			}
			//*******************************Image Size Pop-up****************************************//
			else if(popup.equals(imagesize_error)) { 
				Assert.assertTrue(true);
				System.out.println(ele.getWebElement("XPATH", SRBankingDetailsObject.popup).getText());  
			}
			  
			else {
				getScreenshot("Pop-Up mesages", driver);
				System.err.println("Pop-Up test case failed");
			}
			ele.getWebElement("XPATH", SRBankingDetailsObject.okbutton).click();
			wait.until(ExpectedConditions.visibilityOf(ele.getWebElement("XPATH", SRBankingDetailsObject.proceed)));
			ele.getWebElement("XPATH", SRBankingDetailsObject.deletebutton).click();
			}}}
	}
	}
	

