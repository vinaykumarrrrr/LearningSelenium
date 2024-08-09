package com.flippokart.generic.ExcelUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.flippokart.generic.common.FrameworkConstant;

public class ReadExcelFile implements FrameworkConstant{
	FileInputStream fis;
	FileOutputStream fos;
	Workbook book;
	
	public String readdata(String sheet,int row,int column) 
	{
		//convert 
		
		try {
			fis = new FileInputStream(excelpath );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// create the work book
		
		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//using workbook go to sheet,row,column and cell fetch the data
		String data=book.getSheet("studentdetails").getRow(0).getCell(1).getStringCellValue();
		return data;
	}
	public void writedata(String sheet,int row,int column,String data)
	{
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//create workbook
		try {
			book=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//create A New column and write data on it.
		book.getSheet(sheet).createRow(row).createCell(column).setCellValue(data);
		
		//convert java data into physical file
		try {
			fos=new FileOutputStream(excelpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//write the Data
		try {
			book.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//close the workbook
		try {
			book.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void displayData(String sheet,int row,int column)
	{
		//convert the physical excel file into java understandable
		
		try {
			fis=new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//create the workshop
		
		try {
			book=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//using workbook go to sheet,row,column and cell fetch the data
		
		String data=book.getSheet(sheet).getRow(row).getCell(column).getStringCellValue();
		
		//print the data
		System.out.println(data);
	}
	public void displaymultipledata(String sheet,int column)
	{
		try {
			fis=new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		try {
			book=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//using workbook go to sheet
		org.apache.poi.ss.usermodel.Sheet sh=book.getSheet(sheet);
		
		int count =sh.getLastRowNum();
		for(int i=1;i<=count;i++)
		{
			//optimized code
			String data=book.getSheet(sheet).getRow(i).getCell(column).getStringCellValue();
			System.out.println(data);
		}	
	}

}
