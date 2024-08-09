package com.flippokart.generic.webDriverUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForPageToLoad(WebDriver driver)
	{
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	public void waitForElementPresent(WebDriver driver,WebElement element)
	{
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}

	public void clickOnElement()
	{
		
	}
	public void passDataOnElement()
	{
		
	}
	public void clearDataOnElement()
	{
		
	}
	public void validateOnElementDisplayed()
	{
		
	}
	public void validateOnElementEnabled()
	{
		
	}
	public void validateOnElementSelected()
	{
		
	}
	public void selectOptionOnDropdown(int index)
	{
		
	}
	public void selectOptionOnDropdown_value(String value)
	{
		
	}
	public void selectOptionOnDropdown(String visibleText )
	{
		
	}
	public void switchTo()
	{
		
	}
	public void swithControlToFrame()
	{
	}


}
