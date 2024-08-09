package com.flippokart.generic.common;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.flippokart.propertyfileUtility.ReadPropertyFile;

public class BaseClass_Register extends ObjectUtility{
	public static WebDriver driver=null;
	
	@DataProvider(name="Register")
	public Object[][] registerdata()
	{
		Object[][] data=new Object[3][3];
		
		data[0][0]="vinay";
		data[0][1]="vinay123@gmail.com";
		data[0][2]="Testing";
		
		data[1][0]="amul baby Satheesh";
		data[1][1]="satheesh@gmail.com";
		data[1][2]="tiger rice";
		
		data[2][0]="himansh";
		data[2][1]="himanshu@gmail.com";
		data[2][2]="developer";
		
		return data;
	}
	
	@BeforeSuite
	public void serverconnection()
	{
		Reporter.log("server_Connection done",true);
	}
	@BeforeTest
	public void dbconnection()
	{
		Reporter.log("db connection done",true);
	} 
	
	@BeforeMethod
	public void login()
	{

		Reporter.log("login sucessful",true);
	}
    @Parameters("browser")
	@BeforeClass
	public void browsersetup(String browser)
	{
	if(browser.equalsIgnoreCase("chrome"))
	{

	    driver= new ChromeDriver();
	 }
	 else if(browser.equalsIgnoreCase("edge"))
	 {
		driver= new EdgeDriver();
		
	 }
	 else if(browser.equalsIgnoreCase("firefox"))
	 {
		driver= new FirefoxDriver();
		
	 }
	 else {
		 System.out.println("you have entered invalid browser name");
		 driver=new ChromeDriver();
	 }
	     
	//create object for all
		 
	objectCreation();
		 
    //Fetch data
    String url=propertyobj.readData("url");
	driver.get(url);
		 
	Reporter.log("broswerSetup sucessful",true);
		 
	 } 
	     
//	 //navigate application url
//	   
//	   ReadPropertiFile read=new ReadPropertiFile();
//	   System.out.println(read.readData("url"));
//		try {
//			driver.get(read.readData("url"));
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	 Reporter.log("broswerSetup sucessful",true);
//	
//	} 
	
	@AfterClass
	public void closeBrowser()
	{
		Reporter.log("close browser sucessful",true);
		driver.close();
	}
}
	//driver.get("file:///C:/Users/sathe/eclipse-workspace/com.Amazokart/src/test/resources/webpage/webpage.html");
