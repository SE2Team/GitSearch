package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class GetData {
	
	public  GetData() {
		// TODO Auto-generated constructor stub
		
	}	
	
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
		
		public String fatherPath ="src/main/java/txtData/";//"src/main/java/data/Currentdata/";
		
		private String path;

		public static final String splitStr = "#";
		
		public  GetData(String path) {
			// TODO Auto-generated constructor stub
			this.path = path;
		}


		/**
		 * 将数据写入文件（覆盖）
		 * @param s
		 */
		public void writeData(ArrayList<String> s) {
			try {
				FileWriter fw = new FileWriter(fatherPath + path + ".txt", true);
				for(int j=0;j<s.size();j++){	
				fw.write(s.get(j) + "\n");
				}
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		/**
		 * 将数据写入文件（追加一行）
		 */
		public void writeDataAdd(String s) {
			
			try {
				FileWriter fw = new FileWriter(fatherPath + path + ".txt", true);
				fw.write(s + "\n");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * 从文件中读取数据
		 * @return
		 */
		public ArrayList<String> readData() {
			ArrayList<String> lists = new ArrayList<String>();
			try {
				BufferedReader br = new BufferedReader(new FileReader(new File(fatherPath + path + ".txt")));
				String temp = null;
				while((temp = br.readLine()) != null) {
					lists.add(temp);
				}
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return lists;
		}
		
//		ArrayList<UserPO> list=new UserData().getUser();
//		UserPO po=null;
//		GetData get=new GetData("has");
//		UserData data=new UserData();
//		for(int i=0;i<list.size();i++){
//			po=data.CheckUser(list.get(i).getLogin());
//			get.writeDataAdd(po.getLogin()+";"+po.getHas().size());
//		}
//		
//		GetData get2=new GetData("related");
//		for(int i=0;i<list.size();i++){
//			po=data.CheckUser(list.get(i).getLogin());
//			get2.writeDataAdd(po.getLogin()+";"+po.getRelated().size());
//		}
//统计用户相关项目与用户拥有项目数	
		public void clearData(String path) {
			try {
				FileWriter fw = new FileWriter(fatherPath + path + ".txt", false);
				fw.write("");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
