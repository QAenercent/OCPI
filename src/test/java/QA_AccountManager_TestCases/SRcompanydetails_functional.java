package QA_AccountManager_TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.BaseTest;
import PageEvent.SRCompanydetailsFunctional;

public class SRcompanydetails_functional extends BaseTest {

	SRCompanydetailsFunctional sr = new SRCompanydetailsFunctional();
	
	@Test
	public void VerifyalltypeofCompanydetail_errors() throws InterruptedException, IOException {
		sr.enterpersonaldetails();
		sr.verifycomapnynamefield();
		sr.verifycompanyemailid();
		sr.verifycompanyaddress();
		sr.companyphonenumber();
		sr.verifypincode();
	}
}
