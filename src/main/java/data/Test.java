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
import po.StaIntPO;
import po.StaStrPO;
import po.StatisticsPO;
import po.UserPO;



public class Test {
	public static void main(String[] args) throws IOException{
	//	StaStrPO po=new RepositoryData().languagesOfRepository("mojombo", "grit");
		StaStrPO po=new StatisticsData().getLanguage();
		for(int i=0;i<po.getInt().size();i++){
			
		System.out.println(po.getInt().get(i));
			
		}
	}
}
