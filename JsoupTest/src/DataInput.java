import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataInput {

	public List<String> read(String path){
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
