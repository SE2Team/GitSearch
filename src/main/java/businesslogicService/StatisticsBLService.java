package businesslogicService;

import java.io.IOException;
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

	ObservableList<StatisticsVO> getScore();
	
	StatisticsVO getScores(RepositoryPO po);
}
