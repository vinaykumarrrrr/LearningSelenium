package com.flippokart.generic.ExcelUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SendDataToExcel {
	public static void main(String[] args) throws Throwable
	{
		//convert the physical excel file into java understandable

	FileInputStream fis=new FileInputStream("./src/test/resources/Data/TestDataa.xlsx");
	
	// create the work book
	Workbook book=WorkbookFactory.create(fis);
	
	//using workbook go to sheet,row,column and cell fetch the data
	String data=book.getSheet("studentdetails").getRow(1).getCell(1).getStringCellValue();
	
	//create a new column and write data
	book.getSheet("studentdetails").getRow(1).createCell(2).setCellValue("STATUS");
	
	// UPDATE THE EXISTING DATA IN EXCEL
	
	book.getSheet("studentdetails").getRow(1).getCell(2).setCellValue("FAIL");
	
	//CONVERT JAVA DATA INTO PHYSICAL FILE
	
	FileOutputStream fos=new FileOutputStream("./src/test/resources/Data/TestDataa.xlsx");
	
	//write the data
	book.write(fos);
	
	//close the workbook
	
	book.close();
	
	System.out.println(data);
	
	}

}


