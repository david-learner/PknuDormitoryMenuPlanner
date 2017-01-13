package kr.ac.pknu.dormitory;

public class MainClass {
	public static void main(String[] args) {
		MenuParsingClass menuParsingClass = new MenuParsingClass();
		
		for(int i=0;i<menuParsingClass.menuPlanner.length;i++) {
		System.out.println(menuParsingClass.menuPlanner[i]);
	}

		
	}
}
