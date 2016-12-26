package kr.ac.pknu.dormitory;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MenuParsingClass {

	public static ArrayList<String[]> menuArr = new ArrayList<String[]>();

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

			MenuParsingClass menuParsingClass = new MenuParsingClass(); // fillContent
																		// ����Ϸ���
																		// ��ü �ϳ�
																		// ����
			contents = doc.select("div.board_box table thead tr th"); // day of
																		// the
																		// week
			menuParsingClass.fillContent(contents, 0);

			contents = doc.select("div.board_box table tbody tr td"); // day of
																		// the
																		// week
			menuParsingClass.fillContent(contents, 1);

		} catch (Exception e) {
			e.getMessage();
		}

	}

	private void fillContent(Elements contents, int arrIndex) {
		String[] tempStrArr = new String[8];
		int i = 0, j = 0, count = 0;

		for (Element e : contents) {
			// String str = e.text();
			// System.out.println(str);
			tempStrArr[i] = e.text();
			++i;
			++count;
			if((j = i%7)==1 && arrIndex < 1) {
				menuArr.add(arrIndex, tempStrArr);
				break;
			}else if((j = i%7)==1 && arrIndex > 0) {
				menuArr.add(arrIndex, tempStrArr);	
				i = 0; //initiate
			}
		}
	}
}
