package com.thinktimetechno.projects.website.Multipages;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.thinktimetechno.keywords.WebUI;

public class CorporateResetPasswordPage {

	public void Group_Resetpassword_page_validation() {
		WebUI.waitForPageLoaded();
		String PageTitle = WebUI.getTextElement(By.xpath("//h2[@class='title-corporate-login']"));

		Assert.assertEquals(PageTitle, "Corporate Forgot Password");
	}

	public void success_message_validation(String success) {

		String success1 = WebUI.getTextElement(By.xpath("//form[@id='Resetform']//div[@class='redText']"));

		Assert.assertEquals(success1, success);
	}

}
