package com.thinktimetechno.projects.website.stepdefinitions.CorporateUser;

import java.sql.DriverManager;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import com.thinktimetechno.hooks.TestContext;
import com.thinktimetechno.keywords.WebUI;
import com.thinktimetechno.projects.website.Multipages.CorporateDashboardPage;
import com.thinktimetechno.projects.website.Multipages.CorporateInvitePage;
import com.thinktimetechno.projects.website.Multipages.CorporateLoginPage;
import com.thinktimetechno.projects.website.Multipages.CorporateRegistrationPage;
import com.thinktimetechno.projects.website.Multipages.CorporateResetPasswordPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Corporate_StepDefinitions {

	private CorporateDashboardPage corporatedashboardPage;
	private CorporateLoginPage corporateloginPage;
	private CorporateRegistrationPage corporateregistrationPage;
	private CorporateResetPasswordPage corporateresetpasswordPage;
	private CorporateInvitePage corporateinvitePage;
	
	int employeeCount; 

	public Corporate_StepDefinitions(TestContext testContext) {
		corporatedashboardPage = testContext.getCorporateDashboardPage();
		corporateloginPage = testContext.getCorporateLoginPage();
		corporateregistrationPage = testContext.getCorporateRegistrationPage();
		corporateresetpasswordPage = testContext.getCorporateResetPasswordPage();
		corporateinvitePage = testContext.getCorporateInvitePage();
	}

	@Given("GroupUser navigate to {string} for Group registration")
	public void group_user_navigate_to_for_group_registration(String url) {
		WebUI.getURL(url);
	}

	@When("GroupUser clicks on the Register button")
	public void group_user_clicks_on_the_register_button() throws InterruptedException {
		corporateregistrationPage.click_register();
	}

	@Then("GroupUser should redirected to the Corporate dashboard page")
	public void group_user_should_redirected_to_the_corporate_dashboard_page() {
		corporatedashboardPage.verifyDashboardPageDisplays();
	}

	@When("User enters the existing account details:")
	public void user_enters_the_existing_account_details(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);

		String firstName = data.get("First Name");
		String lastName = data.get("Last Name");
		String companyName = data.get("Company Name");
		String phoneNumber = data.get("Phone Number");
		String emailAddress = data.get("Email Address");
		String createPassword = data.get("Create Password");
		String confirmPassword = data.get("Confirm Password");
		corporateregistrationPage.enter_existing_registration_detail(firstName, lastName, companyName, phoneNumber,
				emailAddress, createPassword, confirmPassword);

	}

	@When("User enters the Corporate registration details:")
	public void user_enters_the_corporate_registration_details(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);

		String firstName = data.get("First Name");
		String lastName = data.get("Last Name");
		String companyName = data.get("Company Name");
		String phoneNumber = data.get("Phone Number");
		String emailAddress = data.get("Email Address");
		String createPassword = data.get("Create Password");
		String confirmPassword = data.get("Confirm Password");
		corporateregistrationPage.enter_registration_details(firstName, lastName, companyName, phoneNumber,
				emailAddress, createPassword, confirmPassword);

	}

	@When("GroupUser enters the group registration details with leaving one mandatory field blank")
	public void groupuser_enters_the_corporate_registration_details(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);

		String firstName = data.get("First Name");
		String lastName = data.get("Last Name");
		String companyName = data.get("Company Name");
		String phoneNumber = data.get("Phone Number");
		String emailAddress = data.get("Email Address");
		String createPassword = data.get("Create Password");
		String confirmPassword = data.get("Confirm Password");
		corporateregistrationPage.enter_registration_details_BLANK(firstName, lastName, "", phoneNumber, emailAddress,
				createPassword, confirmPassword);

	}

	@When("GroupUser enters the Corporate registration details:")
	public void group_user_enters_the_corporate_registration_details(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);

		String firstName = data.get("First Name");
		String lastName = data.get("Last Name");
		String companyName = data.get("Company Name");
		String phoneNumber = data.get("Phone Number");
		String emailAddress = data.get("Email Address");
		String createPassword = data.get("Create Password");
		String confirmPassword = data.get("Confirm Password");
		corporateregistrationPage.enter_registration_details(firstName, lastName, companyName, phoneNumber,
				emailAddress, createPassword, confirmPassword);

	}

	@Then("GroupUser should see the missing field error message")
	public void group_user_should_see_the_missing_field_error_message() {
		corporateregistrationPage.error_validation("Please complete the required information highlighted below .");
	}

	@Then("GroupUser should not be navigated to the Corporate dashboard page")
	public void group_user_should_not_be_navigated_to_the_corporate_dashboard_page() {
		corporateregistrationPage.not_group_dashboard_page_validation();
	}

	@Then("GroupUser should redirected to the Group Reset Password page")
	public void group_user_should_redirected_to_the_group_reset_password_page() {
		corporateresetpasswordPage.Group_Resetpassword_page_validation();
	}

	@Then("GroupUser should see the message as {string}")
	public void group_user_should_see_the_message_as(String string) {
		corporateresetpasswordPage.success_message_validation(string);
	}

	@Given("User navigates to the group login page {string}")
	public void user_navigates_to_the_group_login_page(String url) {
		WebUI.getURL(url);
	}

	@Then("GroupUser should redirected to the GroupUser dashboard page")
	public void group_user_should_redirected_to_the_group_user_dashboard_page() {
		corporatedashboardPage.verifyDashboardPageDisplays();
	}

	@When("GroupUser taps on the Employees tap")
	public void group_user_taps_on_the_employees_button() {
		corporatedashboardPage.employees_button();
	}

	@Then("GroupUser should be redirected to the Employees page")
	public void group_user_should_land_on_the_employee_page() {
		corporatedashboardPage.verifyemployeePageDisplays();
	}

	@When("GroupUser taps on the Export button")
	public void group_user_taps_on_the_export_button() {
		corporatedashboardPage.export_button();
	}

	@Then("The Employee file should be downloaded with prefix {string}")
	public void employee_list_download_dynamic(String expectedPrefix) {
		corporatedashboardPage.verifyAndDeleteDynamicFile(expectedPrefix);
	}

	@Then("The Employee file should be downloaded as {string}")
	public void employee_list_download(String string) throws InterruptedException {

	}

	@When("GroupUser tap on the Purchase Codes button")
	public void group_user_taps_on_the_purchasecode_button() {
		corporateloginPage.click_purchasecode();
	}

	@Then("GroupUser should be navigated to the Purchase Code page")
	public void group_user_should_see_Purchase_Code_page() {
		corporateloginPage.goupuser_purchase_page_validation();
	}

	@When("GroupUser taps on the Login button")
	public void group_user_taps_on_the_login_button() {
		corporateloginPage.click_login();
	}

	@Then("GroupUser should see an error message {string} on the GroupUser login page")
	public void group_user_should_see_an_error_message_on_the_group_user_login_page(String error) {
		corporateloginPage.error_message_validation(error);
	}

	@When("GroupUser taps on Click Here to Reset")
	public void group_user_taps_on_click_here_to_reset() {
		corporateloginPage.click_reset_button();
	}

	@Then("GroupUser hit the Send Instructions")
	public void group_user_hit_the_send_instructions() {
		corporateloginPage.send_instruction();
	}

	@When("GroupUser enter the Username\\/Email as {string}")
	public void user_enter_the_username_email_as(String username) {
		corporateloginPage.enter_groupuser_email(username);
	}

	@When("GroupUser enters billing address details:")
	public void group_user_enters_billing_credentials(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);
		String FirstName = data.get("First Name");
		String LastName = data.get("Last Name");
		String Company = data.get("Company");
		String Address = data.get("Address");
		String City = data.get("City");
		String State = data.get("State");
		String Zip = data.get("Zip");
		corporateloginPage.Corporate_billing_details(FirstName, LastName, Company, Address, City, State, Zip);
	}

	@When("GroupUser enters the payment details:")
	public void group_user_enters_payment_credentials(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);
		String FullNameonCard = data.get("Full Name on Card");
		String CardNumber = data.get("Card Number");
		String ExpirationMonth = data.get("Expiration Month");
		String ExpirationYear = data.get("Expiration Year");
		String CVVCode = data.get("CVV Code");

		corporateloginPage.Corporate_payment_details(FullNameonCard, CardNumber, ExpirationMonth, ExpirationYear,
				CVVCode);
	}

	@When("GroupUser enters login credentials:")
	public void group_user_enters_login_credentials(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);

		String email = data.get("Email");
		String Password = data.get("Password");
		corporateloginPage.Corporate_login_details(email, Password);
	}

	@Then("GroupUser should see the existing account error message")
	public void user_should_see_the_existing_account_error_message() {
		String error_message = "There is already an existing corporate account for this company. Please log in here.";
		corporateregistrationPage.exiting_account_validation(error_message);
	}

	@When("GroupUser taps the Invite New Employee button")
	public void group_user_taps_the_button() {
		corporatedashboardPage.invite_employee_button();
	}

	@Then("GroupUser should be redirected to the {string} page")
	public void group_user_should_be_redirected_to_the_page(String page) {
		corporateinvitePage.Invite_New_Employees_page_validation(page);
	}

	@Then("GroupUser should be redirected to the {string} tab")
	public void group_user_should_be_redirected_to_the_selectCourse_page(String string) {
		corporateinvitePage.Select_Courses_page_validation(string);
	}

	@Then("GroupUser should be redirected to the Confirmation page")
	public void group_user_should_be_redirected_to_the_confirmation_page() {
		corporateinvitePage.confirmation_page_validation();
	}

	@When("GroupUser enters the following employee details:")
	public void group_user_enters_the_following_employee_details(io.cucumber.datatable.DataTable dataTable) {
	    List<Map<String, String>> employeeList = dataTable.asMaps(String.class, String.class);
	    employeeCount = employeeList.size();
	    
	    for (int i = 0; i < employeeCount; i++) {
	        Map<String, String> data = employeeList.get(i);
	        
	        // Fill details in current row
	        corporateinvitePage.fillEmployeeDetails(i + 1, data.get("First Name"), data.get("Last Name"), data.get("Email Address"), data.get("Phone Number"));

	        // Click "Invite Another Employee" button except after last row
	        if (i < employeeList.size() - 1) {
	            WebUI.clickElement(By.xpath("//button[text()='Invite Another Employee']"));
	            WebUI.waitForElementVisible(By.xpath("(//input[@class='first_name'])[" + (i + 2) + "]"), 10);
	        }
	    }
	}



	@When("GroupUser taps the Next button")
	public void group_user_taps_the_next_button() {
		corporateinvitePage.next_button();
	}

	@When("GroupUser clicks the Next button")
	public void group_user_clicks_the_next_button() {
		corporateinvitePage.submit_assign_course_button();
	}

	@When("GroupUser selects the payment option as {string}")
	public void group_user_selects_the_payment_option_as(String string) {
		corporateinvitePage.paymentselection(string);
	}

	@When("GroupUser selects the group code")
	public void group_user_selects_the_group_code() {
		corporateinvitePage.groupcodeselection();
	}

	@Then("GroupUser should be navigated to the Invoice Payment page")
	public void group_user_should_see_the_success_message_as() {
		corporateloginPage.verifypayinvoicePageDisplays();
	}

	@Then("GroupUser should be navigated to the Invoice page")
	public void group_user_should_see_the_Invoice_page() {
		corporateloginPage.invoicepage_validation();
	}

	@Then("Group User should see that the total invoice amount is the same on the Create Invoice page and the Invoice page.")
	public void groupuser_see_same_total_invoice_in_Invoice_page() {
		corporateloginPage.goupuser_total_invoice_validation();
		;
	}

	@Then("GroupUser should see an alert saying {string}")
	public void group_user_should_see_the_success_message_as(String string) throws InterruptedException {
		corporateloginPage.handleInvoiceAlert(string);
	}

	@When("GroupUser enter {string} in Purchase Order")
	public void group_user_enterPO(String code) throws InterruptedException {
		corporateloginPage.enter_purchasecode(code);
		Thread.sleep(5000);
	}

	@When("GroupUser tap the Pay Invoice button")
	public void group_user_submitinvoice() throws InterruptedException {
		corporateloginPage.click_invoice_();
	}

	@When("GroupUser taps on the Same as Billing Address radio button")
	public void group_user_tap__same_as_billingaddress() throws InterruptedException {
		corporateloginPage.click_sameas_billingaddress();
	}

	@When("GroupUser clicks on Submit Payment button")
	public void group_user_tap_Submit_Payment_button() throws InterruptedException {
		corporateloginPage.click_submitpayment();
	}

	@When("GroupUser taps the Pay Invoice button")
	public void group_user_submit_invoice() throws InterruptedException {
		corporateloginPage.click_invoice();

	}

	@When("GroupUser enter quantity as {int} for {string} course")
	public void groupUserEnterQuantityForCourse(int quantity, String courseName) {
		corporateloginPage.groupUserEnterQuantityForCourse(quantity, courseName);
	}

	@When("GroupUser tap the Invite New Employee button")
	public void group_user_tap_the_button() {
		corporateloginPage.click_InviteNewEmployee();
	}

	@Then("GroupUser lands on the Invite New Employee Page")
	public void group_user_lands_on_the_invite_new_employee_page() {
		corporateloginPage.Invite_page_validation();
	}

	@When("GroupUser enters the employee details:")
	public void group_user_enters_the_employee_details(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> employeeDetails = dataTable.asMap(String.class, String.class);

		String firstName = employeeDetails.get("First Name");
		String lastName = employeeDetails.get("Last Name");
		String email = employeeDetails.get("Email Address");
		String phone = employeeDetails.get("Phone Number");
		corporateloginPage.Corporate_details(firstName, lastName, email, phone);

	}

	@When("GroupUser select the payment type as Pre-Paid")
	public void group_user_select_the_payment_type_as() {
		corporateloginPage.paymentype_selection();

	}
	
	@When("GroupUser select the first available course code")
	public void group_user_select_the_first_available_course_code() {
		corporateloginPage.course_selection(employeeCount);

	}
	@When("GroupUser select first available course code")
	public void group_user_select_first_available_course_code() {
		corporateloginPage.course_selection_01();

	}

	@When("GroupUser tap the Next button")
	public void group_user_tap_the_button1() {
		corporateloginPage.click_nxt();
	}
	@When("GroupUser taps on the Next button")
	public void group_user_taps_the_button1() {
		corporateloginPage.click_nxt1();
	}
	@When("GroupUser tap the Invite Another Employee button")
	public void group_user_taps_the_InviteAnotherEmployee_button() {
		corporateloginPage.anotheremployee();
	}
	

	@Then("GroupUser should see a message {string}")
	public void group_user_should_see_a_message(String textMsg) {
		corporateloginPage.msg_validation(textMsg);
	}

}