package QA_AccountManager_TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.BaseTest;
import PageEvent.SRBankingDetailsFunctional;
import PageEvent.SRCompanydetailsFunctional;

public class SRbankingdetails_functional extends BaseTest {
	SRCompanydetailsFunctional pd = new SRCompanydetailsFunctional();
	SRBankingDetailsFunctional bd = new SRBankingDetailsFunctional();
	
	@Test(priority=1)
	public void Verifyalltypeofbankingdetails_error() throws InterruptedException, IOException {
		pd.enterpersonaldetails();
		bd.entercompanydetails();
		bd.verifyaccountholdername();
		bd.verifyaccountnumber();
		bd.confirmaccountnumber();
		bd.verifyifsccode();
		bd.verifyalltypeofpopup();
	}
}
