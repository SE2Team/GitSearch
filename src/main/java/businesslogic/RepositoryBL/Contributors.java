package businesslogic.RepositoryBL;

import java.io.IOException;
import java.util.Iterator;

import vo.UserVO;
import data.DataFactory;
import dataService.DataFatoryService;


/** 
 * @author 
 * @date 
2016年3月24日 
上午10:20:34 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 *@throws 异常类及抛出条件
 */
public class Contributors {

	private DataFatoryService factory=new DataFactory();
	public Iterator<UserVO> NamesOfContributors(String userName, String reponame){
		return null;
	}
	
	public Iterator<String> getContributors(String userName, String reponame){
		Iterator<String> itr=null;
		try {
			itr=factory.getContributorsDataService().getContributors(reponame).iterator();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itr;
	}
}
