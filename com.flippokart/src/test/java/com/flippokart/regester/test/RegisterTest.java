package com.flippokart.regester.test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.flippokart.generic.ExcelUtility.ReadExcelFile;
import com.flippokart.generic.common.BaseClass_Register;
import com.flippokart.pagerepositorUtility.PageProperties;

public class RegisterTest extends BaseClass_Register {
	@Test(enabled = false)
	public void createUser() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// verify page using assert

		String exp_title = "LEarning WEB TECHNOLOGY FORMS";
		String act_title = driver.getTitle();
		System.out.println(act_title);
		Assert.assertEquals(act_title, exp_title);

		// create object for Register

		PageProperties reg = new PageProperties(driver);

		// step1: clear the name in the neme textfield
		reg.getName().clear();

		// create an object for Excelutilityfile class

		ReadExcelFile excel = new ReadExcelFile();

		// step 2: write the name in the new text field
		reg.getName().sendKeys(excel.readdata("student", 1, 1));

		// step 3: display the email

		System.out.println(excel.readdata("student", 1, 2));

		// step 4: write the data
		excel.writedata("student", 2, 1, "himanshu");

		Reporter.log("create User_validdata for Register Test", true);
	}

	@Test(dataProvider = "Register")
	public void createUser_invalidData(String name, String email, String password) {
		{
			
			PageProperties reg=new PageProperties(driver);
			reg.getName().clear();
			reg.getName().sendKeys(name);
			
			reg.getEmail().clear();
			reg.getEmail().sendKeys(email);
			
			reg.getPassword().clear();
			reg.getPassword().sendKeys(password);
				

			System.out.println("name:" + name);
			System.out.println("email:" + email);
			System.out.println("password:" + password);
			Reporter.log("hhh", true);

		}

	}
}
