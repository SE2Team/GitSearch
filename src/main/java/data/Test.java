package data;

import java.io.IOException;
import java.util.ArrayList;

import Util.Repository_Sort;
import Util.UserInfo;
import Util.User_Sort;
import po.RepositoryPO;
import po.UserPO;


public class Test {
	public static void main(String[] args) throws IOException{
//		ArrayList<String> list=new ContributorsData().getContributors("http://gitmining.net"
//				+ "/api/repository/mojombo/grit/contributors/login");
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i));
//		}	
//		ArrayList<RepositoryPO> list=new RepositoryData().Search("mojombo");
//		ArrayList<String> list1 = null;
		
//		ArrayList<RepositoryPO> list=new RepositoryData().Search("mojombo");
	
		
//		RepositoryPO po=new RepositoryData().checkRepository("mojombo", "grit");
		UserPO po=new UserData().CheckUser("mojombo");
		ArrayList<String> list=po.getHas();
				for(int i=0;i<list.size();i++){
					System.out.println(list.get(i));
				}
		//	list1.add(list.get(i).getName());
//		}
		
	}
}
