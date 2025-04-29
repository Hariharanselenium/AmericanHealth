package com.thinktimetechno.projects.website.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.thinktimetechno.driver.DriverManager;
import com.thinktimetechno.keywords.WebUI;

public class RegistrationPage {

	public void Registration_page_validation() {

		Assert.assertTrue(WebUI.verifyPageTitleContains("Register - American Health Care Academy"));

	}

	public void error_validation(String error) throws InterruptedException {
		WebElement firstNameField = WebUI.getWebElement(By.name("first_name"));
		firstNameField.clear();
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].dispatchEvent(new Event('blur'));", firstNameField);
		WebElement formElement = WebUI.getWebElement(By.tagName("form"));
		js.executeScript("arguments[0].submit();", formElement);
		WebElement errorElement = WebUI
				.waitForElementVisible(By.xpath("//div[text()='* Please enter your first name']"));
		String error_message = errorElement.getText();
		Assert.assertEquals(error_message, error);
		System.out.println("Error message captured successfully: " + error_message);
	}

	public void click_register_now() {
		WebUI.clickElementWithJs(By.id("register-button"));

	}

	public void click_store_button() {
		WebUI.clickElementWithJs(By.xpath("(//a[contains(text(),'Store')])[2]"));

	}

	public void click_ViewCartContent_button() {
		WebUI.clickElementWithJs(By.xpath("(//a[contains(text(),' View Cart Content ')])[1]"));

	}

	public void addmanual(String manual) {
		List<WebElement> productNames = WebUI.getWebElements(By.xpath("//div[@class='names name_english ']"));

		// Get list of all "Add to Cart" buttons
		List<WebElement> addToCartButtons = WebUI.getWebElements(By.xpath("//input[@class='add_btns']"));

		// Loop through the product names to find the desired product
		for (int i = 0; i < productNames.size(); i++) {
			String name = productNames.get(i).getText().trim();

			if (name.equalsIgnoreCase(manual)) {
				// Click the corresponding cart button
				addToCartButtons.get(i).click();
				break;
			}
		}

	}

	public void click_save() throws InterruptedException {
		Thread.sleep(5000);
		WebUI.clickElementWithJs(By.xpath("(//input[@class='mybuttons'])[1]"));
		Thread.sleep(10000);

	}

	public void click_the_save() throws InterruptedException {
		Thread.sleep(5000);
		WebUI.clickElementWithJs(By.xpath("(//input[@class='mybuttons'])[2]"));
		Thread.sleep(5000);
	}

	public void click_submitorder() {
		WebUI.clickElementWithJs(By.xpath("(//a[contains(text(),'Submit Order')])[1]"));

	}

	public void click_terms_conditions() {
		WebUI.clickElement(By.xpath("//input[@id='opt_in_button']"));

	}

	public void enter_registration_details(String firstName, String lastname, String phonenumber, String emailaddress,
			String username, String password, String confirmpassword) {
		WebUI.setText(By.xpath("//input[@id='first_name']"), firstName);
		WebUI.setText(By.xpath("//input[@id='last_name']"), lastname);
		WebUI.setText(By.xpath("//input[@id='phone_number']"), phonenumber);
		WebUI.setText(By.xpath("//input[@id='email_address']"), emailaddress);
		WebUI.setText(By.xpath("//input[@id='username']"), username);
		WebUI.setText(By.xpath("//input[@id='password']"), password);
		WebUI.setText(By.xpath("//input[@id='confirm_password']"), confirmpassword);

	}

	public void enter_registration_detail(String firstName, String lastname, String phonenumber, String emailaddress,
			String username, String password, String confirmpassword) throws InterruptedException {
		String dateTime = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		String emailAddress = emailaddress.replace("john.doe", "john.doe" + dateTime);

		String Username = username.replace("johndoe", "johndoe" + dateTime);

		WebUI.setText(By.xpath("//input[@id='first_name']"), firstName);

		WebUI.getJsExecutor().executeScript("document.getElementById('first_name').blur();");

		WebUI.setText(By.xpath("//input[@id='last_name']"), lastname);
		WebUI.clickElement(By.xpath("//input[@id='phone_number']"));
		WebUI.setText(By.xpath("//input[@id='phone_number']"), phonenumber);

		WebUI.setText(By.xpath("//input[@id='email_address']"), emailAddress);

		WebUI.setText(By.xpath("//input[@id='username']"), Username);
		WebUI.setText(By.xpath("//input[@id='password']"), password);
		WebUI.setText(By.xpath("//input[@id='confirm_password']"), confirmpassword);
	}

	public void enter_payment_detail(String card, String cardNumber, String expirationMonth, String ExpirationYear,
			String CVVCode, String FullNameonCard, String BillingAddress, String BillingCity, String BillingState,
			String BillingZip) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

// Select card type
		WebElement cardTypeDropdown = WebUI.waitForElementVisible(By.xpath("(//select[@name='payment[cc_type]'])[1]"));
		Select selectCardType = new Select(cardTypeDropdown);
		selectCardType.selectByVisibleText(card);

// Fill in Full Name on Card
		WebUI.setText(By.xpath("(//input[@name='payment[cc_name]'])[1]"), FullNameonCard);

// Fill in Billing Address
		WebUI.setText(By.xpath("(//input[@name='payment[billing_address]'])[1]"), BillingAddress);
		WebUI.clickElement(By.xpath("(//input[@class='table_btn billing_address_plus_btn'])[1]"));
		WebUI.setText(By.xpath("(//input[@id='billing_city'])[1]"), BillingCity);

// Select Billing State
		WebElement billingStateDropdown = WebUI.waitForElementVisible(By.xpath("(//select[@id='billing_state'])[1]"));
		Select selectBillingState = new Select(billingStateDropdown);
		selectBillingState.selectByVisibleText(BillingState);

// Set Billing Zip
		WebUI.setText(By.xpath("(//input[@id='billing_zipcode'])[1]"), BillingZip);

// Select Expiration Month
		WebElement monthDropdown = WebUI
				.waitForElementVisible(By.xpath("(//select[@name='payment[cc_exp_month]'])[1]"));
		Select selectMonth = new Select(monthDropdown);
		selectMonth.selectByVisibleText(expirationMonth);

// Select Expiration Year
		WebElement yearDropdown = WebUI.waitForElementVisible(By.xpath("(//select[@name='payment[cc_exp_year]'])[1]"));
		Select selectYear = new Select(yearDropdown);
		selectYear.selectByVisibleText(ExpirationYear);

		Thread.sleep(1000); // Wait for UI transitions if any

// Set Card Number using JavaScript (to bypass UI masking)
		js.executeScript("document.getElementById('card-number').value='" + cardNumber + "';");
		WebElement cardInput = WebUI.getWebElement(By.id("card-number"));
		js.executeScript("arguments[0].focus();", cardInput);
		Thread.sleep(300);
		js.executeScript("arguments[0].blur();", cardInput);

// Set CVV using JavaScript
		js.executeScript("document.querySelector(\"input[name='payment[cc_cvv]']\").value='" + CVVCode + "';");

// Optional: Handle alert if present (e.g., on form submission)
		try {

			System.out.println("Alert Message: " + WebUI.alertGetText());
			WebUI.alertAccept();
		} catch (NoAlertPresentException e) {
// No alert - continue silently
		}
	}

	public void re_enter() throws InterruptedException {
		WebUI.clickElement(By.xpath("(//div[@class='button_groups change_button_block'])[1]"));

		WebUI.setText(By.xpath("(//input[@name='payment[cc_cvv]'])[1]"), "12345");
		WebUI.setText(By.xpath("(//input[@id='card-number'])[1]"), "4242424242424242");
		WebUI.clickElementWithJs(By.xpath("(//input[@class='mybuttons'])[1]"));
		Thread.sleep(10000);

	}

	public void enter_shipping_detail(String firstname, String lastname, String Company, String Address, String city,
			String State, String Zip) throws InterruptedException {

		WebUI.setText(By.xpath("(//input[@name='address[company]'])[1]"), Company);

		WebUI.setText(By.xpath("(//input[@name='address[first_name]'])[1]"), firstname);

		WebUI.setText(By.xpath("(//input[@name='address[last_name]'])[1]"), lastname);

		WebUI.setText(By.xpath("(//input[@name='address[address1]'])[1]"), Address);
		WebUI.clickElementWithJs(By.xpath("(//div[contains(text(),'Address ')])[3]"));

//                WebElement firstSuggestion = WebUI.getWebElement(By.className("pac-item"));
//                ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", firstSuggestion);

		// Remove focus to close dropdown
//                WebElement addressInput = WebUI.getWebElement(By.xpath("(//input[@name='address[address1]'])[1]"));
//                ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].blur();", addressInput);
		WebUI.clickElementWithJs(By.xpath("(//input[@class='table_btn shipping_address_plus_btn'])[1]"));

		WebUI.setText(By.xpath("(//input[@id='shipping_city'])[1]"), city);
		WebElement dropdown1 = WebUI.waitForElementVisible(By.xpath("(//select[@id='shipping_state'])[1]"));
		Select select1 = new Select(dropdown1);
		select1.selectByVisibleText(State);

		WebUI.setText(By.xpath("(//input[@id='shipping_zipcode'])[1]"), Zip);

	}

	public void enter_registration_detail_with_code(String firstName, String lastname, String phonenumber,
			String emailaddress, String username, String password, String confirmpassword, String Code)
			throws InterruptedException {
		String dateTime = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		String emailAddress = emailaddress.replace("john.doe", "john.doe" + dateTime);

		String Username = username.replace("johndoe", "johndoe" + dateTime);

		WebUI.setText(By.xpath("//input[@id='first_name']"), firstName);

		WebUI.getJsExecutor().executeScript("document.getElementById('first_name').blur();");

		WebUI.setText(By.xpath("//input[@id='last_name']"), lastname);
		WebUI.clickElement(By.xpath("//input[@id='phone_number']"));
		WebUI.setText(By.xpath("//input[@id='phone_number']"), phonenumber);

		WebUI.setText(By.xpath("//input[@id='email_address']"), emailAddress);

		WebUI.setText(By.xpath("//input[@id='username']"), Username);
		WebUI.setText(By.xpath("//input[@id='password']"), password);
		WebUI.setText(By.xpath("//input[@id='confirm_password']"), confirmpassword);
		WebUI.setText(By.xpath("//input[@id='auth_code']"), Code);
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

	public void enter_existing_registration_details(String firstName, String lastname, String phonenumber,
			String emailaddress, String username, String password, String confirmpassword) {

		WebUI.setText(By.xpath("//input[@id='first_name']"), firstName);
		WebUI.setText(By.xpath("//input[@id='last_name']"), lastname);
		WebUI.setText(By.xpath("//input[@id='phone_number']"), phonenumber);
		WebUI.setText(By.xpath("//input[@id='email_address']"), emailaddress);
		WebUI.setText(By.xpath("//input[@id='username']"), username);
		WebUI.setText(By.xpath("//input[@id='password']"), password);
		WebUI.setText(By.xpath("//input[@id='confirm_password']"), confirmpassword);

	}

	public void verifyregistrationPageDisplays() {
		WebUI.waitForPageLoaded();
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(60));
		wait.until(ExpectedConditions.titleContains("Takequiz | Express - American Health Care Academy"));

		Assert.assertTrue(WebUI.verifyPageTitleContains("Takequiz | Express - American Health Care Academy"));
	}
}
