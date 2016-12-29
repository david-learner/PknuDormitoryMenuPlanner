package kr.ac.pknu.dormitory;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestMenuParsing {
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
		}catch (Exception e) {
			e.getMessage();
		}
		
		contents = doc.select("div.board_box table thead tr th");
		
		for(Element e: contents) {
			System.out.println(e.text());
		}
		
	}
}
