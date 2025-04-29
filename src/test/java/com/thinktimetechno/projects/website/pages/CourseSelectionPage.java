package com.thinktimetechno.projects.website.pages;

import java.sql.DriverManager;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.thinktimetechno.keywords.WebUI;

public class CourseSelectionPage {

	public void verify_coursePageDisplays() {
		Assert.assertTrue(WebUI.verifyPageTitleContains("CPR - Introduction - American Health Care Academy"));
	}
	public void verify_thanksPageDisplays() throws InterruptedException {
		Thread.sleep(5000);
		WebElement billing = WebUI.waitForElementVisible(By.xpath("(//h2[contains(text(),'Thank You for Your Order')])[2]"));
		String billingtext = billing.getText();

		Assert.assertEquals(billingtext, "Thank You for Your Order");
		
//	Assert.assertTrue(WebUI.verifyPageTitleContains("Cart | Shop - American Health Care Academy"));
	}
	
	public void verify_cartPageDisplays() {
		
		Assert.assertTrue(WebUI.verifyPageTitleContains("Cart | Shop - American Health Care Academy"));
	}
	public void verify_checkoutPageDisplays() {
		Assert.assertTrue(WebUI.verifyPageTitleContains("Checkout | Shop - American Health Care Academy"));
	}

	public void select_course(String course) {
		WebUI.clickElement(By.xpath("(//a[contains(text(),'" + course + "')])[1]"));
	}
	public void tap_handson() {
		WebUI.clickElement(By.xpath("(//a[contains(text(),'Hands-on Kit')])[2]"));
	}
	
	public void ce_certificate_addtocart(String quantity) {
    List<WebElement> products = WebUI.getWebElements(By.xpath("//div[@class='learntastic-store_item']"));
    for (WebElement product : products) {
        WebElement title = product.findElement(By.xpath(".//div[contains(@class,'store-info_title')]"));
        if (title.getText().contains("CE Certificate")) {
            WebElement addToCartBtn = product.findElement(By.xpath("//div[@id='item_product_select_3']//button[contains(@class, 'store-bottom_addCart')]"
            		+ ""));
            addToCartBtn.click();
            break;
        }
    }
	}
	public void ce_certificate_quantity(String quantity) {
    List<WebElement> products = WebUI.getWebElements(By.xpath("//div[@class='learntastic-store_item']"));
    for (WebElement product : products) {
        WebElement title = product.findElement(By.xpath(".//div[contains(@class,'store-info_title')]"));
        if (title.getText().contains("CE Certificate")) {
            WebElement quantityDropdown = product.findElement(By.xpath(".//select[@name='product_3_quantity']"));
            Select selectQty = new Select(quantityDropdown);
            selectQty.selectByVisibleText(quantity);
            break;
        }
    }
	}

	public void ce_certificate(String courseName) {
    List<WebElement> products = WebUI.getWebElements(By.xpath("//div[@class='learntastic-store_item']"));
    for (WebElement product : products) {
        WebElement title = product.findElement(By.xpath(".//div[contains(@class,'store-info_title')]"));
        if (title.getText().contains("CE Certificate")) {
            WebElement courseDropdown = product.findElement(By.xpath(".//select[@name='product_3_webinar']"));
            Select selectCourse = new Select(courseDropdown);
            selectCourse.selectByVisibleText(courseName);
            break;
        }
    }
    }
	public void addtocart() {
		// TODO Auto-generated method stub
		WebUI.clickElement(By.xpath("//button[@class='allcourses_button']"));
	}
	public void checkoutbutton() {
		// TODO Auto-generated method stub
		WebUI.clickElement(By.xpath("//a[@class='cart-mini_checkout']"));
	}
	
	public void coursesearch(String course) {
		WebUI.setText(By.xpath("//input[@id='search_all_keyword']"), course);
		
	}
	
	public void searchbutton() {
		WebUI.clickElement(By.xpath("//button[@class='button_search_all']"));
	}
	public void selectcourse(String courseName) {
		
		
//		    WebDriverWait wait = new WebDriverWait(DriverManager.getDrivers(), Duration.ofSeconds(10));
		    
		    String xpath = "//h3[normalize-space()='" + courseName + "']" +
		                   "/ancestor::div[contains(@class,'allcourses_list-item')]" +
		                   "//button[contains(text(),'Add to Cart')]";
		    WebUI.clickElement(By.xpath(xpath));
//		    WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
//		    addToCartBtn.click();
		

	}
	
	
	public void selectCourseByProduct(String productTitle, String courseName) {
	    List<WebElement> products = WebUI.getWebElements(By.xpath("//div[@class='learntastic-store_item']"));
	    for (WebElement product : products) {
	        WebElement title = product.findElement(By.xpath(".//div[contains(@class,'store-info_title')]"));
	        if (title.getText().contains(productTitle)) {
	            WebElement courseDropdown = product.findElement(By.xpath(".//select[contains(@name,'webinar')]"));
	            Select selectCourse = new Select(courseDropdown);
	            selectCourse.selectByVisibleText(courseName);
	            break;
	        }
	    }
	}
	public void selectQuantityByProduct(String productTitle, String quantity) {
	    List<WebElement> products = WebUI.getWebElements(By.xpath("//div[@class='learntastic-store_item']"));
	    for (WebElement product : products) {
	        WebElement title = product.findElement(By.xpath(".//div[contains(@class,'store-info_title')]"));
	        if (title.getText().contains(productTitle)) {
	            WebElement quantityDropdown = product.findElement(By.xpath(".//select[contains(@name,'quantity')]"));
	            Select selectQty = new Select(quantityDropdown);
	            selectQty.selectByVisibleText(quantity);
	            break;
	        }
	    }
	}
	public void close_button() {
		WebUI.clickElementWithJs(By.xpath("//div[@id='cart_mini_close']"));
	}
	
	public void clickAddToCartByProduct(String productTitle) {
	    List<WebElement> products = WebUI.getWebElements(By.xpath("//div[@class='learntastic-store_item']"));
	    for (WebElement product : products) {
	        WebElement title = product.findElement(By.xpath(".//div[contains(@class,'store-info_title')]"));
	        if (title.getText().contains(productTitle)) {
	            WebElement addToCartBtn = product.findElement(By.xpath(".//button[contains(@class, 'store-bottom_addCart')]"));
	            addToCartBtn.click();
	            break;
	        }
	    }
	   
	}


}
