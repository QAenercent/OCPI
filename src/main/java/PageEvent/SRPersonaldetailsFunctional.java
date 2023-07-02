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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.BaseTest;
import PageObjects.ForgotPasswordObject;
import PageObjects.SRCompanyDetailsObject;
import PageObjects.SRPersonaldetailsObject;
import Utils.ElementFetch;

public class SRPersonaldetailsFunctional extends BaseTest {

	String requiredfield = "This field is required";
	String maxminklimit = "Primary contact name must be between 3 and 35 characters";
	String invalidemail = "Invalid email address";
	String invalidmobilenumber = "Invalid phone number";
	String passwordlimit = "Password must be have 6 characters";
	String samepassword = "Password and confirm password should be same";

	ElementFetch ele = new ElementFetch();

	public void verificationofcompanydetails() throws IOException, InterruptedException {
		// ******************** Scroll *****************//
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);

		// ******************* Validation of Input Field ********************//
		ele.getWebElement("XPATH", SRPersonaldetailsObject.registerhere).click();

		String filepath = "./TestData/forgotpass.xlsx";
		FileInputStream inputstream = new FileInputStream(filepath);

		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int rows = sheet.getLastRowNum();
		int colmn = sheet.getRow(0).getLastCellNum();

		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j <= colmn; j++) {

				ele.getWebElement("XPATH", SRPersonaldetailsObject.Primarycontactname).clear();
				ele.getWebElement("XPATH", SRPersonaldetailsObject.Primarycontactname).click();
				ele.getWebElement("XPATH", SRPersonaldetailsObject.Primarycontactname)
						.sendKeys(sheet.getRow(i).getCell(j++).toString());

				JavascriptExecutor jss = (JavascriptExecutor) driver;
				jss.executeScript("window.scrollBy(0,1000)");
				Thread.sleep(2000);
				ele.getWebElement("XPATH", SRPersonaldetailsObject.proceed).click();
				WebElement text = ele.getWebElement("XPATH", SRPersonaldetailsObject.namefieldrequirederror);

				Thread.sleep(3);
				try {
					String required = ele.getWebElement("XPATH", SRPersonaldetailsObject.namefieldrequirederror)
							.getText();

					if (required.equals(requiredfield)) {
						Assert.assertEquals(required, requiredfield);
						System.out.println(required);
					} else {
						Thread.sleep(5);
						String limit_err = ele.getWebElement("XPATH", SRPersonaldetailsObject.limiterror).getText();
						Assert.assertEquals(limit_err, maxminklimit);
						System.out.println(limit_err);
					}
				}

				catch (TimeoutException e) {
					getScreenshot("SR-Primarycontactname", driver);
					System.err.println("SR-Primarycontactname test case failed");
				}
				Thread.sleep(2000);
			}
		}
	}

	// ******************* Validation of Emailid Field ********************//
	public void verifyemail() throws IOException, InterruptedException {
		String filepath = "./TestData/SR_Functional.xlsx";
		FileInputStream inputstream = new FileInputStream(filepath);

		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = workbook.getSheet("Email");

		int rows = sheet.getLastRowNum();
		int colmn = sheet.getRow(0).getLastCellNum();

		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j <= colmn; j++) {

				ele.getWebElement("XPATH", SRPersonaldetailsObject.Email).clear();
				ele.getWebElement("XPATH", SRPersonaldetailsObject.Email).click();
				ele.getWebElement("XPATH", SRPersonaldetailsObject.Email)
						.sendKeys(sheet.getRow(i).getCell(j++).toString());

				JavascriptExecutor jss = (JavascriptExecutor) driver;
				jss.executeScript("window.scrollBy(0,1000)");
				Thread.sleep(2000);
				ele.getWebElement("XPATH", SRPersonaldetailsObject.proceed).click();
				WebElement text = ele.getWebElement("XPATH", SRPersonaldetailsObject.emailfiledrequirederror);
				Thread.sleep(3);
				try {
					String required = ele.getWebElement("XPATH", SRPersonaldetailsObject.emailfiledrequirederror)
							.getText();

					if (required.equals(requiredfield)) {
						Assert.assertEquals(required, requiredfield);
						System.out.println(required);
					} else {
						Thread.sleep(5);
						String invalidemail_err = ele.getWebElement("XPATH", SRPersonaldetailsObject.Invalidemail)
								.getText();
						Assert.assertEquals(invalidemail_err, invalidemail);
						System.out.println(invalidemail_err);
					}
				} catch (TimeoutException e) {
					getScreenshot("SR-Emailid", driver);
					System.err.println("SR-Emailid test case failed");
				}
				Thread.sleep(2000);
			}
		}
	}

	// ******************* Validation of Verification Code ********************//
	public void verifyverificationcode() throws IOException, InterruptedException {
		Thread.sleep(3000);
		ele.getWebElement("XPATH", SRPersonaldetailsObject.otp).click();
		ele.getWebElement("XPATH", SRPersonaldetailsObject.otp).sendKeys("");
		ele.getWebElement("XPATH", SRPersonaldetailsObject.proceed).click();

		String requiredfield = ele.getWebElement("XPATH", SRPersonaldetailsObject.otpfiledrequirederror).getText();
		if (requiredfield.equals(requiredfield)) {
			Assert.assertTrue(true);
		} else {
			getScreenshot("SR-Verificationcode", driver);
			System.err.println("SR-Verificationcode test case failed");
		}
	}

	// ******************* Validation of Mobile Number ********************//
	public void verifymobilenumber() throws IOException, InterruptedException {
		String filepath = "./TestData/SR_Functional.xlsx";
		FileInputStream inputstream = new FileInputStream(filepath);

		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = workbook.getSheet("Mobilenumber");

		int rows = sheet.getLastRowNum();
		int colmn = sheet.getRow(0).getLastCellNum();

		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j <= colmn; j++) {
				ele.getWebElement("XPATH", SRPersonaldetailsObject.mobilenumber).clear();
				ele.getWebElement("XPATH", SRPersonaldetailsObject.mobilenumber).click();
				ele.getWebElement("XPATH", SRPersonaldetailsObject.mobilenumber)
						.sendKeys(sheet.getRow(i).getCell(j++).toString());
				Thread.sleep(2000);
				ele.getWebElement("XPATH", SRPersonaldetailsObject.proceed).click();
				WebElement text = ele.getWebElement("XPATH", SRPersonaldetailsObject.mobilenumberfiledrequirederror);

				try {
					String required = ele.getWebElement("XPATH", SRPersonaldetailsObject.mobilenumberfiledrequirederror)
							.getText();

					if (required.equals(requiredfield)) {
						Assert.assertEquals(required, requiredfield);
						System.out.println(required);
					} else {
						Thread.sleep(2000);
						String invalidmobile_err = ele
								.getWebElement("XPATH", SRPersonaldetailsObject.invalidmobilenumber).getText();
						Assert.assertEquals(invalidmobile_err, invalidmobilenumber);
						System.out.println(invalidmobile_err);
					}
				} catch (TimeoutException e) {
					getScreenshot("SR-Primary Mobile Number", driver);
					System.err.println("SR-Primary Mobile Number test case failed");
				}
				Thread.sleep(2000);
			}
		}
	}

	// ******************* Validation of Password ********************//
	public void verifypassword() throws IOException, InterruptedException {
		String filepath = "./TestData/SR_Functional.xlsx";
		FileInputStream inputstream = new FileInputStream(filepath);

		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = workbook.getSheet("password");

		int rows = sheet.getLastRowNum();
		int colmn = sheet.getRow(0).getLastCellNum();

		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j <= colmn; j++) {
				ele.getWebElement("XPATH", SRPersonaldetailsObject.password).clear();
				ele.getWebElement("XPATH", SRPersonaldetailsObject.password).click();
				ele.getWebElement("XPATH", SRPersonaldetailsObject.password)
						.sendKeys(sheet.getRow(i).getCell(j++).toString());
				Thread.sleep(2000);
				ele.getWebElement("XPATH", SRPersonaldetailsObject.proceed).click();
				WebElement text = ele.getWebElement("XPATH", SRPersonaldetailsObject.passwordfieldrequirederror);

				try {
					String required = ele.getWebElement("XPATH", SRPersonaldetailsObject.passwordfieldrequirederror)
							.getText();

					if (required.equals(requiredfield)) {
						Assert.assertEquals(required, requiredfield);
						System.out.println(required);
					} else {
						String Passwordlimit = ele.getWebElement("XPATH", SRPersonaldetailsObject.passworderror)
								.getText();
						Assert.assertEquals(Passwordlimit, passwordlimit);
						System.out.println(Passwordlimit);
					}
				} catch (TimeoutException e) {
					getScreenshot("SR-Password", driver);
					System.err.println("SR-Password test case failed");
				}
				Thread.sleep(2000);
			}
		}
	}

	// ******************* Validation of Confirm Password ********************//
	public void verifyconfirmpassword() throws IOException, InterruptedException {
		String filepath = "./TestData/SR_Functional.xlsx";
		FileInputStream inputstream = new FileInputStream(filepath);

		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = workbook.getSheet("Confirmpassword");

		int rows = sheet.getLastRowNum();
		int colmn = sheet.getRow(0).getLastCellNum();

		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j <= colmn; j++) {
				ele.getWebElement("XPATH", SRPersonaldetailsObject.confirmpassword).clear();
				ele.getWebElement("XPATH", SRPersonaldetailsObject.confirmpassword).click();
				ele.getWebElement("XPATH", SRPersonaldetailsObject.confirmpassword)
						.sendKeys(sheet.getRow(i).getCell(j++).toString());
				Thread.sleep(2000);
				ele.getWebElement("XPATH", SRPersonaldetailsObject.proceed).click();
				WebElement text = ele.getWebElement("XPATH", SRPersonaldetailsObject.confirmpasswordrequirederror);

				try {
					String required = ele.getWebElement("XPATH", SRPersonaldetailsObject.confirmpasswordrequirederror)
							.getText();

					if (required.equals(requiredfield)) {
						Assert.assertEquals(required, requiredfield);
						System.out.println(required);
					} else {
						String Samepassword = ele.getWebElement("XPATH", SRPersonaldetailsObject.samepassword_error)
								.getText();
						Assert.assertEquals(Samepassword, samepassword);
						System.out.println(Samepassword);
					}
				} catch (TimeoutException e) {
					getScreenshot("SR-Confirm Password", driver);
					System.err.println("SR-Confirm Password test case failed");
				}
				Thread.sleep(2000);
			}}}
	
	//************************Personal Details -Verify All type of pop-up******************************************//
	public void verifyalltypeofpopup() throws IOException, InterruptedException {
		// ******************** Scroll *****************//
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);  

		ele.getWebElement("XPATH", SRPersonaldetailsObject.registerhere).click();			
		String filepath = "./TestData/SR_Functional.xlsx";
		FileInputStream inputstream = new FileInputStream(filepath);

		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = workbook.getSheet("PersonalDetailPopupError");

		int rows = sheet.getLastRowNum();
		int colmn = sheet.getRow(0).getLastCellNum();

		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j <= colmn; j++) {
		ele.getWebElement("XPATH", SRPersonaldetailsObject.Primarycontactname).clear();
		ele.getWebElement("XPATH", SRPersonaldetailsObject.Primarycontactname).sendKeys(sheet.getRow(i).getCell(j++).toString());
		ele.getWebElement("XPATH", SRPersonaldetailsObject.Email).clear();
		ele.getWebElement("XPATH", SRPersonaldetailsObject.Email).sendKeys(sheet.getRow(i).getCell(j++).toString());
		ele.getWebElement("XPATH", SRPersonaldetailsObject.generatecodelink).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele.getWebElement("XPATH", SRPersonaldetailsObject.confirmationcode)));
		ele.getWebElement("XPATH", SRPersonaldetailsObject.otp).clear();
		ele.getWebElement("XPATH", SRPersonaldetailsObject.otp).sendKeys(sheet.getRow(i).getCell(j++).toString());
		js.executeScript("window.scrollBy(0,250)");
		wait.until(ExpectedConditions.visibilityOf(ele.getWebElement("XPATH", SRPersonaldetailsObject.proceed)));
		ele.getWebElement("XPATH", SRPersonaldetailsObject.mobilenumber).clear();
		ele.getWebElement("XPATH", SRPersonaldetailsObject.mobilenumber).sendKeys(sheet.getRow(i).getCell(j++).toString());
		ele.getWebElement("XPATH", SRPersonaldetailsObject.password).clear();
		ele.getWebElement("XPATH", SRPersonaldetailsObject.password).sendKeys(sheet.getRow(i).getCell(j++).toString());
		ele.getWebElement("XPATH", SRPersonaldetailsObject.confirmpassword).clear();
		ele.getWebElement("XPATH", SRPersonaldetailsObject.confirmpassword).sendKeys(sheet.getRow(i).getCell(j++).toString());
		ele.getWebElement("XPATH", SRPersonaldetailsObject.confirmpassword).click();
		ele.getWebElement("XPATH", SRPersonaldetailsObject.proceed).click();
		
		wait.until(ExpectedConditions.visibilityOf(ele.getWebElement("XPATH", SRPersonaldetailsObject.okbutton)));
		if(ele.getWebElement("XPATH", SRPersonaldetailsObject.popup).isDisplayed()) {
			String popup = ele.getWebElement("XPATH", SRPersonaldetailsObject.popup).getText();
			
			//******************************Invalid verification code Pop-up*******************************************//
			if(popup.equals("Invalid verification code")){ 
				Assert.assertTrue(true);
				System.out.println(ele.getWebElement("XPATH", SRPersonaldetailsObject.popup).getText());
			}
			//*******************************Phone number Already Registered Pop-up****************************************//
			else if(popup.equals("Mobile number of user has already been taken")) {
				Assert.assertTrue(true);
				System.out.println(ele.getWebElement("XPATH", SRPersonaldetailsObject.popup).getText()); 
			}}
			else {
				getScreenshot("Personal Details Page Pop-up mesages", driver);
				System.err.println("Personal Details Page Pop-up test case failed");
			}
			ele.getWebElement("XPATH", SRPersonaldetailsObject.okbutton).click();
			wait.until(ExpectedConditions.visibilityOf(ele.getWebElement("XPATH", SRPersonaldetailsObject.proceed)));
		}}}
	//*************************Verify Email Registered Pop-up*****************************//
	public void verifyregisteredemailpopup() throws IOException, InterruptedException {
		ele.getWebElement("XPATH", SRPersonaldetailsObject.Email).clear();
		ele.getWebElement("XPATH", SRPersonaldetailsObject.Email).sendKeys("suraj.k@antino.io");
		ele.getWebElement("XPATH", SRPersonaldetailsObject.generatecodelink).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele.getWebElement("XPATH", SRPersonaldetailsObject.okbutton)));
		if(ele.getWebElement("XPATH", SRPersonaldetailsObject.popup).isDisplayed()) {
			Assert.assertEquals(ele.getWebElement("XPATH", SRPersonaldetailsObject.popup).getText(), "User exists already");
			System.out.println(ele.getWebElement("XPATH", SRPersonaldetailsObject.popup).getText());
		}
		else {
			getScreenshot("User exists already Pop-up mesages", driver);
			System.err.println("User exists already Pop-up test case failed");
		}} 
	
}
