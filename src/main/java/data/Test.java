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
	StaStrPO po=new StatisticsData().getCollaborator();
	
	for(int i=0;i<po.getInt().size();i++){
		System.out.println(po.getStr().get(i)+":"+po.getInt().get(i));
		}	
	}
}