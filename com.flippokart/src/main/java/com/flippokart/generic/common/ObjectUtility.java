package com.flippokart.generic.common;
import com.flippokart.generic.ExcelUtility.ReadExcelFile;
import com.flippokart.generic.javaUtility.JavaUtility;
import com.flippokart.generic.webDriverUtility.WebDriverUtility;
import com.flippokart.propertyfileUtility.ReadPropertyFile;

public class ObjectUtility implements FrameworkConstant{
	public ReadExcelFile excelobj;
	public JavaUtility javaobj;
	public ReadPropertyFile propertyobj;
	public WebDriverUtility webdriverobj;

public void objectCreation() {
	 excelobj = new ReadExcelFile();
     javaobj = new JavaUtility();
     propertyobj = new  ReadPropertyFile();
	 webdriverobj = new WebDriverUtility();
	
}
}

