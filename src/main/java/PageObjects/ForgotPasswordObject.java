package PageObjects;

public interface ForgotPasswordObject {

	String forgotpasslink = "//*[text()='Forgot Your Password?']";
	String email = "//*[@placeholder= 'Enter your email']";
	String resetpassbutton = "//*[@value= 'Reset Password']";
	String backtologin = "//*[text()= 'Back to Login']";
	String minimumlimit_error = "//*[text()= 'Enter min 3 and max 60 characters']";
	String emptyfield_toast = "//*[text()= 'Input field is empty']";
	String Invalidemail_toast = "//*[text()= 'Please enter a Valid Email Address']";
	String emailnotfount_toast = "//*[text()= 'Email Not Found!']";
	String toastframe = "//div[@class='MuiAlert-message css-1xsto0d']";
	String validemail_toast = "//*[text()='You will receive an email with instructions on how to reset your password in a few minutes.']";

}
