package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.ls.LSInput;

import Util.Repository_Sort;
import dataService.RepositoryDataService;
import po.RepositoryPO;


/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class RepositoryData implements RepositoryDataService {
	
	static String string="http://www.gitmining.net/api/repository";
	/**
	 * 
	 * json格式项目详情列表，一页50个，不加?page=则默认显示第一页内容
	 * @throws IOException 
	 * 
	 */
	public ArrayList<RepositoryPO> getRepositories() throws IOException{
		// TODO Auto-generated method stub
		ArrayList<RepositoryPO> list=new ArrayList<RepositoryPO>();
		JSONObject obj = new JSONObject();
		FileReader fr = new FileReader(new File("D:/软件工程与计算3/GitSearch" + "/src/main/java/txtData/users.json"));
		BufferedReader br = new BufferedReader(fr);
		String string = br.readLine();
		String s1 ,s2,s3,s4,name;
		JSONArray obj1 = new JSONArray(string);
		int size=0;
		int stargazers_count=0;
		int forks = 0,issues_count=0,subscribers_count=0,contributor=0;
		for (int j = 0; j < obj1.length(); j++) {
			obj = obj1.getJSONObject(j);
			if(obj.has("description")){
				s1=obj.getString("description");
			}else{
				s1="";
			}
			
			if(obj.has("fork")){
				s2=obj.getString("fork");
			}else{
				s2="";
			}
			
			if(obj.has("pushed_at")){
				s3=obj.getString("pushed_at");
			}
			else{
				s3="";
			}
			
			if(obj.has("size")){
				size=obj.getInt("size");
			}
			
			if(obj.has("stargazers_count")){
				stargazers_count=obj.getInt("stargazers_count");
			}
			
			if(obj.has("language")){
				s4=obj.getString("language");
			}else{
				s4="";
			}
			
			if(obj.has("contributors_count")){
				contributor=obj.getInt("contributors_count");
			}
			
			if(obj.has("forks")){
				forks=obj.getInt("forks");
			}
			
			if(obj.has("open_issues_count")){
				issues_count=obj.getInt("open_issues_count");
			}
			
			if(obj.has("subscribers_count")){
				subscribers_count=obj.getInt("subscribers_count");
			}
			
			if(obj.has("name")){
				name=obj.getString("name");
			}else{
				name="";
			}
			RepositoryPO po=new RepositoryPO(name,obj.getInt("id") , obj.getString("type"), 
					obj.getString("html_url"), s1, s2, obj.getString("created_at"),
					obj.getString("updated_at"), s3, size, stargazers_count, 
					s4,forks ,issues_count,subscribers_count ,contributor);
			list.add(po);
			}
		return list;
	}
	
	/**
	 * 
	 * 所有项目全称列表（项目全称=owner登录名/项目名），返回值为String类型的数组
	 * @throws IOException 
	 * 
	 */
	public ArrayList<String> getRepositoriesNames() throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader(new File("D:/软件工程与计算3/GitSearch" + "/src/main/java/txtData/users.json"));
		BufferedReader br = new BufferedReader(fr);
		String temp ;
		ArrayList<String> list=new ArrayList<String>();
		while((temp=br.readLine())!=null){
			list.add(temp);
		}
		return list;
	}

	public RepositoryPO checkRepository(String userName, String reponame) throws IOException {
		// TODO Auto-generated method stub
		String str1=string+"/"+userName+"/"+reponame;
		ArrayList<String> list=new ArrayList<String>();
		list = new GetData().getString(str1);
		return null;
	}

	public Map<String, Integer> languagesOfRepository(String userName, String reponame) {
		// TODO Auto-generated method stub
		return null;
	}

	public String RepositoryInfo(String userName, String reponame, Util.RepositoryInfo info) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<RepositoryPO> Search(String name) throws IOException {
		 ArrayList<RepositoryPO> pos=new ArrayList<RepositoryPO>();
			for(RepositoryPO po:getRepositories()){
	            if(po.getName().contains(name)){
	                pos.add(po);
	            }
	        }
			return pos;
		
	}

	public ArrayList<RepositoryPO> sort( Repository_Sort sort) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<RepositoryPO> list=new RepositoryData().getRepositories();
		if(sort==Repository_Sort.contributor){
		
		for(int j=0;j<list.size();j++){
			for(int i=j;i<list.size();i++){
				if(list.get(i).getContributor()<=list.get(i+1).getContributor()){
					RepositoryPO temp=list.get(i);
					list.set(i, list.get(i+1));
					list.set(i+1, temp);
					
					}
				}
			}
		}else if(sort==Repository_Sort.fork){
			for(int j=0;j<list.size();j++){
				for(int i=j;i<list.size();i++){
					if(list.get(i).getForks()<=list.get(i+1).getForks()){
						RepositoryPO temp=list.get(i);
						list.set(i, list.get(i+1));
						list.set(i+1, temp);
						
					}
					}
				}
		}else if(sort==Repository_Sort.star){
			for(int j=0;j<list.size();j++){
				for(int i=j;i<list.size();i++){
					if(list.get(i).getStargazers()<=list.get(i+1).getStargazers()){
						RepositoryPO temp=list.get(i);
						list.set(i, list.get(i+1));
						list.set(i+1, temp);
						
						}
					}
				}
		}
		
		return list;
	}

	
}
