package businesslogic.RepositoryBL;

import java.util.Iterator;

import vo.UserVO;

/** 
 * @author 
 * @date 
2016��3��24�� 
����10:21:06 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 *@throws �쳣�༰�׳�����
 */
public class ContributorsController {
	Contributors contributors=new Contributors();
	public Iterator<UserVO> NamesOfContributors(String userName, String reponame){
		return null;
	}
	
	public Iterator<String> getContributors(String userName, String reponame){
		return contributors.getContributors(userName, reponame);
	}
}
