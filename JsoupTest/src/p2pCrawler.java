import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class p2pCrawler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			printCompany();
	}

	public static void printCompany(){
		String url = "http://www.wdzj.com/dangan/";
		try {
			Document doc = Jsoup.connect(url).get();
			Elements data = doc.getElementsByAttributeValue("class", "terraceList");
//			Element e =data.first();
//			Elements e2 = e.getElementsByAttributeValue("class","nameBox");
//			String url2 = "http://www.wdzj.com"+e2.first().getElementsByTag("a").first().attr("href");
//			
//			Document doc2 = Jsoup.connect(url2).get();
//			Elements data2 = doc2.getElementsByAttributeValue("class", "bdBox");
//			Elements e3 = data2.first().getElementsByAttributeValue("class", "bd inforBd");
//		
//			System.out.println(e3.first().getElementsByTag("p").first().childNode(1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
