package kr.ac.pknu.dormitory;

import javafx.scene.control.Label;

public class TestMenuParsing {
	public static void main(String[] args) {
//		MenuData menuData = new MenuData();
//		Label [][] labelArr = new Label[4][8];
//		
//		
//		labelArr = menuData.getLabelMenuData();
//		
//		for(int i = 0; i < 4; i++) {
//			for(int j = 0; j < 8; j++) {
//				System.out.println(labelArr[i][j].getText());
//			}
//		}
		String[][] str = new String [1][1];
		str[0][0] = "not null";
		Label label = new Label();
		label.setText("null");
		label.setText(str[0][0]);
		System.out.println(label.getText());
	}
}