package dataService;

import data.*;

/**
 * Created by moeyui on 2016/3/5 0005.
 */
public interface DataFatoryService {
    RepositoryDataService getRepositoryDataService();

    UserDataService getUserDataService();
    
    StatisticsDataService getStatisticsDataService();
     
}
