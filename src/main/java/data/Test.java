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
//		RepositoryData data=new RepositoryData();
//		GetData data2=new GetData("LanguageSituation");
//	ArrayList<RepositoryPO> list=new RepositoryData().getRepositories();
//	for(int i=0;i<list.size();i++){
//		String[] str=list.get(i).getName().split("/");
//		StaStrPO po=data.languagesOfRepository(str[0], str[1]);
//		String string="";
//		for(int j=0;j<po.getInt().size();j++){
//			string=string+";"+po.getInt();
//		}
//		string=string+":";
//		for(int j=0;j<po.getStr().size();j++){
//			string=string+";"+po.getStr();
//		}
//		string=string+":";
//		string=string+list.get(i).getName();
//		data2.writeDataAdd(string);
//		}
	StaStrPO po=new StatisticsData().getCollaborator();
	for(int i=0;i<po.getInt().size();i++){
		System.out.println(po.getStr().get(i)+":"+po.getInt().get(i));
	}
	}
}