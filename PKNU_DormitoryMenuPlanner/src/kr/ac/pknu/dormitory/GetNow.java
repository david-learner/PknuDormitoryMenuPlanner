package kr.ac.pknu.dormitory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetNow {
	public String date(){
		SimpleDateFormat sdf = new SimpleDateFormat("M/dd");
		Calendar c = Calendar.getInstance();
		String date = sdf.format(c.getTime());
		return date;
	}
//	public String time2(){
//		long time = System.currentTimeMillis();
//		SimpleDateFormat nowTimeFormat = new SimpleDateFormat("HH:mm:ss"); //HH is 24hour, hh is 12hour
//		String nowTime = nowTimeFormat.format(new Date(time));
//		return nowTime;
//	}
	
	public Date time(){
		long time = System.currentTimeMillis();
		Date nowTime = new Date(time);
		return nowTime;
	}
}
