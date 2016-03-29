package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import Util.User_Sort;
import dataService.UserDataService;
import po.RepositoryPO;
import po.UserPO;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class UserData implements UserDataService {

	static String string = "http://www.gitmining.net/api/user";

	public UserPO CheckUser(String user) throws IOException {

		ArrayList<UserPO> list = new UserData().getUser();
		ArrayList<String> list3 = new ArrayList<String>();
		ArrayList<String> relatedRepo = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getLogin().equals(user)) {
				ArrayList<RepositoryPO> list2 = this.searchRepoName(user);
				for (int j = 0; j < list2.size(); j++) {
					list3.add(list2.get(j).getName());
				}

				ArrayList<String> related = new GetData("contributor").readData();
				for (int p = 0; p < related.size(); p++) {
					if (this.isEqual(related.get(p), user)) {
						String[] str = related.get(p).split(";");
						relatedRepo.add(str[str.length - 1]);
					}
				}

				ArrayList<String> colla = new GetData("collaborator").readData();
				for (int p = 0; p < colla.size(); p++) {
					if (this.isEqual(colla.get(p), user)) {
						String[] str = colla.get(p).split(";");
						relatedRepo.add(str[str.length - 1]);
					}
				}

				list.get(i).setRelated(relatedRepo);
				list.get(i).setHas(list3);
				return list.get(i);
			}
		}
		return null;

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
		ArrayList<UserPO> list = new UserData().getUser();

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

		ArrayList<UserPO> list = new ArrayList<UserPO>();
		JSONObject obj = new JSONObject();

		// FileReader fr = new FileReader(new
		// File("src/main/java/txtData/users.json"));
		BufferedReader br = new BufferedReader(
				new InputStreamReader(this.getClass().getResourceAsStream("/txtData/users.json")));
		String string = br.readLine();
		JSONArray obj1 = new JSONArray(string);
		for (int j = 0; j < obj1.length(); j++) {

			obj = obj1.getJSONObject(j);
			String s1, s2, s3, s4;

			if (obj.has("company")) {
				s1 = obj.getString("company");
			} else {
				s1 = "";
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

			list.add(new UserPO(obj.getInt("id"), obj.getString("login"), obj.getString("type"), s4, s1, s2, s3,
					obj.getInt("public_gists"), obj.getInt("followers"), obj.getInt("following"),
					obj.getString("created_at"), obj.getString("updated_at"), null, null));
		}

		return list;
	}

	public ArrayList<String> NamesOfSubscriber(String userName, String reponame) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<UserPO> sortUser(User_Sort sort) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<UserPO> list = new UserData().getUser();
		if (sort == User_Sort.Followers) {
			for (int j = 0; j < list.size() - 1; j++) {
				for (int i = j; i < list.size() - 1; i++) {
					if (list.get(j).getFollowers() <= list.get(i + 1).getFollowers()) {
						UserPO temp = list.get(j);
						list.set(j, list.get(i + 1));
						list.set(i + 1, temp);

					}
				}
			}
		} else if (sort == User_Sort.Following) {
			for (int j = 0; j < list.size() - 1; j++) {
				for (int i = j; i < list.size() - 1; i++) {
					if (list.get(j).getFollowing() <= list.get(i + 1).getFollowing()) {
						UserPO temp = list.get(j);
						list.set(j, list.get(i + 1));
						list.set(i + 1, temp);

					}
				}
			}
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
}
