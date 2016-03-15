import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CheckBlackcard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		go(read("C:\\Users\\Vaugh\\Desktop\\blackCard.txt"));
	}

	public static void go(List<String> data){
		String url = "";
//		for(String card:data){
//			url = "http://www.txwz.qq.com/check.html?check="+card+"&action=blank";
			url = "http://www.txwz.qq.com/check.html?check="+"6210985800000699554"+"&action=blank";
			try {
				Document doc = Jsoup.connect(url).get();
				System.out.println(doc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		}
		
	}
	
	public static List<String> read(String path){
		List<String> data = new ArrayList<String>();
		File file = new File(path);
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
			String temp="";
			while((temp = br.readLine())!= null){
				data.add(temp);
			}
			br.close();
			return data;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
}
