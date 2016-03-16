package data;

import dataService.UserDataService;
import org.json.JSONArray;
import org.json.JSONObject;
import po.UserPO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class UserData implements UserDataService {

	static String string = "http://www.gitmining.net/api/user";

	public UserPO CheckUser(String user) throws IOException {
		JSONObject obj = new JSONObject();
		FileReader fr = null;
//		try {
//			fr = new FileReader(new File(this.getClass().getResource("/txtData/users.json").toURI()));
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		}
		BufferedReader br = new BufferedReader(new InputStreamReader(
                this.getClass().getResourceAsStream("/txtData/users.json")
        ));
		String string = br.readLine();
		JSONArray obj1 = new JSONArray(string);
		
		for (int j = 0; j < obj1.length(); j++) {
			obj = obj1.getJSONObject(j);
			if (user.equals(obj.getString("login"))) {
				String s1, s2, s3,s4;

				if (obj.has("company")) {
					s1 = obj.getString("company");
				} else {
					s1 = " ";
				}
				if (obj.has("email")) {
					s2 = obj.getString("email");
				} else {
					s2 = "";
				}

				if (obj.has("repos_url")) {
					s3 = obj.getString("repos_url");
				} else {
					s3 = "";
				}

				if (obj.has("name")) {
					s4 = obj.getString("name");
				} else {
					s4 = "";
				}
				
				return new UserPO(obj.getInt("id"), obj.getString("login"), obj.getString("type"),
						s4, s1, s2, s3, obj.getInt("public_gists"), obj.getInt("followers"),
						obj.getInt("following"), obj.getString("created_at"), obj.getString("updated_at"));
			}
		}
		return null;

	}

	public String UserInfo(String user, Util.UserInfo info) throws IOException {
		// TODO Auto-generated method stub
		JSONObject obj = new JSONObject();
		FileReader fr = null;
//		try {
//			fr = new FileReader(new File(this.getClass().getResource("/txtData/users.json").toURI()));
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		}
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

	// TODO Auto-generated method stub

	public ArrayList<UserPO> search(String name) throws IOException {
		// TODO Auto-generated method stub
//		FileReader fr = null;
//		try {
//			fr = new FileReader(new File(this.getClass().getResource("/txtData/user_names.txt").toURI()));
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		}
//		BufferedReader br = new BufferedReader(fr);
//		String temp;
//		ArrayList<UserPO> list = new ArrayList<UserPO>();
//		while ((temp = br.readLine()) != null) {
//			if (temp.contains(name)) {
//				list.add(new UserData().CheckUser(temp));
//			}
//		}
		ArrayList<UserPO> list1=new ArrayList<>();
		ArrayList<UserPO> list=this.getUser();
		for(UserPO po:list){
			if(po.getLogin().contains(name)){
				list1.add(po);
			}
		}
		return list1;
	}

	public ArrayList<UserPO> getUser() throws IOException {
		// TODO Auto-generated method stub
		
		ArrayList<UserPO> list = new ArrayList<UserPO>();
		JSONObject obj = new JSONObject();
		FileReader fr = null;
//		try {
//			fr = new FileReader(new File(this.getClass().getResource("/txtData/users.json").toURI()));
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		}
		BufferedReader br = new BufferedReader(
				new InputStreamReader(this.getClass().getResourceAsStream("/txtData/users.json")));
		String string = br.readLine();
		JSONArray obj1 = new JSONArray(string);
		for (int j = 0; j < obj1.length(); j++) {
			obj = obj1.getJSONObject(j);
			String s1, s2, s3,s4;

				if (obj.has("company")) {
					s1 = obj.getString("company");
				} else {
					s1 = " ";
				}
				if (obj.has("email")) {
					s2 = obj.getString("email");
				} else {
					s2 = "";
				}

				if (obj.has("repos_url")) {
					s3 = obj.getString("repos_url");
				} else {
					s3 = "";
				}

				if (obj.has("name")) {
					s4 = obj.getString("name");
				} else {
					s4 = "";
				}
				
				list.add(new UserPO(obj.getInt("id"), obj.getString("login"), obj.getString("type"),
						s4, s1, s2, s3, obj.getInt("public_gists"), obj.getInt("followers"),
						obj.getInt("following"), obj.getString("created_at"), obj.getString("updated_at")));
			}
		

		return list;
	}

	public ArrayList<String> NamesOfSubscriber(String userName, String reponame) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
}
