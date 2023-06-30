package QA_AccountManager_TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.BaseTest;
import PageEvent.SRCompanydetailsFunctional;
import Utils.ElementFetch;

public class SRcompanydetials extends BaseTest {

	ElementFetch ele = new ElementFetch();
	SRCompanydetailsFunctional sr = new SRCompanydetailsFunctional();

	@Test
	public void verifycompanydetails() throws IOException, InterruptedException {
		sr.verificationofcompanydetails();
		sr.verifyemail();
		sr.verifyverificationcode();
		sr.verifymobilenumber();
		sr.verifypassword();
		sr.verifyconfirmpassword();
	}
}
