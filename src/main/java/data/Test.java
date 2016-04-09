package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import Util.RepositoryInfo;
import Util.Repository_Sort;
import Util.User_Sort;
import businesslogic.userBL.User;

import java.util.Set;

import po.RepositoryPO;
import po.ScreenPO;
import po.StaIntPO;
import po.StaStrPO;
import po.StatisticsPO;
import po.UserPO;



public class Test {
	public static void main(String[] args) throws IOException{
		
//		ArrayList<RepositoryPO> list=new RepositoryData().screen(new ScreenPO("2008", "Ruby", ""));
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).getLanguage()+":"+list.get(i).getCreated());
//		}
		ArrayList<RepositoryPO> list=new RepositoryData().getRepositories();
		ArrayList<RepositoryPO> list1=new RepositoryData().sort(Repository_Sort.fork);
		System.out.println(list1.get(0).getCreated());
		System.out.println(list.get(0).getCreated());
	}
}
