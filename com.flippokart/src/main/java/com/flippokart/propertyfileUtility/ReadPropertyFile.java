package com.flippokart.propertyfileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.flippokart.generic.common.FrameworkConstant;

public class ReadPropertyFile implements FrameworkConstant{
	
	FileInputStream fis;
	FileOutputStream fos;
	Properties p;
	public String readData(String key)
	{
		//convert the phusical file into java understandable
		try {
			fis=new FileInputStream(propertypath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p=new Properties();
		try {
			p.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String data=p.getProperty(key);
		return data;
	}
	public void writeData(String key,String value)
	{
		//enter the data
		p.put(key, value);
		//create instance for FILE OUTPUT stream
		try {
			fos=new FileOutputStream(propertypath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//store the data
		try {
			p.store(fos,"updated new key value sucessfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void displaydata(String key)
	{
		//convert the physical file into java undersandable
		try {
			fis=new FileInputStream(propertypath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//creating instance for properties class
		p=new Properties();
		
		// load the all common data
		try {
			p.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//fetch the data
		String data=p.getProperty(key);
		//print on console
		System.out.println(data);
	
	}


}
