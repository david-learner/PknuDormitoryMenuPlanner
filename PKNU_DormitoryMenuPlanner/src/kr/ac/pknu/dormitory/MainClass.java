package kr.ac.pknu.dormitory;

public class MainClass {
	public static void main(String[] args) {
		MenuParsingClass menuParsingClass = new MenuParsingClass();
		
		for(int i = 0; i < 4; i++)
		{
			System.out.println();
			for(int j = 0; j < 8; j++)
			{
				System.out.println(menuParsingClass.menuPlanner[i][j]);
			}
		}

		
	}
}
