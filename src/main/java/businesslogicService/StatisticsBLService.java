package businesslogicService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

import po.RepositoryPO;
import po.StaStrPO;
import po.StatisticsPO;
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

	Iterator<StaStrVO> getStar() throws IOException;
	
	StatisticsVO getScores(RepositoryPO po) throws IOException;
	
	Iterator<StaStrVO> getForks() throws IOException;
	
	Iterator<StaStrVO> getRepoCreated() throws IOException;
	
	Iterator<StaStrVO> getLanguage() throws IOException;
	
	Iterator<StaStrVO>  getUserCreated() throws IOException;
	
	Iterator<StaStrVO> getUserType() throws IOException;
	
	Iterator<StaIntVO> getUserHas();
	
	Iterator<StaIntVO> getUserRelated();
	
	Iterator<StaStrVO> getCompany() throws IOException;
}
