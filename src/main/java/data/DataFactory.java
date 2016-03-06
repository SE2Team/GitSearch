package data;

import dataService.DataFatoryService;
import dataService.ProgramDataService;
import dataService.UserDataService;

/**
 * Created by moeyui on 2016/3/5 0005.
 */
public class DataFactory implements DataFatoryService{
    public ProgramDataService getProgramDataService() {
        return new ProgramData();
    }

    public UserDataService getUserDataService() {
        return new UserData();
    }
}
