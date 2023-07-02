package PageObjects;

public interface SRBankingDetailsObject {

	//Account Holder Name Field
	String accountholdername = "//*[@name='holder_name']";
	String accountnamelimit_error = "//*[text()='Holder name must be between 3 and 25 characters']";
	String accountnamerequired_error = "//*[@name='holder_name']//following-sibling::span";
	
	//Account Number Field
	String accountnumber = "//*[@name='account_number']";
	String accountnumberlimit_error = "//*[text()='Account number must be between 6 and 18 digits']";
	String accounnumberrequired_error = "//*[@name='account_number']//following-sibling::span";
	
	//Confirm Account Number Field
	String confirmaccountnumber = "//*[@name='confirm_account_number']";
	String confirmaccountnumber_error = "//*[text()='Account number and confirm account number should be same']";
	String confirmaccountrequired_error = "//*[@name='confirm_account_number']//following-sibling::span";
	
	//Select Bank 
	String selectbank = "//*[@class='select-picker__input']";
	
	//IFSC Code Field
	String ifsccode = "//*[@name='ifsc_code']";
	String invalidifsccode_error = "//*[text()='Invalid IFSC code eg : SBIN0125620']";
	String ifsccoderequired_error = "//*[@name='ifsc_code']//following-sibling::span";
	
	//Add File 
	String addfile = "//*[text()='+ Add File']";
	String addfilerequired_error = "//*[text()='*Image size should be less than or equal to 250 KB']//following-sibling::span";
	
	// Pop-Up
	String popup = "//*[@style='text-align: center;']";
	String okbutton = "//*[text()='Ok']";
	String proceed = "//button[contains(text(),'Proceed')]";
	String backbutton = "//button[contains(text(),'Back')]";
	String deletebutton = "//*[@aria-label='delete']";
	
}
