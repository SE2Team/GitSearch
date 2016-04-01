package businesslogic.RepositoryBL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import businesslogicService.StatisticsBLService;
import dataService.StatisticsDataService;
import po.RepositoryPO;
import po.StaStrPO;
import po.StatisticsPO;
import javafx.collections.ObservableList;
import vo.StaIntVO;
import vo.StaStrVO;
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
	public Iterator<StaStrVO> getStar() throws IOException{
		return statistics.getStar();
	}
	
	public StatisticsVO getScores(RepositoryPO po) throws IOException{
		return statistics.getScores(po);
	}
	
	public Iterator<StaStrVO> getForks() throws IOException{
		return statistics.getForks();
	}
	
	public Iterator<StaStrVO> getRepoCreated() throws IOException{
		return statistics.getRepoCreated();
	}

	public Iterator<StaStrVO> getLanguage() throws IOException{
		return statistics.getLanguage();
	}
	
	public Iterator<StaStrVO> getUserCreated() throws IOException{
		return statistics.getUserCreated();
	}
	
	public Iterator<StaStrVO> getUserType() throws IOException{
		return statistics.getUserType();
	}
	
	public Iterator<StaIntVO> getUserHas(){
		return statistics.getUserHas();
	}
	
	public Iterator<StaIntVO> getUserRelated(){
		return statistics.getUserRelated();
	}
	
	public Iterator<StaStrVO> getCompany() throws IOException{
		return statistics.getCompany();
	}
	
	public Integer getHasNum(String name){
		return statistics.getHasNum(name);
	}
}
