package QA_ACPartner_TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.BaseTest;
import PageEvent.LoginPage;
import PageEventACPartner.UIDashboard;
import Utils.ElementFetch;

public class UiDashboard extends BaseTest{
	ElementFetch ele = new ElementFetch();
	LoginPage login = new LoginPage();
	UIDashboard dashboard = new UIDashboard();
	
	@Test
	public void login() throws InterruptedException, IOException {
		login.entercredentials();
		dashboard.verifytitle();
	}
	
	 
	

}
