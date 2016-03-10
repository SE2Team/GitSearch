package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import dataService.RepositoryDataService;
import po.RepositoryPO;


/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class RepositoryData implements RepositoryDataService {
	
	static String string="http://www.gitmining.net/api/repository";
	/**
	 * 
	 * json格式项目详情列表，一页50个，不加?page=则默认显示第一页内容
	 * @throws IOException 
	 * 
	 */
	public ArrayList<RepositoryPO> getRepositories() throws IOException{
		// TODO Auto-generated method stub
		String str1=string;
		ArrayList<String> list=new ArrayList<String>();
		list = new GetData().getString(str1);
		ArrayList<RepositoryPO> list1=new ArrayList<RepositoryPO>();
		return null;
	}
	
	/**
	 * 
	 * 所有项目全称列表（项目全称=owner登录名/项目名），返回值为String类型的数组
	 * @throws IOException 
	 * 
	 */
	public ArrayList<String> getRepositoriesNames() throws IOException {
		// TODO Auto-generated method stub
		String str1=string+"/names";
		ArrayList<String> list=new ArrayList<String>();
		list = new GetData().getString(str1);
	
		return list;
	}

	public RepositoryPO checkRepository(String userName, String reponame) throws IOException {
		// TODO Auto-generated method stub
		String str1=string+"/"+userName+"/"+reponame;
		ArrayList<String> list=new ArrayList<String>();
		list = new GetData().getString(str1);
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
