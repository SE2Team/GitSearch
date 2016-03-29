package businesslogicService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

import po.RepositoryPO;
import po.StatisticsPO;
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

	Map<String,Integer> getStar() throws IOException;
	
	StatisticsVO getScores(RepositoryPO po) throws IOException;
	
	Map<String,Integer> getForks() throws IOException;
	
	Map<String,Integer> getRepoCreated() throws IOException;
	
	Map<String, Integer> getLanguage() throws IOException;
	
	Map<String, Integer>  getUserCreated() throws IOException;
	
	Map<String, Integer> getUserType() throws IOException;
	
	Map<Integer, Integer> getUserHas();
	
	Map<Integer, Integer> getUserRelated();
}
