package kr.ac.pknu.dormitory.model;

import kr.ac.pknu.dormitory.controller.MenuParsing;

public class MenuData {
	public static String[][] menuData = new String[4][8];
	private String todayBreakfast, todayLunch, todayDinner;
	
	public MenuData() {
		MenuParsing menuParsing = new MenuParsing();
		menuData = menuParsing.getMenuData();
		
		//TODO get date cause I must set the today menu data breakfast, lunch, dinner.
		
	}
	
}
