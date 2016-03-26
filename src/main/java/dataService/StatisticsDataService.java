package dataService;

import java.io.IOException;
import java.util.ArrayList;

import po.RepositoryPO;
import po.StatisticsPO;

public interface StatisticsDataService {
	
	/**
	 * 
	 * @return
	 * list中包含3个int值
	 * 分别表示star在0-1000
	 * 1001-2000
	 * over2000
	 * @throws IOException 
	 */
	public ArrayList<Integer> getStar() throws IOException;
	
	public StatisticsPO getScores(RepositoryPO po) throws IOException;
	
	/**
	 * 
	 * @return
	 * list中包含3个int值
	 * 分别表示fork在0-100
	 * 100-1000
	 * over1000
	 * @throws IOException 
	 */
	public ArrayList<Integer> getForks() throws IOException;
}
