package data;


import po.RepositoryPO;

import java.io.IOException;
import java.util.ArrayList;


public class Test {
	public static void main(String[] args) throws IOException{

		
//		Refresh refresh=new Refresh();
//		refresh.updatedLanguageSituation();
//		refresh.updateCollaCount();
//		refresh.updateContrCount();
//		refresh.updatedC();
//		refresh.updateHas();
//		refresh.updateRelated();
		ArrayList<RepositoryPO> list=new RepositoryData().getRepositories();
//		StaStrPO po=new StatisticsData().getScores(list.get(0));
//		System.out.println(po.getInt().get(2));
		System.out.println(list.get(0).getCollaborators_count());
	}
}