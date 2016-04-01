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
		UserData userData=new UserData();
		UserPO po=null;
		ArrayList<UserPO> list=new UserData().getUser();
		System.out.println("Success");
		for(int i=0;i<list.size();i++){
			po=userData.CheckUser(list.get(i).getLogin());
			new GetData("related").writeDataAdd(list.get(i).getLogin()+";"+po.getRelated().size());
			
		}
		System.out.println("Success");
	}
}
