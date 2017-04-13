package kr.ac.pknu.dormitory.util;

import java.time.LocalTime;

public class DateTime {
	private static LocalTime breakfastTime = LocalTime.of(9, 0);
	private static LocalTime dinnerTime = LocalTime.of(13, 40);
	
	public static int getNow() {
		int i = 0;		//0 is null, 1 : breakfast, 2 : lunch, 3 : dinner.
		
		LocalTime nowTime = LocalTime.now();

		if(nowTime.isBefore(breakfastTime)) {
			return i = 1;		//breakfast
		}else if(nowTime.isAfter(dinnerTime)) {
			return i = 3;		//dinner
		}else {
			return i = 2;		//lunch
		}
	}
}
