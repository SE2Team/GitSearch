package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import Util.Repository_Sort;
import dataService.RepositoryDataService;
import po.RepositoryPO;
import po.StaStrPO;


/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class RepositoryData implements RepositoryDataService {
	
	static String string="http://www.gitmining.net/api/repository";
	static ArrayList<RepositoryPO> finalList=new ArrayList<>();
	/**
	 * 
	 * json格式项目详情列表，一页50个，不加?page=则默认显示第一页内容
	 * @throws IOException 
	 * 
	 */
	public ArrayList<RepositoryPO> getRepositories() throws IOException{
		// TODO Auto-generated method stub
//		
//		CollaboratorsData collaData=new CollaboratorsData();
//		ContributorsData contrData= new ContributorsData();
//		String collaUrl="http://gitmining.net/api/repository/";
//		String	contrUrl="http://gitmining.net/api/repository/";
		
		
		ArrayList<RepositoryPO> list=new ArrayList<RepositoryPO>();
		JSONObject obj = new JSONObject();
	//	FileReader fr = new FileReader(new File( "src/main/java/txtData/all_repository.json"));
		BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().
				getResourceAsStream("/txtData/all_repository.json")));
		String string = br.readLine();
		String s1 ,s2,s3,s4,name;
		boolean fork;
		JSONArray obj1 = new JSONArray(string);
		int size=0;
		int stargazers_count=0;
		int collaborators_count=0;
	
		int forks = 0,issues_count=0,subscribers_count=0,contributor=0;
		for (int j = 0; j < obj1.length(); j++) {
			obj = obj1.getJSONObject(j);
			
			
			if(obj.has("description")){
				s1=obj.getString("description");
			}else{
				s1="";
			}
			if(obj.has("fork")){
				fork=obj.getBoolean("fork");
			}else{
				fork=true;
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
			
			if(obj.has("type")){
				s2=obj.getString("type");
			}else{
				s2="";
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
			
			if(obj.has("collaborators_count")){
				 collaborators_count=obj.getInt("collaborators_count");
			}
			if(obj.has("full_name")){
				name=obj.getString("full_name");
			}else{
				name="";
			}
			
			RepositoryPO po=new RepositoryPO(name,obj.getInt("id") ,s2, 
					obj.getString("html_url"), s1, fork, obj.getString("created_at"),
					obj.getString("updated_at"), s3, size, stargazers_count, 
					s4,forks ,issues_count,subscribers_count ,contributor,  collaborators_count,
					null,null);
			list.add(po);
			}
		finalList=list;
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
	//	FileReader fr = new FileReader(new File( "/src/main/java/txtData/repo_names.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().
				getResourceAsStream("/txtData/repo_names.txt")));
		String temp ;
		ArrayList<String> list=new ArrayList<String>();
		while((temp=br.readLine())!=null){
			list.add(temp);
		}
		return list;
	}

	public RepositoryPO checkRepository(String userName, String reponame) throws IOException {
		// TODO Auto-generated method stub
		CollaboratorsData collaData = new CollaboratorsData();
		ContributorsData contrData = new ContributorsData();
		String collaUrl = "http://gitmining.net/api/repository/";
		String contrUrl = "http://gitmining.net/api/repository/";
		ArrayList<RepositoryPO> list = new RepositoryData().getRepositories();

		
		
		for (int j = 0; j < list.size(); j++) {
			collaUrl = "http://gitmining.net/api/repository/"+list.get(j).getName()+
					"/collaborators/login";
			contrUrl="http://gitmining.net/api/repository/"+list.get(j).getName()+
					"/contributors/login";
			String[] s = list.get(j).getName().split("/");
			if (s[0].equals(userName) && s[1].equals(reponame)) {
				list.get(j).setCollaborators(collaData.getCollaborators(collaUrl));
				list.get(j).setContributors(contrData.getContributors(contrUrl));
				return list.get(j);
			}
		}
		return null;
	}

	public StaStrPO languagesOfRepository(String userName, String reponame) throws IOException {
		// TODO Auto-generated method stub
		String str1="http://gitmining.net/api/repository"+"/"+userName+"/"
				+reponame+"/"+"languages";
		ArrayList<String> list=new GetData().getString(str1);
		ArrayList<String> listStr=new ArrayList<>();
		ArrayList<Integer> listInt=new ArrayList<>();
		for(int i=0;i<list.size()-1;i++){
			String str[]=list.get(i).split(":");
			listStr.add(str[0]);
			listInt.add(Integer.parseInt(str[1]));
		}
		
		return new StaStrPO(listStr, listInt);
	}
	
	
	/**
	 * 
	 * 查询某个fork项目的某项信息
	 * @throws IOException 
	 * 
	 */
//	public String RepositoryInfo(String userName, String reponame, Util.RepositoryInfo info) throws IOException {
//		JSONObject obj = new JSONObject();
//	//	FileReader fr = new FileReader(new File("src/main/java/txtData/all_repository.json"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().
//				getResourceAsStream("/txtData/all_repository.json")));
//		String string = br.readLine();
//		JSONArray obj1 = new JSONArray(string);
//		for (int i = 0; i < obj1.length(); i++) {
//			obj = (JSONObject) obj1.get(i);
//			if (obj.has("full_name")) {
//				if (obj.getString("full_name").equals(userName + "/" + reponame)) {
//					if (info.toString().equals("fork") && obj.has("fork")) {
//						return obj.getBoolean("fork") + "";
//					}
//				} else if (info.toString().equals("id") || info.toString().equals("size")
//						|| info.toString().equals("forks") || info.toString().equals("stargazers_count")
//						|| info.toString().equals("open_issues") || info.toString().equals("subscribers_count")) {
//					if (obj.has(info.toString())) {
//						return obj.getInt(info.toString()) + "";
//					}
//				} else {
//					if (obj.has(info.toString())) {
//						return obj.getString(info.toString());
//					}
//				}
//			}
//
//		}
//
//		return null;
//	}

	public ArrayList<RepositoryPO> Search(String name) throws IOException {
		 ArrayList<RepositoryPO> pos=finalList;
		 String[]  str=new String[2];
			for(RepositoryPO po:getRepositories()){
	            str=po.getName().split("/");
				if(str[1].contains(name)){
	                pos.add(po);
	            }
	        }
			finalList=pos;
			return pos;
		
	}

	public ArrayList<RepositoryPO> sort( Repository_Sort sort) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<RepositoryPO> list=finalList;
		if(sort==Repository_Sort.contributor){
		
		for(int j=0;j<list.size()-1;j++){
			for(int i=j;i<list.size()-1;i++){
				if(list.get(j).getContributor()<=list.get(i+1).getContributor()){
					RepositoryPO temp=list.get(j);
					list.set(j, list.get(i+1));
					list.set(i+1, temp);
					
					}
				}
			}
		}else if(sort==Repository_Sort.fork){
			for(int j=0;j<list.size()-1;j++){
				for(int i=j;i<list.size()-1;i++){
					if(list.get(j).getForks()<=list.get(i+1).getForks()){
						RepositoryPO temp=list.get(j);
						list.set(j, list.get(i+1));
						list.set(i+1, temp);
						
						}
					}
				}
		}else if(sort==Repository_Sort.star){
			for(int j=0;j<list.size()-1;j++){
				for(int i=j;i<list.size()-1;i++){
					if(list.get(j).getStargazers()<=list.get(i+1).getStargazers()){
						RepositoryPO temp=list.get(j);
						list.set(j, list.get(i+1));
						list.set(i+1, temp);
						}
					}
				}
		}
		finalList=list;
		return list;
	}

	@Override
	public ArrayList<RepositoryPO> screenLanguage(String language) throws IOException {
		// TODO Auto-generated method stub
		//ArrayList<RepositoryPO> list=new RepositoryData().getRepositories();
		ArrayList<RepositoryPO> list=finalList;
		ArrayList<RepositoryPO> list2=new ArrayList<>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getLanguage().equals(language)){
				list2.add(list.get(i));
			}
		}
		finalList=list2;
		return list2;
	}

	@Override
	public ArrayList<RepositoryPO> screenTime(String time) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<RepositoryPO> list1=new ArrayList<>();
		//ArrayList<RepositoryPO> list=new RepositoryData().getRepositories();
		ArrayList<RepositoryPO> list=finalList;//有bug
		
		for(int i=0;i<list.size();i++){
			String[] str = list.get(i).getCreated().substring(0, 10).split("-");
			String str1 = str[0];
			int year = Integer.parseInt(str1);
			if(Integer.parseInt(time.substring(0,4))==year){
				list1.add(list.get(i));
			}
		}
		finalList=list1;
		return list1;
	}

	@Override
	public ArrayList<RepositoryPO> screenCategory(String key) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<RepositoryPO> list=finalList;
		ArrayList<RepositoryPO> list2=new ArrayList<>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getDescription().contains(key)){
				list2.add(list.get(i));
			}
		}
		finalList=list2;
		return list2;
	}

	
}
