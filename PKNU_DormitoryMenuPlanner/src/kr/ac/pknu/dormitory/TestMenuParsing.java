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
			// ���⼭�� �ٷ� �Ĵ�ǥ�� ������ �Ľ��� �� ����.
			// �ֱ׷��� �𸣰����� ǥ���� �ٷ� �ؽ�Ʈ�� �̾Ƴ� �� ����.
			// req_getSchedule.php���� �޾ƿ�����. �ϴ��� �ӽ÷� �� �ּҸ� ����ϴ� ��.
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
