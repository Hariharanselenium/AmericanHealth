package com.thinktimetechno.projects.website.Multipages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.thinktimetechno.driver.DriverManager;
import com.thinktimetechno.keywords.WebUI;

public class CorporateLoginPage {
	String Totalinvoice = null;

	public void goupuser_login_page_validation() {
		String PageTitle = WebUI.getPageTitle();
		Assert.assertEquals(PageTitle, "Login | Groupadmin - American Health Care Academy");
	}

	public void goupuser_purchase_page_validation() {
		String PageTitle = WebUI.getPageTitle();
		Assert.assertEquals(PageTitle, "Invoice | Groupadmin - American Health Care Academy");
	}

	public void Invite_page_validation() {
		Assert.assertTrue(WebUI.getPageTitle().contains("Invite | Groupadmin - American Health Care Academy"));
	}

	public void paymentype_selection() {
		WebUI.clickElement(By.id("s2id_codeauth_pre_paid"));

	}

public void course_selection(int employeeIndex) {
		
		WebUI.waitForPageLoaded();
		
		
		// List<WebElement> courseDropdowns = WebUI.getWebElements(By.xpath("//div[@id='select2-drop']/child::ul/li"));

		    for (int i = 1; i <= employeeIndex; i++) {
		    	 WebUI.waitForElementVisible(By.xpath("(//div[@id='s2id_codeauth_pre_paid'])["+i+"]"));
		    	 WebUI.clickElement(By.xpath("(//div[@id='s2id_codeauth_pre_paid'])["+i+"]"));
		         String dynamicXpath = "//div[@id='select2-drop']/ul/li["+i+1+"]";
		         WebUI.clickElement(By.xpath(dynamicXpath));
		    }

	}

	public void course_selection_01() {WebUI.waitForElementVisible(By.xpath("//div[@id='s2id_codeauth_pre_paid']"));
	 WebUI.clickElement(By.xpath("//div[@id='s2id_codeauth_pre_paid']"));
	  WebUI.clickElement(By.xpath("//div[@id='select2-drop']/child::ul/li[2]"));}

	public void Corporate_login_details(String email, String password) {
		WebUI.setText(By.xpath("//input[@id='email']"), email);
		WebUI.setText(By.xpath("//input[@id='password']"), password);

	}

	public void goupuser_total_invoice_validation() {

		String total_invoice = WebUI.getTextElement(By.xpath("//table[@id='prepaid_code_table']/tbody/tr[1]/td[4]"));
		System.out.println(total_invoice);
		Assert.assertEquals(total_invoice, Totalinvoice);
	}

	public void Corporate_details(String firstName, String lastName, String email, String phone) {

		WebUI.setText(By.xpath("//input[@title='First Name']"), firstName);
		WebUI.setText(By.xpath("//input[@title='Last Name']"), lastName);
		WebUI.setText(By.xpath("//input[@title='Email']"), email);
		WebUI.setText(By.xpath("//input[@title='Phone Number']"), phone);

	}

	public void Corporate_billing_details(String FirstName, String LastName, String Company, String Address,
			String City, String State, String Zip) {
		WebUI.setText(By.xpath("//input[@id='billing_firstname']"), FirstName);
		WebUI.setText(By.xpath("//input[@id='billing_lastname']"), LastName);
		WebUI.setText(By.xpath("//input[@id='company']"), Company);
		WebUI.setText(By.xpath("//input[@id='billing_address']"), Address);
		WebUI.setText(By.xpath("//input[@id='billing_city']"), City);
		WebUI.setText(By.xpath("//select[@id='billing_state']"), State);
		WebUI.setText(By.xpath("//input[@id='billing_zipcode']"), Zip);
	}

	public void Corporate_payment_details(String FullNameonCard, String CardNumber, String ExpirationMonth,
			String ExpirationYear, String CVVCode) {
		WebUI.setText(By.xpath("//input[@id='name_on_card']"), FullNameonCard);
		WebUI.setText(By.xpath("//input[@id='billing_cardno']"), CardNumber);
		WebUI.setText(By.xpath("//input[@id='billing_exp_month']"), ExpirationMonth);
		WebUI.setText(By.xpath("//input[@id='billing_exp_year']"), ExpirationYear);
		WebUI.setText(By.xpath("//input[@id='billing_cvv']"), CVVCode);

	}

	public void verifypayinvoicePageDisplays() {

		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(60));
		wait.until(ExpectedConditions.titleContains("Payinvoicev3 | Groupadmin - American Health Care Academy"));

		Assert.assertTrue(WebUI.verifyPageTitleContains("Payinvoicev3 | Groupadmin - American Health Care Academy"));
	}

	public void verifyalertDisplays(String error) {
		String alerttext = WebUI.alertGetText();
		System.out.println("Alert message:" + alerttext);
		if (alerttext.contains(alerttext)) {
			WebUI.alertAccept();
		}

	}

	public void enter_group_username(String username) {

		WebUI.setText(By.xpath("//input[@placeholder='Username/Email']"), username);
	}

	public void enter_purchasecode(String username) throws InterruptedException {

		WebUI.setText(By.xpath("//input[@id='po_number']"), username);
		Totalinvoice = WebUI.getTextElement(By.xpath("//div[@id='invoice_total']"));

	}

	public void click_invoice_() {

		WebUI.clickElementWithJs(By.xpath("//a[@id='submit-invoice-course']"));
	}

	public void click_sameas_billingaddress() {

		WebUI.clickElementWithJs(By.xpath("//input[@id='same_as_billing']"));
	}

	public void click_nxt() {

		WebUI.clickElementWithJs(By.xpath("//button[contains(text(),'Next')]"));

	}

	public void click_nxt1() {

		WebUI.clickElementWithJs(By.xpath("//button[text()='Next']"));

	}

	public void anotheremployee() {

		WebUI.clickElement(By.xpath("//button[contains(text(),'Invite Another Employee')]"));
		WebUI.clickElement(By.xpath("//button[contains(text(),'Invite Another Employee')]"));
		WebUI.clickElement(By.xpath("//button[contains(text(),'Invite Another Employee')]"));
		WebUI.clickElement(By.xpath("//button[contains(text(),'Invite Another Employee')]"));

	}

	public void msg_validation(String textMsg) {

		Assert.assertTrue(WebUI.getTextElement(By.xpath("//h2[@class='title-invite']")).contains(textMsg));
	}

	public void click_submitpayment() {

		WebUI.clickElementWithJs(By.xpath("(//div[contains(text(),'Submit Payment')])[1]"));
	}

	public void click_InviteNewEmployee() {

		WebUI.clickElementWithJs(By.xpath("(//a[contains(text(),'Invite New Employee')])[2]"));
	}

	public void groupUserEnterQuantityForCourse(int quantity, String courseName) {
		List<WebElement> courseBlocks = WebUI.getWebElements(By.xpath("//div[@class='course-type invoice-cell']"));

		boolean courseFound = false;

		for (WebElement courseBlock : courseBlocks) {

			if (!courseBlock.isDisplayed()) {
				continue;
			}

			try {
				WebElement titleElement = courseBlock.findElement(By.xpath(".//span"));
				String titleText = titleElement.getText();
				System.out.println("Course found: " + titleText);

				if (titleText.equalsIgnoreCase(courseName)) {

					WebElement quantityelement = WebUI
							.getWebElement(By.xpath("//div[@class='invoice-sub']//div//span[text()='" + courseName
									+ "']/parent::div/following-sibling::div//div//input[@class='paytextInputzipI quantity']"));
					quantityelement.clear();
					quantityelement.sendKeys(String.valueOf(quantity));
					System.out.println("Set quantity " + quantity + " for course: " + titleText);
					courseFound = true;
					break;
				}
			} catch (Exception e) {
				System.out.println("Error while processing a courseBlock: " + e.getMessage());
			}
		}

		if (!courseFound) {
			System.out.println("Course '" + courseName + "' not found or not visible.");
		}
	}

	public void click_invoice() {

		WebUI.clickElementWithJs(By.xpath("//a[@id='submit-invoice-course']"));

	}

	public void handleInvoiceAlert(String msg) throws InterruptedException {
		Assert.assertTrue((WebUI.alertGetText()).contains(msg));

		WebUI.alertAccept();

	}

	public void click_login() {

		WebUI.clickElement(By.xpath("//input[@id='select_course']"));

	}

	public void click_purchasecode() {

		WebUI.clickElement(By.xpath("(//a[contains(text(),'Purchase Codes')])[2]"));

	}

	public void send_instruction() {
		WebUI.clickElement(By.xpath("(//input[@id='select_course'])[1]"));
	}

	public void error_message_validation(String error) {
		String error1 = WebUI.getTextElement(By.xpath(
				"//div[@id='register_box']//p[contains(text(),'Your email / password combination is invalid.')]"));
		Assert.assertEquals(error1, error);
	}

	public void invoicepage_validation() {
		String error1 = WebUI.getTextElement(By.xpath("//p[contains(text(),'Invoices')]"));

		Assert.assertEquals(error1, "Invoices");
	}

	public void click_reset_button() {
		WebUI.clickElement(By.xpath("//p[@class='cop-link-register']//a[normalize-space()='Click Here to Reset']"));
	}

	public void enter_groupuser_email(String username) {

		WebUI.setText(By.xpath("(//input[@id='email'])[2]"), username);
	}

}
