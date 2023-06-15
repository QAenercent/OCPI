package QA_AccountManager_TestCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import Base.BaseTest;
import PageEvent.LoginPage;
import PageObjects.LoginPageObject;
import Utils.ElementFetch;

public class LoginTest extends BaseTest {

	ElementFetch ele = new ElementFetch();
	LoginPage login = new LoginPage();
	PageEvent.UILoginpage UILoginpage = new PageEvent.UILoginpage();

	@Test(priority = 1)
	public void loginpage() throws InterruptedException {
		login.verifyifloginpageisloaded();
		login.entercredentials();
	}

	@Test(priority = 2)
	public void UIloginpage() throws IOException, InterruptedException {
		UILoginpage.UIvalidationofloginpage();
		UILoginpage.verifytitle();
		UILoginpage.verifylogoimages();
		UILoginpage.verifylogobgcolor();
		UILoginpage.verifyheadline1();
		UILoginpage.sub_heading();
		UILoginpage.emailvalidation();
		UILoginpage.validateemailclickable();
		UILoginpage.validatepasswordclickable();
		UILoginpage.validateforgetpasswordlink();
	}

}
