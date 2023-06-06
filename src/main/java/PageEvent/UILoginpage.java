package PageEvent;

import Base.BaseTest;
import PageObjects.UILoginpageobject;
import Utils.ElementFetch;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
public class UILoginpage extends BaseTest{

	ElementFetch ele = new ElementFetch();
	 
	public void UIvalidationofloginpage() {
		String email = ele.getWebElement("XPATH", UILoginpageobject.Email).getAttribute("placeholder");
		System.err.println(email);
		String Actualemail = "Enter your email";
		Assert.assertEquals(email, Actualemail);
	}
	
	//************************* Title validation **********************//
	public void verifytitle() throws IOException {
		String Title = driver.getTitle();
		System.out.println(Title);
		String Actualtitle = "Login";
		boolean T = Title.equals(Actualtitle);
		if(T == true) {
			Assert.assertTrue(T);
			System.out.println("Title is proper");
		}
		else {
			getScreenshot("title",driver);
			System.out.println("Title is Not proper");
		}
	}
	
	//************************* Logo's validation **********************//
	public void verifylogoimages() throws IOException {
		
		boolean logoPresent1 = driver.findElement(By.xpath("//img[@alt='Truepowerlogo']")).isDisplayed();		//Title_logo
		if(logoPresent1 == true) {
		Assert.assertTrue(logoPresent1);
		System.out.println("Logo1 is proper");
		}
		else {
			getScreenshot("Logo1",driver);
			System.out.println("Logo1 is Not proper");
		}
		boolean logoPresent2 = driver.findElement(By.xpath("//img[@alt='logo']")).isDisplayed();	
		if(logoPresent2 == true) {
			Assert.assertTrue(logoPresent2);
			System.out.println("Logo2 is proper");
			}
			else {
				getScreenshot("Logo2",driver);
				System.out.println("Logo2 is Not proper");
			}//Login_logo
	}
	
	//************************* Validation of logo's background color **********************//
	public void verifylogobgcolor() throws IOException {
		String color = driver.findElement(By.xpath("//div[@class='header-wrap']")).getCssValue("background-color");
		String hex = Color.fromString(color).asHex();
		System.out.println(hex);
		String Actual_hex = "#007fad";
		//Assert.assertEquals(Actual_hex, hex);
		
		if(hex.equals(Actual_hex)) {
			System.out.println("BG color is proper");
		}
		else {
			getScreenshot("Logo-bg-color",driver);
			System.out.println("Logo-bg-color is Not proper");
		}
	}
	
	//******************** heading 1 validation *******************//
	public void verifyheadline1() throws IOException { 
	String headline_1 = driver.findElement(By.xpath("//div[@class='style_heading3__tH0h3']")).getText();
	System.out.println(headline_1);
	String Actualtext = "Roaming Partner Portal";
	if(Actualtext.equals(headline_1) ) {
		Assert.assertTrue(true);
	}
	else {
		getScreenshot("Headline1",driver);
		System.out.println("Headline1 is not proper");
			}
	}	
	
	//****************** sub heading Validation *******************//
	public void sub_heading() throws IOException {
	String subheadline_1 = driver.findElement(By.xpath("//p[contains(text(),'Please enter ')]")).getText();
	String Actualtext1 = "Please enter your details to access your eMSP account";
	
	if(Actualtext1.equals(subheadline_1)) {
		Assert.assertTrue(true);
	}
	else {
		getScreenshot("Subheadline",driver);
		System.out.println("Subheadline is not proper");
	}
	}
	
	//****************** Email Validation ************************//
	public void emailvalidation() throws IOException {
		String email = driver.findElement(By.xpath("//p[normalize-space()='Email']")).getText();
		String Actualemailtext = "Email";
		if(Actualemailtext.equals(email)) {
			Assert.assertTrue(true);
		}
		else {
			getScreenshot("Email",driver);
			System.out.println("Email is not proper");
		}
	}
	
	//****************** Email click-able Validation ************************//
	public void validateemailclickable() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable (By.xpath("//input[@placeholder='Enter your email']")));
			System.out.println("Email is clickable");
		}
		catch(TimeoutException e) {
			System.out.println("Email Not is clickable");
		}
		}
	
	//****************** Password Validation ************************//
	public void passwordvalidation() throws IOException {
		String password = driver.findElement(By.xpath("//p[normalize-space()='Password']")).getText();
		String Actualpasswordtext = "Password";
		if(Actualpasswordtext.equals(Actualpasswordtext)) {
			Assert.assertTrue(true);
		}
		else {
			getScreenshot("Email",driver);
			System.out.println("Email is not proper");
		}	
		String Pass = driver.findElement(By.xpath("//p[normalize-space()='Password']")).getAttribute("placeholder");
		String Actual_pass = "Enter your password";
		if(Actual_pass.equals(Pass)) {
			Assert.assertTrue(true);
		}
		else {
			getScreenshot("Password",driver);
			System.out.println("Password Placeholder is not proper");
		}
		
	}
	
	//****************** Password click-able Validation ************************//
	public void validatepasswordclickable() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable (By.xpath("//img[@alt='show/hide passsword']")));
			System.out.println("Password is clickable");
		}
		catch(TimeoutException e) {
			System.out.println("Password Not is clickable");
		}
		}
	
	//**************************** Eye Button Validation ********************************//
	public void validationofeyebutton() throws IOException {
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable (By.xpath("//img[@alt='show/hide passsword']")));
		driver.findElement(By.xpath("//img[@alt='show/hide passsword']")).click();
		String pass = driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).getAttribute("value");
		System.err.println(pass);
		}
		catch(TimeoutException e) {
			getScreenshot("EyeButton",driver);
			System.out.println("EyeButton is not proper");
		}
	}
	
	//************************** Forget Password Link *********************************//
	public void validateforgetpasswordlink() throws InterruptedException, IOException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable (By.xpath("//p[@class='style_forgotPasswordPara__1XcgL']")));
			driver.findElement(By.xpath("//p[@class='style_forgotPasswordPara__1XcgL']")).click();
			Thread.sleep(10);
			String validation_text = driver.findElement(By.xpath("//*[contains(text(), 'No worries')]")).getText();
			System.err.println(validation_text);
			String actualtext = "No worries, we will send you the reset instructions";
			if(actualtext.equals(validation_text)) {
				Assert.assertTrue(true);
			}
			else {
				getScreenshot("Forget-password-link",driver);
				System.out.println("Forget-password-link is not proper");
				}
		}
		
		catch(TimeoutException e) {	
		}
		}
	
	//****************************** Check Box *******************************//
	public void validatecheckbox() {
		WebElement Checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		boolean isSelected = Checkbox.isSelected();
			if(isSelected == false) {
				Checkbox.click();
			}
	}
	
	//****************************** Login Button ***************************//
	//****************** Validate if login button is Enabled and Displayed ****************//
	public void Loginenableddisabled() throws IOException {
		WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
		boolean isDisplayed = login.isDisplayed();
		if(login.isDisplayed() && login.isEnabled() == true) {
			System.err.println("Login is Displayed and Enabled");
		}
		else {
			getScreenshot("Check-box",driver);
			System.out.println("Check-box is not proper");
		}
		//****************** Validate Color of login button ****************//
		String color_login = driver.findElement(By.xpath("//input[@value='Login']")).getCssValue("background-color");
		System.out.println(color_login);
		String hex1 = Color.fromString(color_login).asHex();
		System.err.println(hex1);
		String Actual_hex = "#1e2329";
		if(Actual_hex.equals(hex1)) {
			Assert.assertTrue(true);
		}
		else {
			getScreenshot("Login Button",driver);
			System.out.println("Login Button color is not proper");
		}
	}
	
	//****************** Register here text Validation ***********************//
	public void registertextvalidation() throws IOException {
		String Text = driver.findElement(By.xpath("//span[normalize-space()='Want to become a Roaming Provider?']")).getText();
		String Actual_text = "Want to become a Roaming Provider?";
		if(Actual_text.equals(Text)) {
			Assert.assertTrue(true);
		}
		else {
			getScreenshot("Registerhere text",driver);
			System.out.println("Register here text is not proper");
		}
	}
	
	//****************** Register here link validation ***********************//
		public void registerherelinkvalidation() throws IOException, InterruptedException {
		String Register_link = driver.findElement(By.xpath("//span[@class='tp-underline tp-cursor-pointer tp-light-text']")).getText();
		String actualtext = "Register Here";
		if(actualtext.equals(Register_link)) {
			Assert.assertTrue(true);
		} 
		else {
			getScreenshot("Registerhere Link",driver);
			System.out.println("Register here Link text is not proper");
			}
		driver.navigate().back();
		}
		
		public void validateregisterheretext() throws IOException, InterruptedException {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.elementToBeClickable (By.xpath("//span[@class='tp-underline tp-cursor-pointer tp-light-text']")));
				driver.findElement(By.xpath("//span[@class='tp-underline tp-cursor-pointer tp-light-text']")).click();
				Thread.sleep(3);
				String validate_text = driver.findElement(By.xpath("//h4[normalize-space()='Become a Roaming Provider']")).getText();
				String text = "Become a Roaming Provider";
				
				if(text.equals(validate_text)) {
					Assert.assertTrue(true);
				}
				else {
					getScreenshot("Register_here_Link",driver);
					System.out.println("Register here Link is not proper");
				}
			}
			catch(TimeoutException e) {
				System.out.println("");
				}
			driver.navigate().back();
			
			//*********************** Scroll Down *****************************//
			WebElement Element1 = driver.findElement(By.xpath("//img[@alt='jio-Things']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", Element1);
			}
		//*********************** Validation of Footer ******************//
		public void footer() {
			WebElement footer = driver.findElement(By.xpath("//img[@alt='jio-Things']"));
				boolean isDisplayed = footer.isDisplayed();
				if(isDisplayed == true) {
					System.err.println("Fotter is visible");
				}
		}
}
		
			


