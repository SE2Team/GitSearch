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
		
//	for(int i=0;i<list2.size();i++){
//			for(int p=i;p<list2.size()-1;p++){
//				if(list2.get(i)>list2.get(p)){
//					temp=list2.get(p);
//					list2.set(p, list2.get(i));
//					list2.set(i, temp);
//	
//				}
//			}
//		}
//	从小到大排序
		
		
		
//		ArrayList<UserPO> list=new UserData().getUser();
//		ArrayList<String> list2=new ArrayList<String>();
//		for(int i=0;i<list.size();i++){
//			if(list2.contains(list.get(i).getCompany())==false){
//				list2.add(list.get(i).getCompany());
//				System.out.println(list.get(i).getCompany());
//			}
//		}
//		System.out.println(list2.size());
		
		ArrayList<RepositoryPO> list=new RepositoryData().Search("ai");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getName());
		}
		
	}
}
