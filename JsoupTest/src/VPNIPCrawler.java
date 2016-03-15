import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class VPNIPCrawler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

	public static void test(){
		String login_url = "http://58.221.35.98/vpn/useradmin/userlogin.php";
		String go_url = "http://58.221.35.98/vpn/useradmin/login.php";
		try {
			Connection conn = Jsoup.connect(login_url);
			conn.data("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			conn.data("Accept-Encoding", "gzip, deflate, sdch");
			conn.data("Accept-Language", "zh-CN,zh;q=0.8");
			conn.data("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2527.0 Safari/537.36");
			Document doc = conn.get();
			Response res = conn.response();
			String key_value = res.cookie("PHPSESSID");
			
			conn.data("UserName", "moshenxiaogui");
			conn.data("Password", "8888mmmm");
			conn.cookie("PHPSESSID", key_value);
			conn.data("x", "0");
			conn.data("y", "1");
			conn.data("go", "");
			Document doc2 = conn.post();
			System.out.println(doc2);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
