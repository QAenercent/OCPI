package QA_AccountManager_TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.BaseTest;
import PageEvent.SRPersonaldetailsFunctional;
import Utils.ElementFetch;

public class SRpersonaldetials extends BaseTest {

	ElementFetch ele = new ElementFetch();
	SRPersonaldetailsFunctional sr = new SRPersonaldetailsFunctional();

	@Test
	public void verifycompanydetails() throws IOException, InterruptedException {
		sr.verificationofcompanydetails();
		sr.verifyemail();
		sr.verifyverificationcode();
		sr.verifymobilenumber();
		sr.verifypassword();
		sr.verifyconfirmpassword();
		sr.verifyalltypeofpopup();
		sr.verifyregisteredemailpopup();
	}
}
