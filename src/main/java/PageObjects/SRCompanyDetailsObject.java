package PageObjects;

public interface SRCompanyDetailsObject {

	//Company Name
	String companyname = "//*[@name='company_name']";
	String companynamelimit_error = "//*[text()='Company name must be between 3 and 35 characters']";
	String companynamedrequired_error = "//*[@name='company_name']//following-sibling::span";
	String proceed = "//button[contains(text(),'Proceed')]";
	
	//Company Phone Number
	String companyphonenumber = "//*[@name='phone_number']";
	String phonenumberlimit_error = "//*[text()='Invalid phone number']";
	String phonenumberrequired_error = "//*[@name='phone_number']//following-sibling::span";
	
	//Email Address
	String email = "//*[@name='email_address']";
	String invalidemail_error = "//*[text()='Invalid email address']";
	String emailrequired_error = "//*[@name='email_address']//following-sibling::span";
	
	//Company Address
	String companyaddress = "//*[@name='company_address']";
	String companyaddresslimit_error = "//*[contains(text(),'Company address must ')]";
	String addressrequired_error = "//*[@name='company_address']//following-sibling::span";
	
	//State
	String staterequired_error = "(//*[text()='This field is required'])[5]";
	String statedropdown = "(//*[@class='select-picker__input'])[1]"; 
	
	//City
	String cityrequired_error = "(//*[text()='This field is required'])[5]";
	String citydropdown = "(//*[@class='select-picker__input'])[2]";
	
	//Pincode
	String invalidpincode = "//*[text()='Invalid pincode']";
	String pincode = "//*[@name='pincode']";
	String pincoderequired_error = "(//*[text()='This field is required'])[5]";
	String okbutton = "//*[text()='Ok']";
	
	// Pop-Up
	String popup = "//*[@style='text-align: center;']";
	 

}
