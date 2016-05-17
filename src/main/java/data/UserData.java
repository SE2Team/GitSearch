package data;

import Util.User_Sort;
import dataService.UserDataService;
import org.json.JSONArray;
import org.json.JSONObject;


import po.RepositoryPO;
import po.UserPO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class UserData implements UserDataService {

	static String string = "http://www.gitmining.net/api/user";
	
	static ArrayList<UserPO> userList=new ArrayList<>(); 
	
	UserData data=new UserData();
	JDBCHelper helper=new JDBCHelper();
	
		
	public UserPO CheckUser(String user) throws IOException {

//		ArrayList<UserPO> list = data.getUser();
//		ArrayList<String> list3 = new ArrayList<String>();
//		ArrayList<String> relatedRepo = new ArrayList<String>();
//		UserPO po=null;
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i).getLogin().equals(user)) {
//				ArrayList<RepositoryPO> list2 = this.searchRepoName(user);
//				for (int j = 0; j < list2.size(); j++) {
//					list3.add(list2.get(j).getName());
//				}
//
//				ArrayList<String> related = new GetData("contributor").readData();
//				for (int p = 0; p < related.size(); p++) {
//					if (this.isEqual(related.get(p), user)) {
//						String[] str = related.get(p).split(";");
//						if(relatedRepo.contains(str[str.length - 1])==false){
//						relatedRepo.add(str[str.length - 1]);
//						}
//					}
//				}
//
//				ArrayList<String> colla = new GetData("collaborator").readData();
//				for (int p = 0; p < colla.size(); p++) {
//					if (this.isEqual(colla.get(p), user)) {
//						String[] str = colla.get(p).split(";");
//						if(relatedRepo.contains(str[str.length - 1])==false){
//							relatedRepo.add(str[str.length - 1]);
//							}
//					}
//				}
//
//				list.get(i).setRelated(relatedRepo);
//				list.get(i).setHas(list3);
//				po=list.get(i);
//			}
//		}
//		if(po==null){
//			po=this.CheckUserLine(user);
//		}
		return helper.checkUser(user);

	}

	public String UserInfo(String user, Util.UserInfo info) throws IOException {
		// TODO Auto-generated method stub
		JSONObject obj = new JSONObject();
		// FileReader fr = new FileReader(new
		// File("src/main/java/txtData/users.json"));
		BufferedReader br = new BufferedReader(
				new InputStreamReader(this.getClass().getResourceAsStream("/txtData/users.json")));
		String string = br.readLine();
		String s1 = "";
		JSONArray obj1 = new JSONArray(string);
		for (int j = 0; j < obj1.length(); j++) {
			obj = obj1.getJSONObject(j);
			if (user.equals(obj.getString("login"))) {
				if (info == Util.UserInfo.id || info == Util.UserInfo.followers || info == Util.UserInfo.following
						|| info == Util.UserInfo.public_gists) {
					if (obj.has(info.toString())) {
						s1 = obj.getInt(info.toString()) + "";
					}
				} else if (obj.has(info.toString())) {
					s1 = obj.getString(info.toString());
				} else {
					s1 = "";
				}
			}
		}
		return s1;
	}

	public ArrayList<String> getStargazers(String userName, String reponame) throws IOException {
		// TODO Auto-generated method stub
		String str1 = string + "/" + userName + "/" + reponame;
		ArrayList<String> list = new ArrayList<String>();
		list = new GetData().getString(str1);
		return list;

	}

	public ArrayList<String> getStargazerNames(String userName, String reponame) throws IOException {
		// TODO Auto-generated method stub
		return null;

	}

	public ArrayList<UserPO> getSubscribers(String userName, String reponame) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<UserPO> search(String name) throws IOException {
		// TODO Auto-generated method stub
		// FileReader fr = new FileReader(new
		// File("src/main/java/txtData/user_names.txt"));
		// BufferedReader br = new BufferedReader(new Input);
		ArrayList<UserPO> list = helper.getUsers();

		UserPO po;
		ArrayList<UserPO> list1 = new ArrayList<UserPO>();
		for (int i = 0; i < list.size(); i++) {
			po = list.get(i);
			if (po.getLogin().contains(name)) {
				list1.add(po);
			}
		}

		return list1;
	}

	public ArrayList<UserPO> getUser() throws IOException {
		// TODO Auto-generated method stub
		
		return helper.getUsers();
//		ArrayList<UserPO> list = new ArrayList<UserPO>();
//		JSONObject obj = new JSONObject();
//
//		// FileReader fr = new FileReader(new
//		// File("src/main/java/txtData/users.json"));
//		BufferedReader br = new BufferedReader(
//				new InputStreamReader(this.getClass().getResourceAsStream("/txtData/users.json")));
//		String string = br.readLine();
//		JSONArray obj1 = new JSONArray(string);
//		for (int j = 0; j < obj1.length(); j++) {
//
//			obj = obj1.getJSONObject(j);
//			String s1, s2, s3, s4;
//
//			if (obj.has("company")) {
//				s1 = obj.getString("company");
//			} else {
//				s1 = "";
//			}
//			if (obj.has("email")) {
//				s2 = obj.getString("email");
//			} else {
//				s2 = "";
//			}
//
//			if (obj.has("repos_url")) {
//				s3 = obj.getString("repos_url");
//			} else {
//				s3 = "";
//			}
//
//			if (obj.has("name")) {
//				s4 = obj.getString("name");
//
//			} else {
//				s4 = "";
//			}
//
//			list.add(new UserPO(obj.getInt("id"), obj.getString("login"), obj.getString("type"), s4, s1, s2, s3,
//					obj.getInt("public_gists"), obj.getInt("followers"), obj.getInt("following"),
//					obj.getString("created_at"), obj.getString("updated_at"), null, null));
//		}
//
//		userList=list;
//		return list;
	}

	public ArrayList<String> NamesOfSubscriber(String userName, String reponame) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<UserPO> sortUser(User_Sort sort) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<UserPO> list = userList;
		ArrayList<UserPO> listPO=helper.getUsers();
		if(list.size()==listPO.size()){
			listPO=list;
		}
		
		if (sort == User_Sort.Followers) {
			for (int j = 0; j < list.size() - 1; j++) {
				for (int i = j; i < list.size() - 1; i++) {
					if (list.get(j).getFollowersCount() <= list.get(i + 1).getFollowersCount()) {
						UserPO temp = list.get(j);
						list.set(j, list.get(i + 1));
						list.set(i + 1, temp);

					}
				}
			}
		} else if (sort == User_Sort.Following) {
			for (int j = 0; j < list.size() - 1; j++) {
				for (int i = j; i < list.size() - 1; i++) {
					if (list.get(j).getFollowingCount() <= list.get(i + 1).getFollowingCount()) {
						UserPO temp = list.get(j);
						list.set(j, list.get(i + 1));
						list.set(i + 1, temp);

					}
				}
			}
		}else if(sort==User_Sort.HAS){
			ArrayList<String> listHas = new GetData("has").readData();
			ArrayList<Integer> listInt = new ArrayList<Integer>();//拥有项目数
			ArrayList<String> listString=new ArrayList<String>();//用户名
			ArrayList<UserPO> list4=new ArrayList<>();
			String[] str=new String[2];
			for(int i=0;i<listHas.size();i++){
				str=listHas.get(i).split(";");
				listInt.add(Integer.parseInt(str[1]));
				listString.add(str[0]);
			}
			
			int tempInt = 0;
			String tempString = "";
			for (int i = 0; i < listInt.size(); i++) {
				for (int p = i; p < listInt.size() - 1; p++) {
					if (listInt.get(i) <= listInt.get(p+1)) {
						tempInt = listInt.get(p+1);
						listInt.set(p+1, listInt.get(i));
						listInt.set(i, tempInt);
				
						tempString = listString.get(p+1);
						listString.set(p+1, listString.get(i));
						listString.set(i, tempString);
					}
				}
			}
			
			for(int i=0;i<listString.size();i++){
				for(int p=0;p<list.size();p++){
					if(listString.get(i).equals(list.get(p).getLogin())){
						list4.add(list.get(p));
					}
				}
			}
			return list4;
		}

		return list;
	}

	/**
	 * 按照用户名搜索项目
	 * 
	 * @param name
	 * @return
	 * @throws IOException
	 */
	private ArrayList<RepositoryPO> searchRepoName(String name) throws IOException {
		ArrayList<RepositoryPO> list = new RepositoryData().getRepositories();
		ArrayList<RepositoryPO> list2 = new ArrayList<RepositoryPO>();
		String[] str = new String[2];
		for (int i = 0; i < list.size(); i++) {
			str = list.get(i).getName().split("/");
			if (str[0].equals(name)) {
				list2.add(list.get(i));			
				}
		}
		return list2;
	}

	private boolean isEqual(String str, String user) {
		String[] strs = str.split(";");
		for (int i = 0; i < strs.length - 1; i++) {
			if (strs[i].length() > 2) {
				if (strs[i].substring(1, strs[i].length() - 1).equals(user)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public ArrayList<UserPO> screenTime(String time) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<UserPO> list1=new ArrayList<>();
		//ArrayList<RepositoryPO> list=new RepositoryData().getRepositories();
		ArrayList<UserPO> list=helper.getUsers();;
		if(time.equals("")){
			return list;
		}
		
		for(int i=0;i<list.size();i++){
			@SuppressWarnings("deprecation")
			int year = list.get(i).getCreated().getYear();
			if(Integer.parseInt(time.substring(0,4))==year){
				list1.add(list.get(i));
			}
		}
		userList=list1;
		return list1;
	}
	
	
	
}
