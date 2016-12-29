package kr.ac.pknu.dormitory;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MenuParsingClass {

	//public static ArrayList<String[]> menuArr = new ArrayList<String[]>();
	public String[] menuPlanner = new String[32];
	public int count = 0;

	public static void main(String[] args) {
		Elements contents = null;
		Document doc = null;
		try {
			// Document doc =
			// Jsoup.connect("http://dormitory.pknu.ac.kr/03_notice/notice01.php").get();
			// 여기서는 바로 식단표의 내용을 파싱할 수 없다.
			// 왜그런지 모르겠으나 표에서 바로 텍스트를 뽑아낼 수 없다.
			// req_getSchedule.php에서 받아오더라. 일단은 임시로 이 주소를 사용하는 중.
			doc = Jsoup.connect("http://dormitory.pknu.ac.kr/03_notice/req_getSchedule.php").get();

			MenuParsingClass menuParsingClass = new MenuParsingClass();
			// fillContent 사용하려고 객체 하나 생성

			contents = doc.select("div.board_box table thead tr th"); 
			/* day of the week */
			menuParsingClass.fillContent(contents);

			contents = doc.select("div.board_box table tbody tr td");
			menuParsingClass.fillContent(contents);
			
			for(int i=0;i<menuParsingClass.menuPlanner.length;i++) {
				System.out.println(menuParsingClass.menuPlanner[i]);
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	private void fillContent(Elements contents) {
		for (Element e : contents) {
			this.menuPlanner[count] = e.text();
			count++;
		}
	}
}
