package data;


import java.io.IOException;
import java.util.ArrayList;

import po.RepositoryPO;


public class Test {
	public static void main(String[] args) throws IOException{

		
//	Refresh refresh=new Refresh();
//	refresh.updateCollaCount();
//	refresh.updateContrCount();
//	refresh.updatedC();
//	refresh.updateHas();
//	refresh.updateRelated();
		ArrayList<RepositoryPO> list=new RepositoryData().getRepositories();
		System.out.println(list.get(6).getCollaborators_count());
		
	}
}