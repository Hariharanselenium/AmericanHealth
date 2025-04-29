package com.thinktimetechno.projects.website.Multipages;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.thinktimetechno.driver.DriverManager;
import com.thinktimetechno.keywords.WebUI;

public class CorporateDashboardPage {

	public void verifyDashboardPageDisplays() {
		WebUI.waitForPageLoaded();
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(60));
		wait.until(ExpectedConditions.titleContains("Dashboard | Groupadmin - American Health Care Academy"));

		Assert.assertTrue(WebUI.verifyPageTitleContains("Dashboard | Groupadmin - American Health Care Academy"));
	}

	public void invite_employee_button() {
		WebUI.clickElementWithJs(By.xpath("(//a[contains(text(),'Invite New Employee')])[2]"));

	}

	public void verifyemployeePageDisplays() {
		WebUI.waitForPageLoaded();
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(60));
		wait.until(ExpectedConditions.titleContains("Employees | Groupadmin - American Health Care Academy"));

		Assert.assertTrue(WebUI.verifyPageTitleContains("Employees | Groupadmin - American Health Care Academy"));
	}

	public void employees_button() {
		WebUI.clickElementWithJs(By.xpath("//a[contains(text(),'Employees')]"));

	}

	public void export_button() {
		WebUI.clickElementWithJs(By.xpath("//button[contains(text(),'Export')]"));

	}

	public void verifyAndDeleteExportedFile(String fileName) throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		String downloadPath = projectPath + "\\src\\test\\resources\\EmployeeList";
		File file = new File(downloadPath + "\\" + fileName);

		Thread.sleep(5000);

		if (file.exists()) {
			System.out.println("✅ File downloaded: " + fileName);
			if (file.delete()) {
				System.out.println("🗑️ File deleted after validation.");
			} else {
				System.out.println("⚠️ File exists but couldn't be deleted.");
			}
		} else {
			throw new AssertionError("❌ File not downloaded: " + fileName);
		}
	}

	public void verifyAndDeleteDynamicFile(String startsWithName) {
		String downloadPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Downloads";
		File folder = new File(downloadPath);

		File downloadedFile = null;
		boolean fileFound = false;

		for (int i = 0; i < 10; i++) {
			File[] files = folder.listFiles((dir, name) -> name.startsWith(startsWithName) && name.endsWith(".csv"));

			if (files != null && files.length > 0) {
				downloadedFile = files[0];
				fileFound = true;
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		Assert.assertTrue(fileFound);
		System.out.println("File downloaded: " + downloadedFile.getName());

		if (downloadedFile != null && downloadedFile.delete()) {
			System.out.println("File deleted after validation.");
		}
	}

}
