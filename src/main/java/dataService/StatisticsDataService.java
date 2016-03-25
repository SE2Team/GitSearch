package dataService;

import java.io.IOException;

import javafx.collections.ObservableList;
import po.RepositoryPO;
import po.StatisticsPO;

public interface StatisticsDataService {
	public ObservableList<StatisticsPO> getScore();
	
	public StatisticsPO getScores(RepositoryPO po) throws IOException;
}
