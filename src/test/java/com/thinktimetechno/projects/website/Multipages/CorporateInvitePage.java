package com.thinktimetechno.projects.website.Multipages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.thinktimetechno.keywords.WebUI;

public class CorporateInvitePage {

	public void Invite_New_Employees_page_validation(String page) {

		String page1 = WebUI.getTextElement(By.xpath("//h2[contains(text(),'Invite New Employees')]"));

		Assert.assertEquals(page1, page);
	}

	public void invite_employee_detail(String firstName, String lastname, String emailAddress, String phonenumber) {

		WebUI.setText(By.xpath("//input[@class='first_name']"), firstName);
		WebUI.setText(By.xpath("//input[@class='last_name']"), lastname);
		WebUI.setText(By.xpath("//input[@class='email_address']"), emailAddress);
		WebUI.setText(By.xpath("//input[@class='phone_number']"), phonenumber);

	}

	public void next_button() {
		WebUI.clickElementWithJs(By.xpath("//button[contains(text(),'Next')]"));
	}

	public void Select_Courses_page_validation(String course) {

		String course1 = WebUI.getTextElement(By.xpath("//h3[contains(text(),'Select Courses')]"));

		Assert.assertEquals(course1, course);
	}

	public void fillEmployeeDetails(int rowIndex, String firstName, String lastName, String email, String phoneNumber) {

		WebUI.setText(By.xpath("(//input[@class='first_name'])[" + rowIndex + "]"), firstName);
		WebUI.setText(By.xpath("(//input[@class='last_name'])[" + rowIndex + "]"), lastName);
		WebUI.setText(By.xpath("(//input[@class='email_address'])[" + rowIndex + "]"), email);
		WebUI.setText(By.xpath("(//input[@class='phone_number'])[" + rowIndex + "]"), phoneNumber);
	}

	public void confirmation_page_validation() {

		String course1 = WebUI.getTextElement(By.xpath("//div[@class='sub-title']"));
		System.out.println(course1);

	}

	public void paymentselection(String payment) {

		WebUI.clickElementWithJs(By.xpath("//span[@id='select2-chosen-7']"));
		WebUI.sendKeys(By.className("payment-type"), Keys.DOWN);
		WebUI.sendKeys(By.className("payment-type"), Keys.ENTER);

	}

	public void groupcodeselection() {
		WebUI.clickElementWithJs(By.xpath(
				"//div[@class='select2-drop select2-display-none width-auto select2-drop-active select2-drop-above']"));

		WebUI.clickElement(By.xpath("(//ul[@id='select2-results-4']/li)[2]"));
	}

	public void submit_assign_course_button() {
		WebUI.clickElementWithJs(By.xpath("//button[@id='submit-assign-course']"));
	}
}
