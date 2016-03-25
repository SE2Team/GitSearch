package businesslogic.RepositoryBL;

import java.io.IOException;

import po.RepositoryPO;
import po.StatisticsPO;
import javafx.collections.ObservableList;
import vo.StatisticsVO;

/** 
 * @author 
 * @date 
2016骞�3鏈�16鏃� 
涓嬪崍11:40:22 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 *@throws 寮傚父绫诲強鎶涘嚭鏉′欢
 */
public class StatisticsController {
	Statistics statistics=new Statistics();
	public ObservableList<StatisticsVO> getScore(){
		return statistics.getScore();
	}
	
	public StatisticsVO getScores(RepositoryPO po) throws IOException{
		return statistics.getScore(po);
	}
}
