package businesslogic.RepositoryBL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import vo.UserVO;
import data.DataFactory;
import dataService.DataFatoryService;

/**
 * Created by moeyui on 2016/3/7 0007.
 */
public class Collaborators {
	private DataFatoryService factory=new DataFactory();
	public Iterator<UserVO> NamesOfCollaborators(String userName,String repoName){
		return null;
	}
	
	public Iterator<String> getCollaboratros(String userName, String reponame){
		Iterator<String> itr=null;
		try {
			itr=factory.getCollaboratorsDataService().getCollaborators(reponame).iterator();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itr;
	}
}
