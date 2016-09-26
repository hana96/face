import java.io.*;
import java.util.*;
import java.net.*;

public class dating {
    public static void main(String[] args) {

	String filename = "coolboy.csv";//読み込むcsvファイルの名前
	File fl = new File(filename);
	
	ArrayList<String[]> csvData = new ArrayList<String[]>();
	String line;//csvファイル1行分保存
	try {
	    FileInputStream fis = new FileInputStream(fl);
	    InputStreamReader isr = new InputStreamReader(fis);
	    BufferedReader br = new BufferedReader(isr);
	    while((line = br.readLine()) != null){
		String[] cols = line.split(",");// ","ごとに区切る
		csvData.add(cols);
	    }
	    
	    
	    for(String[] row : csvData){
		String urlname = row[2];//urlの名前を取り出す
		//System.out.println(urlname);
		
		//画像ダウンロード処理
		URL url = new URL(urlname);//ダウンロードするURL
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();


		File file = new File("./coolboy/boy" + row[0] + ".jpg");//保存名
		FileOutputStream out = new FileOutputStream(file,false);

		int b;
		while((b= in.read())!=-1){
		    out.write(b);//画像書き込み
		}
		out.close();
		in.close();
	    }
	    
	}catch(Exception e){
	    e.printStackTrace();
	}
    }
}
