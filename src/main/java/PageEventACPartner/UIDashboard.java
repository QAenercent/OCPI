package PageEventACPartner;

import java.io.IOException;

import org.testng.Assert;

import Base.BaseTest;
import PageObjectsACPartner.UIDashboardObject;
import Utils.ElementFetch;

public class UIDashboard extends BaseTest {
	ElementFetch ele = new ElementFetch();

	// ************************Verify Page Title*********************//
	public void verifytitle() throws IOException, InterruptedException {
		Thread.sleep(1000);
		String Title = driver.getTitle();
		System.out.println(Title);
		String Actualtitle = "Electric Vehicle Chargers | EV Charging Stations | End-to-End EV Charging Solutions | TruePower by JioThings | India";
		boolean T = Title.equals(Actualtitle);
		if (T == true) {
			Assert.assertTrue(T);
			System.out.println("Title is proper");
		} else {
			getScreenshot("title", driver);
			System.out.println("Title is Not proper");
		}

	}

	// **************************Verify Headline*******************//
	public void verifyheadline() throws IOException {
		String headline = ele.getWebElement("XPATH", UIDashboardObject.headline).getText();
		String actualheadline = "OCPI Accounts (eMSP / Roaming) Summary";
		boolean T = headline.equals(actualheadline);
		if (T == true) {
			Assert.assertTrue(T);
			System.out.println("Headline is proper");
		} else {
			getScreenshot("title", driver);
			System.out.println("Headline is Not proper");
		}

		// ***************************verify Till date*******************//
		String tilldate = ele.getWebElement("XPATH", UIDashboardObject.tilldate).getText();
		String actualtilldate = "Till Date";
		boolean T1 = tilldate.equals(actualtilldate);
		if (T1 == true) {
			Assert.assertTrue(T1);
			System.out.println("Till date is proper");
		} else {
			getScreenshot("title", driver);
			System.out.println("Till date is Not proper");
		}
	}

	// ***************************verify Total Accounts Tiles
	// ***************************//
	public void verifytotalaccounttiles() throws IOException {
		String headline = ele.getWebElement("XPATH", UIDashboardObject.totalaccount_headline).getText();
		String actualheadline = "Total Accounts";
		boolean T = headline.equals(actualheadline);
		if (T == true) {
			Assert.assertTrue(T);
			System.out.println("Total Account Headline is proper");
		} else {
			getScreenshot("title", driver);
			System.out.println("Total Account Headline is Not proper");
		}

		// **********************verify Total Account
		// Sub-Headline******************************//
		String subheadline = ele.getWebElement("XPATH", UIDashboardObject.totalaccount_headline).getText();
		String actualsubheadline = "Total Accounts";
		boolean T1 = subheadline.equals(actualsubheadline);
		if (T1 == true) {
			Assert.assertTrue(T1);
			System.out.println("Total Account Headline is proper");
		} else {
			getScreenshot("title", driver);
			System.out.println("Total Account Headline is Not proper");
		}
		// ************************Verify Total Account
		// count**************************//
		String accountcount = ele.getWebElement("XPATH", UIDashboardObject.totalaccount_count).getText();
		System.out.println(accountcount);
	}
}
