package data;

import java.io.IOException;
import java.util.ArrayList;

import Util.Repository_Sort;
import po.RepositoryPO;
import po.UserPO;


public class Test {
	public static void main(String[] args) throws IOException{
		ArrayList<RepositoryPO> list=new RepositoryData().sort(Repository_Sort.fork);
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getForks());
		}
//		UserPO po=new UserData().CheckUser("macournoyer");
//		System.out.println(po.getEmail());
	}
}
