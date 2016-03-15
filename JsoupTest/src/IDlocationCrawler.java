import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class IDlocationCrawler {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String url = "http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/201504/t20150415_712722.html";
		Document doc = Jsoup.connect(url).get();
		Elements es = doc.getElementsByAttributeValue("class", "MsoNormal");
		int count_error = 0;
		for(Element e:es){
			Elements data = e.getAllElements();
			if(data.get(0).childNodeSize()>1){
				System.out.println(data.get(0).child(0).text()+data.get(0).child(1).text());
			}else{
				System.out.println(data.get(0).text()+"0000000000");
			}
			
		}
		System.out.println(count_error);
	}

}
