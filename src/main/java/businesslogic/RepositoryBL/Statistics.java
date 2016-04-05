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

public class Statistics {

	private DataFatoryService factory=new DataFactory();
	public StaStrVO getStar() throws IOException{
		return PO2VO.convert(factory.getStatisticsDataService().getStar());
	}
	public StatisticsVO getScores(RepositoryPO po) throws IOException {
		// TODO Auto-generated method stub
		return PO2VO.convert(factory.getStatisticsDataService().getScores(po));
	}
	
	public StaStrVO getForks() throws IOException{
		return PO2VO.convert(factory.getStatisticsDataService().getForks());
	}
	
	public StaStrVO getRepoCreated() throws IOException{
		return PO2VO.convert(factory.getStatisticsDataService().getRepoCreated());
	}

	public StaStrVO getLanguage() throws IOException{
		return PO2VO.convert(factory.getStatisticsDataService().getLanguage());
	}
	
	public StaStrVO  getUserCreated() throws IOException{
		return PO2VO.convert(factory.getStatisticsDataService().getUserCreated());
	}
	
	public StaStrVO getUserType() throws IOException{
		return PO2VO.convert(factory.getStatisticsDataService().getUserType());
	}
	
	public StaIntVO getUserHas(){
		return PO2VO.convert(factory.getStatisticsDataService().getUserHas());
	}
	
	public StaIntVO getUserRelated(){
		return PO2VO.convert(factory.getStatisticsDataService().getUserRelated());
	}
	public StaStrVO getCompany() throws IOException {
		return PO2VO.convert(factory.getStatisticsDataService().getCompany());
	}
	
	public Integer getHasNum(String name){
		return factory.getStatisticsDataService().getHasNum(name);
	}
}
