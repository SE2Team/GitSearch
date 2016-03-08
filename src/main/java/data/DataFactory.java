package data;

import dataService.DataFatoryService;
import dataService.RepositoryDataService;
import dataService.UserDataService;

/**
 * Created by moeyui on 2016/3/5 0005.
 */
public class DataFactory implements DataFatoryService{
    public RepositoryDataService getProgramDataService() {
        return new RepositoryData();
    }

    public UserDataService getUserDataService() {
        return new UserData();
    }
}
