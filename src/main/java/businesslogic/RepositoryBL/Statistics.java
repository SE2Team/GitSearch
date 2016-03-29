package businesslogic.RepositoryBL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import po.RepositoryPO;
import po.StaIntPO;
import po.StaStrPO;
import po.StatisticsPO;
import javafx.collections.ObservableList;
import vo.PO2VO;
import vo.StaIntVO;
import vo.StaStrVO;
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
	public Iterator<StaStrVO> getStar() throws IOException{
		ArrayList<StaStrVO> vos=new ArrayList<StaStrVO>();
		for(StaStrPO po:factory.getStatisticsDataService().getStar()){
			vos.add(PO2VO.convert(po));
		}
		return vos.iterator();
	}
	public StatisticsVO getScores(RepositoryPO po) throws IOException {
		// TODO Auto-generated method stub
		return PO2VO.convert(factory.getStatisticsDataService().getScores(po));
	}
	
	public Iterator<StaStrVO> getForks() throws IOException{
		ArrayList<StaStrVO> vos=new ArrayList<StaStrVO>();
		for(StaStrPO po:factory.getStatisticsDataService().getForks()){
			vos.add(PO2VO.convert(po));
		}
		return vos.iterator();
	}
	
	public Iterator<StaStrVO> getRepoCreated() throws IOException{
		ArrayList<StaStrVO> vos=new ArrayList<StaStrVO>();
		for(StaStrPO po:factory.getStatisticsDataService().getRepoCreated()){
			vos.add(PO2VO.convert(po));
		}
		return vos.iterator();
	}

	public Iterator<StaStrVO> getLanguage() throws IOException{
		ArrayList<StaStrVO> vos=new ArrayList<StaStrVO>();
		for(StaStrPO po:factory.getStatisticsDataService().getLanguage()){
			vos.add(PO2VO.convert(po));
		}
		return vos.iterator();
	}
	
	public Iterator<StaStrVO>  getUserCreated() throws IOException{
		ArrayList<StaStrVO> vos=new ArrayList<StaStrVO>();
		for(StaStrPO po:factory.getStatisticsDataService().getUserCreated()){
			vos.add(PO2VO.convert(po));
		}
		return vos.iterator();
	}
	
	public Iterator<StaStrVO> getUserType() throws IOException{
		ArrayList<StaStrVO> vos=new ArrayList<StaStrVO>();
		for(StaStrPO po:factory.getStatisticsDataService().getUserType()){
			vos.add(PO2VO.convert(po));
		}
		return vos.iterator();
	}
	
	public Iterator<StaIntVO> getUserHas(){
		ArrayList<StaIntVO> vos=new ArrayList<StaIntVO>();
		for(StaIntPO po:factory.getStatisticsDataService().getUserHas()){
			vos.add(PO2VO.convert(po));
		}
		return vos.iterator();
	}
	
	public Iterator<StaIntVO> getUserRelated(){
		ArrayList<StaIntVO> vos=new ArrayList<StaIntVO>();
		for(StaIntPO po:factory.getStatisticsDataService().getUserRelated()){
			vos.add(PO2VO.convert(po));
		}
		return vos.iterator();
	}
	public Iterator<StaStrVO> getCompany() throws IOException {
		ArrayList<StaStrVO> vos=new ArrayList<StaStrVO>();
		for(StaStrPO po:factory.getStatisticsDataService().getCompany()){
			vos.add(PO2VO.convert(po));
		}
		return vos.iterator();
	}
}
