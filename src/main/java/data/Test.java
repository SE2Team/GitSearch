package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

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
		ArrayList<UserPO> list=new UserData().sortUser(User_Sort.HAS);
		for(int i=1850;i<list.size();i++){
			System.out.println(new UserData().CheckUser
					(list.get(i).getLogin()).getHas().size());
		}
		System.out.println("Success");
		
	}
}
