package com.Amazokart.kidsproducttest;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Kidsproducttest2 {
	@Test(priority = 3,dependsOnMethods = "adproduct",enabled = false,groups = "smoke")
	  public void deleteproduct() {
		  Reporter.log("deleteproduct---kids PRD successfully",true);
	  }
	  @Test(priority = 2,dependsOnMethods = "addproduct",groups = "functionality")
	  public void updateproduct() {
		  Reporter.log("update--kids product successfully",true);
	  }
	  @Test(priority = 1,invocationCount = 2,groups = "intigration")
	  public void addproduct() {
		  Reporter.log("Addproduct kids--successfully",true);
	  }
	}


