package data;

import java.io.IOException;
import java.util.ArrayList;

import Util.Repository_Sort;
import Util.UserInfo;
import po.RepositoryPO;
import po.UserPO;


public class Test {
	public static void main(String[] args) throws IOException{
//		ArrayList<RepositoryPO> list=new RepositoryData().sort(Repository_Sort.fork);
//		
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).getForks());
//		}
//		UserPO po=new UserData().CheckUser("macournoyer");
//		System.out.println(po.getEmail());
//		ArrayList<UserPO> list=new UserData().getUser(); 
//		System.out.println(list.get(2).getLogin());
//		String s1,s2,s3;
//		s1=new UserData().UserInfo("mojombo", UserInfo.login);
//		s2=new UserData().UserInfo("technoweenie", UserInfo.email);
//		s3=new UserData().UserInfo("macournoyer", UserInfo.name);
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s3);
		ArrayList<UserPO> list=new UserData().search("mbo");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getEmail());
		}
		
				}
}
