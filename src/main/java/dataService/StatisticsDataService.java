package dataService;

import javafx.collections.ObservableList;
import po.StatisticsPO;

public interface StatisticsDataService {
	public ObservableList<StatisticsPO> getScore();
}
