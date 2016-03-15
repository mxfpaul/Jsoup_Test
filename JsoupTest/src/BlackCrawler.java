import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import net.sf.json.JSONObject;

public class BlackCrawler {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
	
	}
	
	
	//红岭创投P2P黑名单抓取
	public static void HLCT() throws Exception{
		String url = "https://www.my089.com/Loan/BlackList.aspx?Time=2009";
		Document doc = Jsoup.connect(url).get();
		Element e = doc.getElementById("ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder1_UpdatePanel1");
		Elements es = e.getElementsByAttributeValue("class", "blacklist");
		Elements data;
		for(Element e1:es){
			data = e1.getElementsByAttributeValue("class", "dd");
			if(data != null){
				System.out.print(data.select("span").get(0).text()+" ");
				System.out.println(data.select("span").get(1).text());
				
			}
			
		}
	}
	
	//借贷网P2P黑名单抓取
	public static void JDW() throws Exception{
		String url1= "http://www.jiedai.cn/blacklist/";
		String url2;
		Document doc;
		for(int i=1;i<164;i++){
			url2 = i+".html";
			doc = Jsoup.connect(url1+url2).get();
			Elements e = doc.getElementsByAttributeValue("class", "black_item");
			for(Element e1:e){
				System.out.print(e1.child(1).child(0).text().replaceAll("姓名：", "").replaceAll(" ", "")+" ");
				System.out.println(e1.child(1).child(2).text().replaceAll("身份：", ""));
				
			}
		}
		
	}
	
	//法院失信被执行抓取1
	public static void FYSX() throws IOException{
		String url = "http://zhengxin.ca-sme.org/";
		Document doc = Jsoup.connect(url).get();
		Elements e = doc.getElementsByAttributeValue("class", "member");
		for(Element e1:e){
			System.out.print(e1.child(0).child(0).text()+" ");
			System.out.println(e1.child(0).child(1).text());
			
		}
	
	}
	
	
	//法院被执行名单抓取
	public static void FYBZX() throws Exception{
		System.out.println("抓取开始");
		String ip ="218.97.194.198";
		String port = "80";
//		System.setProperty("proxyHost", ip);
//		System.setProperty("proxyPort", port);
		String url1 ="http://zhixing.court.gov.cn/search/detail?id=";
		String url2 ="";
		for(int i=30426090;i<30429000;i++){
			url2 = ""+i;
			Connection conn = Jsoup.connect(url1+url2);
			conn.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.125 Safari/537.36");
			conn.header("Accept-Language", "zh-CN,zh;q=0.8");
			conn.header("Accept-Encoding", "gzip, deflate, sdch");
			conn.cookie("__jsl_clearance", "1449566737.967|0|qhCMqC409mmo1LhJF2%2F4NBD4bfY%3D");
			conn.cookie("__jsluid","671207ff15b1839ceb11cf3dc8fc309d");
			conn.cookie("JSESSIONID", "FC0D0C9D92A5EAFBBF16523301E00953");
			System.out.println(url2);
			Response res = conn.execute();
			if(res.header("X-Cache").equals("pass")){
				JSONObject data = JSONObject.fromObject(res.body());
				if(data.getString("partyCardNum").length() == 19){
					System.out.print(data.getString("pname")+" ");
					System.out.println(data.getString("partyCardNum"));
				}
				
			}
		}
		System.out.println("抓取结束");
		
		
	}
	
}
