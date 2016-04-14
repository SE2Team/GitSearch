package data;

import java.awt.List;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import po.RepositoryPO;
import po.StaStrPO;
import po.UserPO;

public class Test {
	public static void main(String[] args) throws IOException{
//		ArrayList<String> listColl=new GetData("collaborator").readData();
//		ArrayList<String> listCont=new GetData("contributor").readData();
//		for(int i=0;i<listColl.size();i++){
//			listColl.set(i, listColl.get(i).substring(1, listColl.get(i).length()));
//			
//		}
//		for(int i=0;i<listCont.size();i++){
//			listCont.set(i, listCont.get(i).substring(1, listCont.get(i).length()));
//		}
//		new GetData("collaborator").clearData("collaborator");
//		new GetData("contributor").clearData("contributor");
//		new GetData("collaborator").writeData(listColl);
//		new GetData("contributor").writeData(listCont);


//		StatisticsData data=new StatisticsData();
//		StaStrPO po=data.getCollaborator();
//		for(int i=0;i<po.getStr().size();i++){
//			System.out.println(po.getStr().get(i)+":"+po.getInt().get(i));
//		}
		
	Refresh refresh=new Refresh();
	refresh.updatedC();

		
	}
}