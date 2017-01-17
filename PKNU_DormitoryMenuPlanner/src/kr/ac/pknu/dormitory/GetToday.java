package kr.ac.pknu.dormitory;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GetToday {
	public String GetToday() {
		return this.today();
	}	
	
	private String today(){
		SimpleDateFormat sdf = new SimpleDateFormat("M/dd");
		Calendar c = Calendar.getInstance();
		String today = sdf.format(c.getTime());
		return today;
	}
}
