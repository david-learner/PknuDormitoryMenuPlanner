package kr.ac.pknu.dormitory.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MenuParsing {

	private String[][] menuPlanner = new String[4][8]; // [row][column]
	private int i = 0, j = 0;

	public String[][] getMenuData() {
		return menuPlanner;
	}
	
	public MenuParsing() {
		Elements contents = null;
		Document doc = null;

		try {
			// Document doc =
			// Jsoup.connect("http://dormitory.pknu.ac.kr/03_notice/notice01.php").get();
			// ���⼭�� �ٷ� �Ĵ�ǥ�� ������ �Ľ��� �� ����.
			// �ֱ׷��� �𸣰����� ǥ���� �ٷ� �ؽ�Ʈ�� �̾Ƴ� �� ����.
			// req_getSchedule.php���� �޾ƿ�����. �ϴ��� �ӽ÷� �� �ּҸ� ����ϴ� ��.
			doc = Jsoup.connect("http://dormitory.pknu.ac.kr/03_notice/req_getSchedule.php").get();

			// MenuParsingClass menuParsingClass = new MenuParsingClass();
			// fillContent ����Ϸ��� ��ü �ϳ� ����
			// �����ھȿ��� ��ü�� �����ϰ� MainClass���� �̸� ����� �� �ִ°�?
			// ��ſ� this�� ����ϸ� ������ ������ ���ο� ��ü�� �ƴ϶� �����Ǵ� ��ü�� ����� �� �ִ�.

			contents = doc.select("div.board_box table thead tr th");
			/* day of the week */
			this.fillContent(contents);

			contents = doc.select("div.board_box table tbody tr td");
			/* menu contents */
			this.fillContent(contents);

			// for(int i=0;i<menuParsingClass.menuPlanner.length;i++) {
			// System.out.println(menuParsingClass.menuPlanner[i]);
			// }

		} catch (Exception e) {
			e.getMessage();
		}
	}

	private void fillContent(Elements contents) {
		for (Element e : contents) {
			String replaceStr = e.text().replaceAll(" ", "\n");
			this.menuPlanner[i][j] = replaceStr;
			if (j == 7) {
				j = 0;
				i++;
			} else {
				j++;
			}
		}
	}
}