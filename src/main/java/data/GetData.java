package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class GetData {
		public ArrayList<String> getString(String str1) throws IOException{
			ArrayList<String> list=new ArrayList<String>();
			URL url = new URL(str1);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.connect();
	        InputStream inputStream = connection.getInputStream();
	      
	        Reader reader = new InputStreamReader(inputStream, "UTF-8");
	        BufferedReader bufferedReader = new BufferedReader(reader);
	        StringBuffer sb = new StringBuffer();
	        String str=null;
	        while ((str = bufferedReader.readLine()) != null) {
				sb.append(str);
	        }
	        reader.close();
	        connection.disconnect();
	        String s1=sb.toString();
	        String[] s2=s1.split(",");
	        s2[0]=s2[0].substring(1);
	        int length=s2.length-1;
	        s2[length]=s2[length].substring(0, s2[length].length()-1);
	        for(int i=0;i<s2.length;i++){
	        	list.add(s2[i]);
	        }
			return list;
		}
		
		public String getString1(String str1) throws IOException{
			URL url = new URL(str1);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.connect();
	        InputStream inputStream = connection.getInputStream();
	      
	        Reader reader = new InputStreamReader(inputStream, "UTF-8");
	        BufferedReader bufferedReader = new BufferedReader(reader);
	        StringBuffer sb = new StringBuffer();
	        String str=null;
	        while ((str = bufferedReader.readLine()) != null) {
				sb.append(str);
	        }
	        reader.close();
	        connection.disconnect();
	        String s1=sb.toString();
	        return s1;
		}
}