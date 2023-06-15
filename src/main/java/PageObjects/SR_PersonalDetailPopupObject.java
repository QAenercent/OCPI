package PageObjects;

public interface SR_PersonalDetailPopupObject {

	String emailexists = "//*[text()='User exists already']";
	String invalidotp = "//*[text()='Invalid verification code']";
	String mobilenumberexists = "//*[text()='Mobile number of user has already been taken']";
	String okbutton = "//*[text()='Ok']";
	String confirmcodelink = "//*[text()='Confirmation code has been sent successfully']";
	String emailpopuperror = "User exists already";
	String mobilenumberpopuperror = "Mobile number of user has already been taken";
	String otppopuperror = "Invalid verification code";
	String popup = "//*[@style='text-align: center;']//text()";
	String generateotplink = "//*[text()='Generate code to verify']";
}
