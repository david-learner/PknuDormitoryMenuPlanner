package kr.ac.pknu.dormitory;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MenuParsingClass {
	
	public String[] menuPlanner = new String[32];
	public int count = 0;
	
	public MenuParsingClass() {
		Elements contents = null;
		Document doc = null;
		
		try {
			// Document doc =
			// Jsoup.connect("http://dormitory.pknu.ac.kr/03_notice/notice01.php").get();
			// 여기서는 바로 식단표의 내용을 파싱할 수 없다.
			// 왜그런지 모르겠으나 표에서 바로 텍스트를 뽑아낼 수 없다.
			// req_getSchedule.php에서 받아오더라. 일단은 임시로 이 주소를 사용하는 중.
			doc = Jsoup.connect("http://dormitory.pknu.ac.kr/03_notice/req_getSchedule.php").get();

			//MenuParsingClass menuParsingClass = new MenuParsingClass();
			// fillContent 사용하려고 객체 하나 생성
			//생성자안에서 객체를 생성하고 MainClass에서 이를 사용할 수 있는가?
			//대신에 this를 사용하면 생성자 내부의 새로운 객체가 아니라 생성되는 객체를 사용할 수 있다.

			contents = doc.select("div.board_box table thead tr th"); 
			/* day of the week */
			this.fillContent(contents);

			contents = doc.select("div.board_box table tbody tr td");
			/* menu contents */
			this.fillContent(contents);
			
//			for(int i=0;i<menuParsingClass.menuPlanner.length;i++) {
//				System.out.println(menuParsingClass.menuPlanner[i]);
//			}

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