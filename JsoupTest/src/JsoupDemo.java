

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupDemo {
	/**
	 * 
	 * @author Vau 2015-12-2 
	 */

	public static void main(String[] args) {
//		String url = "http://news.iresearch.cn/content/2015/12/";
//		
//		for(int i=256500;i<256800;i++){
//			GetData(url+i+".shtml");
//		}
//		GetData("http://news.iresearch.cn/content/2015/12/256544.shtml");

		new newThread().run();
	}

	public static void GetData(String url){
		try {
			Document doc = Jsoup.connect(url).get();
			Elements elements = doc.getElementsByAttributeValue("id", "news-con");
			Element e = elements.first();
			Elements e2 = e.getElementsByTag("table");
			Element e3 = e2.first();
			Elements e4 = e3.getElementsByTag("tr");
			
			for(Element e5:e4){
				Elements el = e5.getElementsByTag("p");
				System.out.println(el.get(1).text()+" "+el.get(3).text());
			}
			
		} catch (IOException e) {
			
			
		}
	}
	
	public static class newThread implements Runnable{

		@Override
		public void run() {
			GetData("http://www.dzwww.com/shandong/sdxwjxs/lc/201512/t20151201_13428755.htm");
			
		}
		
		
	}
}
