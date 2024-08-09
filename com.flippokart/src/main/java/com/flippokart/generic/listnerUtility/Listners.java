package com.flippokart.generic.listnerUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.flippokart.generic.common.BaseClass_Register;

public class Listners extends BaseClass_Register implements ITestListener {
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		//
	     String res=result.getName();
	     
	     
	     Reporter.log("TAKING SCREENSHOT---Start--: "+res,true);
		
		//
		TakesScreenshot shot=(TakesScreenshot)driver;
		
		// call the screenshot method and save in temp path
		File temp=shot.getScreenshotAs(OutputType.FILE);
		
		//create permanent path and save it
		File per=new File("./src/test/resources/screenshot/"+res+".png");
		
		// copy the file from temp to permenent
		try {
		//org.openqa.selenium.io.FileHandler.copy(temp, per);
			org.openqa.selenium.io.FileHandler.copy(temp, per);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  Reporter.log("TAKING SCREENSHOT---completed--: ",true);
		
	} 
	

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	  
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
