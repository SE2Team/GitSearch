package data;

import java.io.IOException;
import java.util.ArrayList;

import businesslogic.userBL.User;
import dataService.UserDataService;
import po.UserPO;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class UserData implements UserDataService{

	static String string="http://www.gitmining.net/api/user";
	public ArrayList<UserPO> CheckUser(User user) throws IOException {
		// TODO Auto-generated method stub
		String str1=string+"/";
		ArrayList<String> list=new ArrayList<String>();
		list = new GetData().getString(str1);
		return null;
	}

	public String UserInfo(User user, Util.UserInfo info) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<UserPO> getStargazers( String userName, String reponame) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getStargazerNames( String userName, String reponame) throws IOException {
		// TODO Auto-generated method stub
		String str1=string+"/"+userName+"/"+reponame;
		ArrayList<String> list=new ArrayList<String>();
		list = new GetData().getString(str1);
		return list;
		
	}

	public ArrayList<UserPO> getSubscribers( String userName, String reponame) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> NamesOfSubscriber( String userName, String reponame) throws IOException {
		// TODO Auto-generated method stub
		String str1=string+"/"+userName+"/"+reponame;
		ArrayList<String> list=new ArrayList<String>();
		list = new GetData().getString(str1);
		return list;
		
	}

	public UserPO search(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
