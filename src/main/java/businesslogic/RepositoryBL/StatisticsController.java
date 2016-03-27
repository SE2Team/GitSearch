package businesslogic.RepositoryBL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

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
	public Iterator<Integer> getStar() throws IOException{
		return statistics.getStar();
	}
	
	public StatisticsVO getScores(RepositoryPO po) throws IOException{
		return statistics.getScore(po);
	}
	
	public Iterator<Integer> getForks() throws IOException{
		return statistics.getForks();
	}
	
	public Iterator<Integer> getCreated() throws IOException{
		return statistics.getCreated();
	}

	public Map<String, Integer> getLanguage() throws IOException{
		return statistics.getLanguage();
	}
}
