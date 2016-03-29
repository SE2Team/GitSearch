package businesslogic.RepositoryBL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import businesslogicService.StatisticsBLService;
import dataService.StatisticsDataService;
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
public class StatisticsController implements StatisticsBLService{
	Statistics statistics=new Statistics();
	public Map<String,Integer> getStar() throws IOException{
		return statistics.getStar();
	}
	
	public StatisticsVO getScores(RepositoryPO po) throws IOException{
		return statistics.getScores(po);
	}
	
	public Map<String,Integer> getForks() throws IOException{
		return statistics.getForks();
	}
	
	public Map<String,Integer> getRepoCreated() throws IOException{
		return statistics.getRepoCreated();
	}

	public Map<String, Integer> getLanguage() throws IOException{
		return statistics.getLanguage();
	}
	
	public Map<String, Integer> getUserCreated() throws IOException{
		return statistics.getUserCreated();
	}
	
	public Map<String, Integer> getUserType() throws IOException{
		return statistics.getUserType();
	}
	
	public Map<Integer, Integer> getUserHas(){
		return statistics.getUserHas();
	}
	
	public Map<Integer, Integer> getUserRelated(){
		return statistics.getUserRelated();
	}
}
