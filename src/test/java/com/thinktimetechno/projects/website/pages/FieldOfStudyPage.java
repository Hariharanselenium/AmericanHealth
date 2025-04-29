package com.thinktimetechno.projects.website.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.thinktimetechno.driver.DriverManager;
import com.thinktimetechno.keywords.WebUI;

public class FieldOfStudyPage {

	public void verify_fieldofstudytab() {

		WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h3[contains(text(),'Are you a Healthcare Provider? ')])[1]")));
		Assert.assertEquals(WebUI.getTextElement(By.xpath("(//h3[contains(text(),'Are you a Healthcare Provider? ')])[1]")), "Are You A Healthcare Provider?");
	}  
	
	public void verify_AreyouHealthcareProvidertab() {

		WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), \"Are You A Healthcare Provider?\")]")));
		Assert.assertEquals(WebUI.getTextElement(By.xpath("//div[contains(text(), \"Are You A Healthcare Provider?\")]")), "Are You A Healthcare Provider?");
	} 
	
	public void select_healthcare_provider(String page) {
		WebUI.clickElementWithJs(By.xpath("//div/a[contains(text(),'" + page + "')]"));
		//a[contains(text(), "Yes, I'm a healthcare provider")]
	}
	public void select_healthcareprovider(String page) {
	    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
	    
	    String xpath = "//a[contains(text(),\"" + page + "\")]";
	    
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

	    WebUI.clickElement(By.xpath(xpath));
	}

}
