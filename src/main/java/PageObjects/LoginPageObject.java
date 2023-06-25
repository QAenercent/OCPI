package PageObjects;

public interface LoginPageObject {

	String email = "//input[@placeholder='Enter your email']";
	String password = "//*[@placeholder='Enter your password']";
	String loginbutton = "//*[@class='style_loginButton__1zvIl']";
	String Checkbox = "//*[@type='checkbox']";
	String toastframe= "//div[@class='MuiAlert-message css-1xsto0d']";
	String Logout= "//*[text()='Log Out']";
	String profilename= "//*[@class='profile-name']";
	String roamingprovider= "//*[text()='roaming_provider']";
	String roamingpartner= "//*[text()='roaming_partner']";
	String accountmanager= "//*[text()='account_manager']";
	String headline = "//*[text()='Roaming Partner Portal']";
	String emaillimit_error = "//*[text()='Enter min 3 and max 60 characters']";
	String passwordlimit_error = "//*[text()='Enter min 6 and max 32 characters']";
	String invalidpassword_error = "//*[text()='Invalid Email or Password']";
}
