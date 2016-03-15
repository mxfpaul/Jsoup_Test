import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class SimLogin {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Map<String, String> data = new HashMap<>();
		
		String url = "https://passport.csdn.net/account/login";
		Connection conn = Jsoup.connect(url);
		conn.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.125 Safari/537.36");
		Response res = conn.execute();
		Document doc = Jsoup.parse(res.body());
		
		Elements es1 = doc.select("[name=lt]");
		String lt = es1.attr("value");
		
		Elements es2 = doc.select("[name=execution]");
		String execution = es2.attr("value");
		
		Elements es3 = doc.select("[name=_eventId]");
		String _eventId = es3.attr("value");
		
		data.put("lt", lt);
		data.put("execution", execution);
		data.put("_eventId", _eventId);
		data.put("username", "测试账号");
		data.put("password", "测试密码");
		
		Response res2 = conn.method(Method.POST).data(data).cookies(res.cookies()).execute();
		Document doc2 = Jsoup.connect("http://www.csdn.net/").cookies(res2.cookies()).get();
		Elements eee = doc2.select("#showinfo");
		System.out.println(res2.body());
		
	}
	
}
