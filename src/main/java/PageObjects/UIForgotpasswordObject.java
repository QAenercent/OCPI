package PageObjects;

public interface UIForgotpasswordObject {

	String forgotpassheadline = "//p[contains(text(),'No worries, we will send you the reset instruction')]";
	String noworriesline = "//*[contains(text(), 'No worries')]";
	String emailtitle = "//p[normalize-space()='Email']";
	String email = "//input[@placeholder='Enter your email']";
	String backtologin = "//div[contains(text(),'Back to Login')]";
	String resetpassword = "//input[@value='Reset Password']";
	String footer = "//img[@alt='jio-Things']";
	String forgotpasswordlink = "//*[text()='Forgot Your Password?']";

}
