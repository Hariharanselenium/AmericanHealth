package com.thinktimetechno.projects.website.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.thinktimetechno.driver.DriverManager;
import com.thinktimetechno.keywords.WebUI;

public class DashboardPage {

	public void verifyDashboardPageDisplays() throws InterruptedException {
		
		Thread.sleep(20000);
		WebUI.waitForPageLoaded();
		WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("Welcome - American Health Care Academy"));
		Assert.assertTrue(WebUI.verifyPageTitleContains("Welcome - American Health Care Academy"));
	}

	public void verifyContinuousEducationPageDisplays() {
		Assert.assertTrue(WebUI.verifyPageTitleContains("Lifetime | Register - American Health Care Academy"));
	}
	public void verifypurchasecoursePageDisplays() {
		Assert.assertTrue(WebUI.verifyPageTitleContains("Purchased courses list | Learntastic"));
	}
	public void verifyCartInformationPageDisplays() {
		Assert.assertTrue(WebUI.verifyPageTitleContains("Cart | Learntastic"));
	}
	
	
	
	public void verifystorePageDisplays() {
		Assert.assertTrue(WebUI.verifyPageTitleContains("Store | Learntastic"));
	}
	public void verifyhandkitPageDisplays() {
		Assert.assertTrue(WebUI.verifyPageTitleContains("Hands On | Register - American Health Care Academy"));
	}

	public void verify_DashboardPageDisplays() {
		Assert.assertTrue(WebUI.verifyPageTitleContains("Dashboard - American Health Care Academy"));
	}

	public void verify_notDashboardPageDisplays() {

		Assert.assertNotEquals(WebUI.getPageTitle(), "Dashboard - American Health Care Academy");

	}
	public void verify_notWelcomePageDisplays() {

		Assert.assertNotEquals(WebUI.getPageTitle(), "Welcome - American Health Care Academy");

	}

	public void verify_Storepage() {
		WebElement courseselection = WebUI
				.waitForElementVisible(By.xpath("(//h3[contains(text(),'People who took this course also purchased')])[1]"));
		String courseselectiontext = courseselection.getText();

		Assert.assertEquals(courseselectiontext, "People who took this course also purchased");
	}
	public void verify_cart(String msg) {
		WebElement courseselection = WebUI
				.waitForElementVisible(By.xpath("//div[@id='cart_lightbox']"));
		String courseselectiontext = courseselection.getText();

		Assert.assertEquals(courseselectiontext, msg);
	}

	public void verify_course_tab() {
		WebElement courseselection = WebUI
				.waitForElementVisible(By.xpath("(//h3[contains(text(),'Please Select The Course Below For ')])[1]"));
		String courseselectiontext = courseselection.getText();

		Assert.assertEquals(courseselectiontext, "Please Select The Course Below For Doctor / Physicians");
	}
	


	public void verify_coursePageDisplays() {
		Assert.assertTrue(WebUI.verifyPageTitleContains("CPR - Introduction - American Health Care Academy"));
	}

	public void select_course(String course) {
		WebUI.clickElement(By.xpath("(//a[contains(text(),'" + course + "')])[1]"));
	}
	public void Proceed_to_Checkout() {
		WebUI.clickElement(By.xpath("//a[contains(text(),'Proceed to Checkout')]"));
	}
	public void Proceed_to_Checkout_cardpage() {
		WebUI.clickElement(By.xpath("(//a[contains(text(),'Proceed to Checkout')])[1]"));
	}
	public void Pay_Now() {
		WebUI.switchToDefaultContent();
		By payNow = By.xpath("//span[contains(text(),'Pay Now')]");
		WebElement button = WebUI.waitForElementClickable(payNow, 15);

		WebUI.scrollToElementToBottom(button);
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].click();", button);
		WebUI.waitForPageLoaded();
//		WebUI.clickElement(By.xpath("//button[@id='submit']"));
	}
	
	public void Proceed_to_Checkout_card() {
		WebUI.clickElement(By.xpath("//button[@id='btn_submit_cart']"));
	}

	public void i_click_accept() throws InterruptedException {
		WebUI.clickElementWithJs(By.xpath("//a[@id='lifetimeAccept']"));


	}
	

	public void click_i_accept_button() throws InterruptedException {
		WebUI.clickElementWithJs(By.xpath("//a[@id='hands_on_accept_btn']"));
	}
	public void click_continue_button() throws InterruptedException {
		WebUI.clickElementWithJs(By.xpath("//button[contains(text(),'Continue')]"));
	}
	public void click_store_button() throws InterruptedException {
		WebUI.clickElementWithJs(By.xpath("//a[contains(text(),'Store')]"));
	}
	
	
	public void click_startnow_button() {
		WebUI.waitForElementVisible(By.xpath("//a[@class='close-btn']"));
		WebUI.clickElement(By.xpath("//a[@class='close-btn']"));
		WebUI.clickElement(By.xpath("(//a[contains(text(),'Start Now')])[1]"));


	}

	public void verify_thankyouPageAndCloseOtherTabs() throws InterruptedException {

	    WebDriver driver = DriverManager.getDriver();
	    String thankYouUrlKeyword = "/thankyou";
	    String thankYouWindow = null;

	    int waitTimeInSeconds = 10;
	    int elapsed = 0;

	    // Wait loop for thank you tab to load
	    while (elapsed < waitTimeInSeconds) {
	        Set<String> allWindows = driver.getWindowHandles();

	        for (String window : allWindows) {
	            driver.switchTo().window(window);
	            String currentUrl = driver.getCurrentUrl();
	            System.out.println("Checking URL: " + currentUrl);
	            if (currentUrl.contains(thankYouUrlKeyword)) {
	                thankYouWindow = window;
	                break;
	            }
	        }

	        if (thankYouWindow != null) break;

	        Thread.sleep(1000);
	        elapsed++;
	    }

	    // Fail if thank you tab never found
	    Assert.assertNotNull(thankYouWindow, "Thank You tab not found! URLs checked: " +
	        driver.getWindowHandles().stream()
	            .map(w -> {
	                driver.switchTo().window(w);
	                return driver.getCurrentUrl();
	            }).toList());

	    // Close all other tabs
	    Set<String> allWindows = driver.getWindowHandles();
	    for (String window : allWindows) {
	        if (!window.equals(thankYouWindow)) {
	            driver.switchTo().window(window);
	            driver.close();
	        }
	    }

	    // Switch to thank you tab
	    driver.switchTo().window(thankYouWindow);

	    // Final assertion
	    WebElement congratsmsg = WebUI.waitForElementVisible(
	        By.xpath("//h3[normalize-space()='Congrats! You can now download your certification']"));
	    String congrats = congratsmsg.getText();
	    Assert.assertEquals(congrats, "Congrats! You can now download your certification");
	    
	     Thread.sleep(5000);
	}

	   public void addCertificate(WebDriver driver) {
	        // Step 1: Locate all product tabs
	        List<WebElement> products = driver.findElements(By.xpath("//div[@class='learntastic-store_item']"));

	        // Step 2: Iterate through each product
	        for (WebElement product : products) {
	            // Check if it contains "CE Certificate"
	            WebElement titleElement = product.findElement(By.xpath(".//div[contains(@class,'store-info_title')]"));
	            if (titleElement.getText().contains("CE Certificate")) {
	                
	                // Step 3: Select course "Healthcare Provider CPR and First Aid Combo"
	                WebElement courseDropdown = product.findElement(By.xpath(".//select[@name='product_3_webinar']"));
	                Select courseSelect = new Select(courseDropdown);
	                courseSelect.selectByVisibleText("Healthcare Provider CPR and First Aid Combo");

	                // Step 4: Set quantity = 2
	                WebElement qtyDropdown = product.findElement(By.xpath(".//select[@name='product_3_quantity']"));
	                Select qtySelect = new Select(qtyDropdown);
	                qtySelect.selectByVisibleText("2");

	                // Step 5: Click "Add to cart"
	                WebElement addToCartButton = product.findElement(By.xpath(".//button[contains(text(),'Add to cart')]"));
	                addToCartButton.click();

	                break; // Stop loop after adding this product
	            }
	        }
	    }
	   public void search(String courseName) {
			// TODO Auto-generated method stub
			WebElement searchbar = WebUI.getWebElement(By.xpath("//button[@class='button_search_all']"));
			WebUI.scrollToElementToTop(searchbar);

			WebUI.setText(By.xpath("//input[@id='search_all_keyword']"), courseName);
			searchbar.click();

			WebUI.waitForPageLoaded();
			String CourseTitile = WebUI
					.getTextElement(By.xpath("//a[@title='"+courseName+"']"));
			Assert.assertEquals(courseName, CourseTitile);
		}
}
