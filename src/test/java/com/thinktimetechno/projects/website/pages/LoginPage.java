package com.thinktimetechno.projects.website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.thinktimetechno.keywords.WebUI;

public class LoginPage {

	public DashboardPage loginsingle(String email, String password) {
		WebUI.setText(By.xpath("//input[@id='username']"), email);
		WebUI.setText(By.xpath("//input[@id='password']"), password);
		WebUI.clickElementWithJs(By.xpath("//input[@value='Login']"));
		return new DashboardPage();
	}

	public void click_register() {
		WebUI.clickElement(By.xpath("//a[text()='Register Here']"));

	}

	public void login_page_validation() {
		String PageTitle = WebUI.getPageTitle();
		Assert.assertEquals(PageTitle, "Login | User - American Health Care Academy");
	}

	public void click_login() {
		WebUI.clickElement(By.xpath("//input[@value='Login']"));
		WebUI.waitForPageLoaded();

	}

	public void enter_valid_login_details(String username, String password) {

		WebUI.setText(By.xpath("//input[@id='username']"), username);
		WebUI.setText(By.xpath("//input[@id='password']"), password);
	}

	public void enter_invalid_login_details(String username, String password) {

		WebUI.setText(By.xpath("//input[@id='username']"), username);
		WebUI.setText(By.xpath("//input[@id='password']"), password);
	}

	public void error_message_validation(String error) {
		WebElement errorElement = WebUI.waitForElementVisible(By.xpath("//div[@class='whiteText']"));
		String error1 = errorElement.getText();

		Assert.assertEquals(error1, error);
	}

	public void click_reset() {
		WebUI.clickElement(By.xpath("//a[text()='Click Here to Reset']"));
	}

}
