package QA_AccountManager_TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.BaseTest;
import PageEvent.ForgotPassword_functional;
import Utils.ElementFetch;

public class Forgotpassword_functional extends BaseTest {

	ElementFetch ele = new ElementFetch();
	ForgotPassword_functional forgot = new ForgotPassword_functional();

	@Test(priority = 1)
	public void forgotpasspage() {

		forgot.verifyifloginpageisloaded();
	}

	@Test(priority = 2)
	public void validate_toast() throws InterruptedException, IOException {

		forgot.validatealltypeof_toast();
	}
}
