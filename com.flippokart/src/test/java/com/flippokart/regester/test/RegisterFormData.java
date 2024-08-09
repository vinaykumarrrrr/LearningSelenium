package com.flippokart.regester.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.flippokart.generic.common.BaseClass_Register;
@Listeners(com.flippokart.generic.listnerUtility.Listners.class)
public class RegisterFormData extends BaseClass_Register {
	public void clearData() throws Throwable
	{
		 
	Thread.sleep(3000);
		driver.findElement(By.id("name")).clear();
	}
	@Test
	public void sendData() throws Throwable
	{

		
		String titel = driver.getTitle();
		System.out.println(titel);
		if (titel.equals("LEarning WEB TECHNOLOGY FORMS")) {
			System.out.println("Validate SucessFully");
		} else {
			System.out.println("Validation UnsucessFully");
		}

		// Clear The TextField
		driver.findElement(By.id("name")).clear();

		// Enter value into the name TextField
		driver.findElement(By.name("name")).sendKeys("djtillu");

		// Enter value into the Email TextFiled
		driver.findElement(By.cssSelector("input[id='email']")).sendKeys("vinay123@gmail.com");

		// Enter value into the password TextFiled
		driver.findElement(By.xpath("//input[@placeholder='Enter your Password']")).sendKeys("vinay@123");

		// Enter Your Mobile Number Into The TExtField
		driver.findElement(By.name("mobile")).sendKeys("7978593335");

		// set DOB and Time into the Field
		driver.findElement(By.xpath("//input[@type='datetime-local']")).sendKeys("100520001535");

		// Click All the RadioButton
		List<WebElement> radioButton = driver.findElements(
				By.xpath("//label[text()='Gender:']/parent::td/following-sibling::td/input[@name='gender']"));
		for (WebElement radio : radioButton) {
			radio.click();
		}

		// click Kerala CheckBox
		WebElement ele = driver.findElement(By.id("Kerala"));
		JavascriptExecutor java = (JavascriptExecutor) driver;
		java.executeScript("arguments[0].disabled = false;", ele);

		ele.click();

		// Given DropDown Select Indian As Your Country
		WebElement countryDropdown = driver.findElement(By.name("country1"));
		Select sc = new Select(countryDropdown);
		sc.selectByVisibleText("INDIA");

		// Print All DropDown Option And Select second And Four Country of the DropDown
		WebElement dw = driver.findElement(By.name("country2"));
		Select counrty = new Select(dw);
		List<WebElement> option = counrty.getOptions();
		for (WebElement data : option) {
			System.out.println(data.getText());
		}
		counrty.selectByIndex(2);
		counrty.selectByVisibleText("CANADA");

		// Enter your feedback into the feedback TextField
		driver.findElement(By.id("feedback")).sendKeys("Testing the application using selenium");

		// click On SubMit Button
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		// Click On Contact Us Option
		driver.findElement(By.xpath("//a[text()='Contact Us']")).click();
	
		
		
		}

}
