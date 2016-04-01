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
//		RepositoryData data=new RepositoryData();
//		RepositoryPO po=data.checkRepository("mojombo","grit");
//		for(int i=0;i<po.getCollaborators().size();i++){
//			System.out.print(po.getCollaborators().get(i)+",");
//		}
//		System.out.println("");
//		for(int i=0;i<po.getContributors().size();i++){
//			System.out.print(po.getContributors().get(i)+",");
//		}
		UserData data=new UserData();
		UserPO po=data.CheckUser("mojombo");
		for(int i=0;i<po.getRelated().size();i++){
			System.out.println(po.getRelated().get(i));
		}
	}
}
