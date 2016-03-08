package data;

import java.util.ArrayList;
import java.util.Map;

import dataService.RepositoryDataService;
import po.RepositoryPO;
import vo.RepositoryVO;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class RepositoryData implements RepositoryDataService {

	public ArrayList<RepositoryVO> getRepositories() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getRepositoriesNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public RepositoryPO checkRepository(String userName, String reponame) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Integer> languagesOfRepository(String userName, String reponame) {
		// TODO Auto-generated method stub
		return null;
	}

	public String RepositoryInfo(String userName, String reponame, Util.RepositoryInfo info) {
		// TODO Auto-generated method stub
		return null;
	}

	public RepositoryPO Search(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
