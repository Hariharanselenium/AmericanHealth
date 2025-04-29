package com.thinktimetechno.projects.website.Multipages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.thinktimetechno.keywords.WebUI;

public class CorporateRegistrationPage {

	public void Group_Registration_page_validation() {

		WebUI.verifyPageTitleContains("Groupdiscount - American Health Care Academy");

	}

	public void not_group_dashboard_page_validation() {

		Assert.assertNotEquals(WebUI.getPageTitle(), "Dashboard - American Health Care Academy");

	}

	public void error_validation(String error) {

		String error_message = WebUI
				.waitForElementVisible(
						By.xpath("//form[@id='form_groupdiscount']/descendant::div[@id='error_message_dv2']"))
				.getText();
		Assert.assertEquals(error_message, error);

	}

	public void exiting_account_validation(String error) {

		String error_message = WebUI.waitForElementVisible(By.xpath("(//form[@id='form_groupdiscount']/descendant::div[@class='error_msg'])[2]")).getText();
		Assert.assertEquals(error_message, error);

	}

	public void click_register() throws InterruptedException {

		WebUI.clickElementWithJs(By.xpath("//button[@id='select_course']"));
	}

	public void click_terms_conditions() {
		WebUI.clickElement(By.xpath("//input[@id='opt_in_button']"));

	}

	public void enter_registration_details(String firstName, String lastname, String companyname, String phonenumber,
			String emailaddress, String createpassword, String confirmpassword) {
		String dateTime = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		String emailAddress = emailaddress.replace("john.doe", "john.doe" + dateTime);

		String Companyname = companyname.replace("Thinktime", "Thinktime" + dateTime);

		WebUI.setText(By.xpath("//input[@id='first_name']"), firstName);
		WebUI.setText(By.xpath("//input[@id='last_name']"), lastname);
		WebUI.setText(By.xpath("//input[@id='company']"), Companyname);
		WebUI.clickElement(By.xpath("//input[@id='phone_number']"));
		WebUI.setText(By.xpath("//input[@id='phone_number']"), phonenumber);
		WebUI.setText(By.xpath("//input[@id='email_address']"), emailAddress);
		WebUI.setText(By.xpath("//input[@id='password-cop']"), createpassword);
		WebUI.setText(By.xpath("//input[@id='password2-cop']"), confirmpassword);

	}

	public void enter_registration_details_BLANK(String firstName, String lastname, String companyname,
			String phonenumber, String emailaddress, String createpassword, String confirmpassword) {
		String dateTime = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		String emailAddress = emailaddress.replace("john.doe", "john.doe" + dateTime);

		String Companyname = companyname.replace("Thinktime", "Thinktime" + dateTime);

		WebUI.setText(By.xpath("//input[@id='first_name']"), firstName);
		WebUI.setText(By.xpath("//input[@id='last_name']"), lastname);
		WebUI.setText(By.xpath("//input[@id='company']"), Companyname);
		WebUI.setText(By.xpath("//input[@id='phone_number']"), phonenumber);
		WebUI.setText(By.xpath("//input[@id='email_address']"), emailAddress);
		WebUI.setText(By.xpath("//input[@id='password-cop']"), createpassword);
		WebUI.setText(By.xpath("//input[@id='password2-cop']"), confirmpassword);

	}

	public void enter_existing_registration_detail(String firstName, String lastname, String companyname,
			String phonenumber, String emailaddress, String createpassword, String confirmpassword) {

		WebUI.setText(By.xpath("//input[@id='first_name']"), firstName);
		WebUI.setText(By.xpath("//input[@id='last_name']"), lastname);
		WebUI.setText(By.xpath("//input[@id='company']"), companyname);
		WebUI.setText(By.xpath("//input[@id='phone_number']"), phonenumber);
		WebUI.setText(By.xpath("//input[@id='email_address']"), emailaddress);
		WebUI.setText(By.xpath("//input[@id='password-cop']"), createpassword);
		WebUI.setText(By.xpath("//input[@id='password2-cop']"), confirmpassword);

	}

	public void Registration_page_validation() {
		String PageTitle = WebUI.getPageTitle();
		Assert.assertEquals(PageTitle, "Register - American Health Care Academy");
	}

	public void Groupdiscount_page_validation() {
		String PageTitle = WebUI.getPageTitle();
		Assert.assertEquals(PageTitle, "Groupdiscount - American Health Care Academy");
	}

	public void error_validation() throws InterruptedException {
		WebElement firstNameField = WebUI.getWebElement(By.name("first_name"));

		String fieldValue = firstNameField.getAttribute("value");

		if (fieldValue == null || fieldValue.trim().isEmpty()) {
			System.out.println("=== The First Name field is empty ===");
		} else {
			System.out.println("=== The First Name field contains: === " + fieldValue);
		}
	}

	public void error_validation_existing_account() {
		String PageTitle = WebUI.getPageTitle();
		Assert.assertEquals(PageTitle, "Register - American Health Care Academy");
	}

	public void enter_registration_detail(String firstName, String lastname, String phonenumber, String emailaddress,
			String username, String password, String confirmpassword) {
		String dateTime = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		String emailAddress = emailaddress.replace("john.doe", "john.doe" + dateTime);

		String Username = username.replace("johndoe", "johndoe" + dateTime);

		WebUI.setText(By.xpath("//input[@id='first_name']"), firstName);

		WebUI.setText(By.xpath("//input[@id='last_name']"), lastname);
		WebUI.setText(By.xpath("//input[@id='phone_number']"), phonenumber);

		WebUI.setText(By.xpath("//input[@id='email_address']"), emailAddress);

		WebUI.setText(By.xpath("//input[@id='username']"), Username);
		WebUI.setText(By.xpath("//input[@id='password']"), password);
		WebUI.setText(By.xpath("//input[@id='confirm_password']"), confirmpassword);
	}

}
