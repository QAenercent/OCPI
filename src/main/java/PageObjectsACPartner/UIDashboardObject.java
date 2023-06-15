package PageObjectsACPartner;

public interface UIDashboardObject {

	String headline = "//h4[contains(text(),'OCPI')]";
	String tilldate = "//*[text()='Till Date']";
	String totalaccount_headline = "//*[text()='Total Accounts']";
	String totalaccount_subheadline = "//*[text()='No of Roaming Partner Account']";
	String totalaccount_count = "(//span[@style='font-weight: bold; font-size: 25px;'])[1]";
	String totalaccount_image = "//img[@src='/assets/total-revenue.svg']";

}
