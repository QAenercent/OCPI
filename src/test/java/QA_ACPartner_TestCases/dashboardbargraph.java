package QA_ACPartner_TestCases;

import org.testng.annotations.Test;

import Base.BaseTest;
import PageEvent.LoginPage;
import PageEventACPartner.DashboardBargraph;

public class dashboardbargraph extends BaseTest {
	LoginPage login = new LoginPage();
	DashboardBargraph das = new DashboardBargraph();
	@Test
	public void piechart() throws InterruptedException {
		login.entercredentials();
		das.pirchart();
	}

}
