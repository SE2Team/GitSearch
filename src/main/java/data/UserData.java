package data;

import java.util.ArrayList;

import businesslogic.userBL.User;
import dataService.UserDataService;
import po.UserPO;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class UserData implements UserDataService{

	public ArrayList<UserPO> CheckUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public String UserInfo(User user, Util.UserInfo info) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<UserPO> getStargazers(User user, String userName, String reponame, int pageNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getStargazerNames(User user, String userName, String reponame, int pageNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getSubscribers(User user, String userName, String reponame, int pageNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> NamesOfSubscriber(User user, String userName, String reponame, int pageNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserPO search(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
