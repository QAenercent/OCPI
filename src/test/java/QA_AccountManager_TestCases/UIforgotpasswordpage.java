package QA_AccountManager_TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.BaseTest;
import PageEvent.UIForgotpasswordpage;
import Utils.ElementFetch;

public class UIforgotpasswordpage extends BaseTest{
	ElementFetch ele = new ElementFetch();
	UIForgotpasswordpage forgotpass = new UIForgotpasswordpage();
	
	@Test
	public void verifyuiforgotpasswordpage() throws IOException, InterruptedException {
		forgotpass.verifyheadline1();
		forgotpass.verifysubheading();
		forgotpass.verifyemailheadline();
		forgotpass.verifyemailplaceholder();
		forgotpass.verifyresetpassword();
		forgotpass.verifybacktologin();
		forgotpass.verifyfooter(); 
		
	}}
	


