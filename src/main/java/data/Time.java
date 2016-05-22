package data;

import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;

public class Time {
	
	public Date getNowTime(int i) throws ParseException{
		
		Calendar ca=Calendar.getInstance();
		java.util.Date nowdate = new java.util.Date();//得到当前时间
		ca.setTime(nowdate);
		ca.set(Calendar.DAY_OF_YEAR, ca.get(Calendar.DAY_OF_YEAR)-i*30);//你想要前几天的，就减去几天
		Date now = new Date(ca.getTimeInMillis());//这个就是前n天的时间
		
		return now;
	}
}
