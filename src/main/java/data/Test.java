package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import businesslogic.userBL.User;

import java.util.Set;

import po.RepositoryPO;
import po.StaIntPO;
import po.StaStrPO;
import po.StatisticsPO;
import po.UserPO;



public class Test {
	public static void main(String[] args) throws IOException{
		ArrayList<UserPO> list=new UserData().getUser();
		UserPO po=null;
		GetData get=new GetData("has");
		UserData data=new UserData();
		for(int i=0;i<list.size();i++){
			po=data.CheckUser(list.get(i).getLogin());
			get.writeDataAdd(po.getLogin()+";"+po.getHas().size());
		}
		
		GetData get2=new GetData("related");
		for(int i=0;i<list.size();i++){
			po=data.CheckUser(list.get(i).getLogin());
			get2.writeDataAdd(po.getLogin()+";"+po.getRelated().size());
		}
		System.out.println("Success");
	}
}
