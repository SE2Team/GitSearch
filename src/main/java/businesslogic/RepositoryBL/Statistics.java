package businesslogic.RepositoryBL;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import po.RepositoryPO;
import po.StatisticsPO;
import javafx.collections.ObservableList;
import vo.PO2VO;
import vo.StatisticsVO;
import data.DataFactory;
import dataService.DataFatoryService;

/** 
 * @author 
 * @date 
2016骞�3鏈�16鏃� 
涓嬪崍11:40:02 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 *@throws 寮傚父绫诲強鎶涘嚭鏉′欢
 */
public class Statistics {

	private DataFatoryService factory=new DataFactory();
	public Map<String,Integer> getStar() throws IOException{
		return factory.getStatisticsDataService().getStar();
	}
	public StatisticsVO getScores(RepositoryPO po) throws IOException {
		// TODO Auto-generated method stub
		return PO2VO.convert(factory.getStatisticsDataService().getScores(po));
	}
	
	public Map<String,Integer> getForks() throws IOException{
		return factory.getStatisticsDataService().getForks();
	}
	
	public Map<String,Integer> getRepoCreated() throws IOException{
		return factory.getStatisticsDataService().getRepoCreated();
	}

	public Map<String, Integer> getLanguage() throws IOException{
		return factory.getStatisticsDataService().getLanguage();
	}
	
	public Map<String, Integer>  getUserCreated() throws IOException{
		return factory.getStatisticsDataService().getUserCreated();
	}
	
	public Map<String, Integer> getUserType() throws IOException{
		return factory.getStatisticsDataService().getUserType();
	}
	
	public Map<Integer, Integer> getUserHas(){
		return factory.getStatisticsDataService().getUserHas();
	}
	
	public Map<Integer, Integer> getUserRelated(){
		return factory.getStatisticsDataService().getUserRelated();
	}
}
