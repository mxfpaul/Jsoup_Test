import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

public class p2pClawler2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		test();
	}

	public static void test() throws Exception{
		String url = "http://www.wdzj.com/dangan/";

		Connection conn = Jsoup.connect(url);
		conn.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.125 Safari/537.36");
		conn.header("Accept-Language", "zh-CN,zh;q=0.8");
		Response res = conn.execute();
		System.out.println(res.cookies());
		
			
			
		
	}
	
}
