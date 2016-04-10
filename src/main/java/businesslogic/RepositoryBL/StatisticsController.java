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
import vo.RepositoryVO;
import vo.StaIntVO;
import vo.StaStrVO;
import vo.StatisticsVO;

public class StatisticsController implements StatisticsBLService{
	Statistics statistics=new Statistics();
	public StaStrVO getStar() throws IOException{
		return statistics.getStar();
	}
	
	public StatisticsVO getScores(RepositoryVO vo) throws IOException{
		return statistics.getScores(vo);
	}
	
	public StaStrVO getForks() throws IOException{
		return statistics.getForks();
	}
	
	public StaStrVO getRepoCreated() throws IOException{
		return statistics.getRepoCreated();
	}

	public StaStrVO getLanguage() throws IOException{
		return statistics.getLanguage();
	}
	
	public StaStrVO getUserCreated() throws IOException{
		return statistics.getUserCreated();
	}
	
	public StaStrVO getUserType() throws IOException{
		return statistics.getUserType();
	}
	
	public StaIntVO getUserHas(){
		return statistics.getUserHas();
	}
	
	public StaIntVO getUserRelated(){
		return statistics.getUserRelated();
	}
	
	public StaStrVO getCompany() throws IOException{
		return statistics.getCompany();
	}
	
	public Integer getHasNum(String name){
		return statistics.getHasNum(name);
	}

	@Override
	public StaStrVO getCollaborator() {
		return statistics.getCollaborator();
	}

	@Override
	public StaStrVO getContributor() {
		// TODO Auto-generated method stub
		return statistics.getContributor();
	}
}
