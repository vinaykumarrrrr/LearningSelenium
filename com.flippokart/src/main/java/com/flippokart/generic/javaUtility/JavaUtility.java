package com.flippokart.generic.javaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNum()
	{
		Random random=new Random();
		int ranDomNumber=random.nextInt(5000);
		return ranDomNumber;
	}
	public String getSystemDateYYYYDDMM()
	{
		Date dateOBJ=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(dateOBJ);
		return date;
	}
	public String getRequriedDateYYYYDDMM(int days)
	{
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate=sim.format(cal.getTime());
				return reqDate;
		
		
		
		
		
	}
}
