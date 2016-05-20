package data;


import java.io.IOException;
import java.util.ArrayList;

import po.RepositoryPO;
import po.UserPO;


public class Test {
	public static void main(String[] args) throws IOException{
		APIConnection.initAPIConnection();
//		RepositoryData data=new RepositoryData();
//		//System.out.print(data.getUser().get(1).getLogin());
//		ArrayList<RepositoryPO> list=data.getRepositories();
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).getUpdated());
//		}
		UserData data=new UserData();
		ArrayList<UserPO> list=data.getUser();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getPublicRepoCount());
		}

	}
}