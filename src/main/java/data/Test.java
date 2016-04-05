package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import Util.Repository_Sort;
import Util.User_Sort;
import businesslogic.userBL.User;

import java.util.Set;

import po.RepositoryPO;
import po.StaIntPO;
import po.StaStrPO;
import po.StatisticsPO;
import po.UserPO;



public class Test {
	public static void main(String[] args) throws IOException{
		ArrayList<RepositoryPO> list=new RepositoryData().getRepositories();
		list=new RepositoryData().screenTime("200900");
		list=new RepositoryData().screenLanguage("Ruby");
	
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getLanguage()+":"+list.get(i).getStargazers());
			
		}
	}
}
