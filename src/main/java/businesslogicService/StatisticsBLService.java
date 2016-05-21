package businesslogicService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

import po.RepositoryPO;
import po.StaStrPO;
import po.StatisticsPO;
import vo.RepositoryVO;
import vo.StaIntVO;
import vo.StaStrVO;
import vo.StatisticsVO;
import javafx.collections.ObservableList;
/** 
 * @author 
 * @date 
2016骞�3鏈�16鏃� 
涓嬪崍4:33:10 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 *@throws 寮傚父绫诲強鎶涘嚭鏉′欢
 */
public interface StatisticsBLService {

	StaStrVO getStar() throws IOException;
	
	StaStrVO getScores(RepositoryVO vo) throws IOException;
	
	StaStrVO getForks() throws IOException;
	
	StaStrVO getRepoCreated() throws IOException;
	
	StaStrVO getLanguage() throws IOException;
	
	StaStrVO  getUserCreated() throws IOException;
	
	StaStrVO getUserType() throws IOException;
	
	StaIntVO getUserHas();
	
	StaIntVO getUserRelated();
	
	StaStrVO getCompany() throws IOException;
	
	Integer getHasNum(String name);
	
	StaStrVO getCollaborator();
	
	StaStrVO getContributor();
	
	StaStrVO getFollowers();
	
	StaStrVO getAll_RepoCreated();
	
	StaStrVO getAll_UserCreated();
	
	StaStrVO getAll_Star(); 
	
	StaStrVO getAll_Fork(); 
}
