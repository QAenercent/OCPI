package PageEvent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.BaseTest;
import PageObjects.ForgotPasswordObject;
import PageObjects.LoginPageObject;
import Utils.ElementFetch;

public class ForgotPassword_functional extends BaseTest {

	String invalid_toast = "Please enter a Valid Email Address";
	String emailnotfount_toast = "Email Not Found!";
	String empty_toast = "Input field is empty";
	String validemail_toast = "You will receive an email with instructions on how to reset your password in a few minutes.";
	String minandmax_error = "Enter min 3 and max 60 characters";

	ElementFetch ele = new ElementFetch();

	// ******************* Verify ForgotPasword page is loaded
	// ****************************//

	public void verifyifloginpageisloaded() {
		ele.getWebElement("XPATH", ForgotPasswordObject.forgotpasslink).click();
		Assert.assertTrue(ele.getWebElements("XPATH", ForgotPasswordObject.email).size() > 0,
				"Page Not Loaded Properly");
	}

	// ************************** Validate All type of toast
	// ********************************//

	public void validatealltypeof_toast() throws InterruptedException, IOException {

		ele.getWebElement("XPATH", ForgotPasswordObject.forgotpasslink).click();

		String filepath = "./TestData/forgotpass.xlsx";
		FileInputStream inputstream = new FileInputStream(filepath);

		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = workbook.getSheet("Emailid");

		int rows = sheet.getLastRowNum();
		int colmn = sheet.getRow(0).getLastCellNum();

		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j <= colmn; j++) {

				ele.getWebElement("XPATH", ForgotPasswordObject.email).clear();
				ele.getWebElement("XPATH", ForgotPasswordObject.email)
						.sendKeys(sheet.getRow(i).getCell(j++).toString());
				ele.getWebElement("XPATH", ForgotPasswordObject.resetpassbutton).click();

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait.until(
						ExpectedConditions.visibilityOf(ele.getWebElement("XPATH", ForgotPasswordObject.toastframe)));

				if (ele.getWebElement("XPATH", ForgotPasswordObject.toastframe).isDisplayed()) {

					String text = ele.getWebElement("XPATH", ForgotPasswordObject.toastframe).getText();

					// ******************* Please enter a Valid Email Address Toast
					// *********************//

					if (text.equalsIgnoreCase(invalid_toast)) {
						Assert.assertEquals(text, invalid_toast);
						System.out.println(text);
					}

					// ******************* Email Not Found! Toast *********************//

					else if (text.equalsIgnoreCase(emailnotfount_toast)) {
						Assert.assertEquals(text, emailnotfount_toast);
						System.out.println(text);
					}

					// ******************* Input field is empty Toast *********************//

					else if (text.equalsIgnoreCase(empty_toast)) {
						Assert.assertEquals(text, empty_toast);
						System.out.println(text);
					}

					// ******************* Valid Email id Toast *********************//

					else if (text.equalsIgnoreCase(validemail_toast)) {
						Assert.assertEquals(text, validemail_toast);
						System.out.println(text);
					}

					else {

						getScreenshot("Validate_Toast_ForgotPassword", driver);
						System.err.println("Toast test case failed");
						;
					}

					driver.navigate().refresh();
					Thread.sleep(2);

				}
			}
		}

		// ******************* Validate Minimum & Maximum error Message
		// ****************************//

		ele.getWebElement("XPATH", ForgotPasswordObject.email).sendKeys("a1");
		Thread.sleep(2);

		if (ele.getWebElement("XPATH", ForgotPasswordObject.minimumlimit_error).isDisplayed()) {

			Assert.assertEquals(ele.getWebElement("XPATH", ForgotPasswordObject.minimumlimit_error).getText(),
					minandmax_error);
			System.out.println(ele.getWebElement("XPATH", ForgotPasswordObject.minimumlimit_error).getText());
		}

		else {

			getScreenshot("Validate_error_Forgotpassword", driver);
			System.err.println("Min&max_error test case failed");
		}

		driver.navigate().back();

	}
}
