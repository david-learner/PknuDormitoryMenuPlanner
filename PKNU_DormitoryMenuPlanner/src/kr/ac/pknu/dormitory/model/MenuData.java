package kr.ac.pknu.dormitory.model;

import javafx.scene.control.Label;
import kr.ac.pknu.dormitory.controller.MenuParsing;

public class MenuData {
	public static String[][] menuData = new String[4][8];
	private String todayBreakfast, todayLunch, todayDinner;
	
	public MenuData() {
		MenuParsing menuParsing = new MenuParsing();
		menuData = menuParsing.getMenuData();
		
		//TODO get date cause I must set the today menu data breakfast, lunch, dinner.
	}
	
	public Label[][] getLabelMenuData(){
		Label[][] labelMenuData = new Label[4][8];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 8; j++) {
				labelMenuData[i][j].setText(menuData[i][j]);
			}
		}
		return labelMenuData;
	}
	
	public String[][] getStringMenuData() {
		return menuData;
	}
}
