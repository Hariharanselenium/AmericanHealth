package com.thinktimetechno.projects.website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.thinktimetechno.keywords.WebUI;

public class TypeOfProfessionPage {

	public void verify_typeofprofessiontab() {
		WebElement typeofprofession = WebUI
				.waitForElementVisible(By.xpath("(//h3[contains(text(),'Please choose your profession')])[2]"));
		String typeofprofessiontext = typeofprofession.getText();

		Assert.assertEquals(typeofprofessiontext, "Please Choose Your Profession");
	}

	public void select_profession(String profession) {
		WebUI.clickElement(By.xpath("(//a[contains(text(),'" + profession + "')])[1]"));
	}
}
