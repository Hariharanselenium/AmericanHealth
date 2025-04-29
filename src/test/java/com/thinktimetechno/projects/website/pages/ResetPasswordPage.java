package com.thinktimetechno.projects.website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.thinktimetechno.keywords.WebUI;

public class ResetPasswordPage {
	public void enter_username(String username) {

		WebUI.setText(By.xpath("//input[@placeholder='Username/Email']"), username);
	}

	public void click_Send_Instructions() {
		WebUI.clickElement(By.xpath("//input[@value='Send Instructions']"));
	}

	public void success_message_validation(String success) {
		WebElement sucessElement = WebUI.waitForElementVisible(By.xpath("(//div[@class='msg_successfully'])[1]"));
		String success1 = sucessElement.getText();

		Assert.assertEquals(success1, success);
	}

	public void Resetpassword_page_validation() {
		WebUI.waitForPageLoaded();
		String PageTitle = WebUI.getTextElement(By.xpath("//div[@id='forgot_password_wrapper']/child::h4"));
		Assert.assertEquals(PageTitle, "Forgot your password?");
	}


}
