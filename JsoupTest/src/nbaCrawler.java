import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class nbaCrawler {

	public static void main(String[] args) {
		printTodayScore();
		
//		printBoxScore();
	}

	public static void printTodayScore(){
		String url = "http://nba.hupu.com/";	
		try {
			Document doc = Jsoup.connect(url).get();
			Elements data = doc.getElementsByAttributeValue("class", "gamespace_list_no");
			Elements time = doc.getElementsByAttributeValue("class", "curTime");
			System.out.println(time.first().text());
			for(Element e:data){
				Element e2 = e.getElementsByTag("tr").first();
				System.out.println(e2.text());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void printBoxScore(){
		String url = "http://nba.hupu.com/";	
		try {
			Document doc = Jsoup.connect(url).get();
			Elements data = doc.getElementsByAttributeValue("class", "gamespace_list_no");
			Element e1 = data.get(0);
			Element e2 = e1.getElementsByAttributeValue("class", "bifen").first();
			Element e3 = e2.getElementsByTag("a").first();
			String url2 = e3.attr("href");
			
			Document doc2 = Jsoup.connect(url2).get();
			Elements data2 = doc2.getElementsByAttributeValue("class", "table_list_live");
			Element table1 = data2.first().getElementsByTag("table").first();
			Elements tableData = table1.getElementsByTag("tr");
			for(Element e:tableData){
				System.out.println(e.text());
			}
			
		
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
