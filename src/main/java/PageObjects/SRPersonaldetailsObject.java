package PageObjects;

public interface SRPersonaldetailsObject {

	// Primary contact name
	String registerhere = "//span[contains(text(),'Register Here')]";
	String Primarycontactname = "//input[@class='input-field-wrap' and @name='name']";
	String namefieldrequirederror = "//*[@name='name']//following-sibling::span";
	String proceed = "//button[contains(text(),'Proceed')]";
	String limiterror = "//*[contains(text(),'Primary contact')]";

	// Email
	String Invalidemail = "//span[contains(text(),'Invalid email address')]";
	String emailfiledrequirederror = "//*[@name='email']//following-sibling::span";
	String Email = "//input[@name='email']";
	String generatecodelink = "//*[text()='Generate code to verify']";
	String confirmationcode = "//*[contains(text(),'Confirmation code ')]";

	// Verification code
	String otp = "//*[@name='otp']";
	String otpfiledrequirederror = "//*[@name='otp']//following-sibling::span";

	// Primary mobile number
	String mobilenumber = "//*[@name='mobile']";
	String mobilenumberfiledrequirederror = "//*[@name='mobile']//following-sibling::span";
	String invalidmobilenumber = "//*[text()='Invalid phone number']";

	// Password fiels
	String password = "//*[@name='password']";
	String passworderror = "//*[text()='Password must be have 6 characters']";
	String passwordfieldrequirederror = "//*[@name='password']//following-sibling::span";

	// Confirm Password
	String confirmpasswordrequirederror = "//*[@name='confirmPassword']//following-sibling::span";
	String confirmpassword = "//*[@name='confirmPassword']";
	String samepassword_error = "//*[text()='Password and confirm password should be same']";
	
	//popup
	String popup = "//*[@style='text-align: center;']";
	String okbutton = "//*[text()='Ok']";

}
