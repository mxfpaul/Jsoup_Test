import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BlackcardCrawler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		go();
	}

	public static void go(){
		System.out.println("开始爬取");
		List<String> data = new ArrayList<String>();
		int count = 0;
		int page = 1;
		for(int i=1;i<80;i++){
			String url = "http://www.pianzib.com/yhkh_"+i+"/";
			try {
				System.out.println("page"+page);
				Document doc = Jsoup.connect(url).get();
				Elements e1 = doc.getElementsByAttributeValue("class", "news_list").first().children();
				for(Element e:e1){
					data.add(e.getElementsByAttribute("title").attr("title"));
					count++;
					System.out.println(count);
				}
				page++;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("爬取结束");
		write_txt(data, "blackCard");
	}
	
	public static void write_txt(List<String> data,String filename){
		File file = new File("C:\\Users\\Vaugh\\Desktop\\"+filename+".txt");
		if(file.exists()){
			file.delete();
		}
		FileWriter fw = null;
		try {
			fw = new FileWriter(file,true);
			for(String s:data){
				fw.write(s+"\r\n");
			}
			
			fw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
