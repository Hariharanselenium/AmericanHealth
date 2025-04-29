package com.thinktimetechno.projects.website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.thinktimetechno.keywords.WebUI;


public class PaymentPage {

	public void verify_paymentPageDisplays() {

		WebElement payment = WebUI.waitForElementVisible(By.xpath("(//h3[contains(text(),'Payment Information')])[1]"));
		String paymenttext = payment.getText();

		Assert.assertEquals(paymenttext, "Payment Information");
	}
	
	public void verify_checkoutPageDisplays() throws InterruptedException {
		WebElement payment = WebUI.waitForElementVisible(By.xpath("//h2[contains(text(),'Checkout')]"));
		String paymenttext = payment.getText();

		Assert.assertEquals(paymenttext, "Checkout");
	}

	public void select_download_card() {
		WebUI.clickElementWithJs(By.xpath("//div[contains(text(),'Continue To Download Card')]"));
	}
	
	
			public void select_next() {
				WebUI.clickElementWithJs(By.xpath("(//a[contains(text(),'NEXT')])[1]"));
			}
	public void payment_details(String fullname, String cardnumber, String expirationmonth, String expirationyear,
			String cvv) {
		WebUI.waitForPageLoaded();
		WebUI.setText(By.xpath("//input[@id='nameoncard']"), fullname);
		WebUI.setText(By.xpath("//input[@id='creditcardnumber']"), cardnumber);
		WebUI.setText(By.xpath("//input[@id='expirationmonth']"), expirationmonth);
		WebUI.setText(By.xpath("//input[@id='expirationyear']"), expirationyear);
		WebUI.setText(By.xpath("//input[@id='cvvcode']"), cvv);

	}
	public void card_details(String cardnumber, String expirationdate,String cvv) {
		WebUI.switchToFrameByElement(By.xpath("//iframe[@title='Secure payment input frame']"));
		WebUI.waitForPageLoaded();
		WebUI.clickElement(By.xpath("//input[@id='Field-numberInput']"));
		WebUI.setText(By.xpath("//input[@id='Field-numberInput']"), cardnumber);
		WebUI.setText(By.xpath("//input[@id='Field-expiryInput']"), expirationdate);
		WebUI.setText(By.xpath("//input[@id='Field-cvcInput']"), cvv);

	}
	public void country_details(String countryName) {
    WebElement countryDropdown = WebUI.getWebElement(By.xpath("//select[@id='Field-countryInput']"));
    Select selectCountry = new Select(countryDropdown);
    selectCountry.selectByVisibleText(countryName);
	}
	public void verify_couponappliedDisplays(String msg) {

		WebElement successquiz = WebUI.waitForElementVisible(By.xpath(
				"//span[contains(text(),'10% off applied')]"));
		String successquiztext = successquiz.getText();

		Assert.assertEquals(successquiztext, msg);
	}
	public void verify_invalidcouponDisplays(String msg) {

		WebElement successquiz = WebUI.waitForElementVisible(By.id(
				"invalid-feedback-coupon"));
		String successquiztext = successquiz.getText();

		Assert.assertEquals(successquiztext, msg);
	}
	public void verify_thankyouDisplays() {

		WebElement successquiz = WebUI.waitForElementVisible(By.xpath(
				"//h2[contains(text(),'Thank You')]"));
		String successquiztext = successquiz.getText();

		Assert.assertEquals(successquiztext, "Thank You");
	}
	
	
	
	public void couponcode(String coupon) {
		WebUI.setText(By.xpath("//input[@id='coupon']"), coupon);
	WebUI.clickElementWithJs(By.xpath("//input[@id='applycoupon']"));

	}
	public void invalidcouponcode(String coupon) {
		WebUI.setText(By.xpath("//input[@id='coupon_input']"), coupon);
	WebUI.clickElementWithJs(By.xpath("//input[@id='coupon_input']"));

	}
	

	public void click_next_button() throws InterruptedException {
		WebUI.clickElementWithJs(By.xpath("(//button[contains(text(),'NEXT')])[1]"));
//		Thread.sleep(10000);
	}

}
