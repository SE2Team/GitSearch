package data;


import dataService.DataFatoryService;
import dataService.RepositoryDataService;
import dataService.StatisticsDataService;
import dataService.UserDataService;


/**
 * Created by moeyui on 2016/3/5 0005.
 */
public class DataFactory implements DataFatoryService{
	public static JDBCHelper helper=null;
	public RepositoryDataService getRepositoryDataService() {
       RepositoryData repoData = null;
       if(repoData==null){
    	   repoData=new RepositoryData();
       }
		return repoData;
    }

    public UserDataService getUserDataService() {
        UserData userData=null;
        if(userData==null){
        	userData=new UserData();
        }		
    	
    	return userData;
    }
    

    public StatisticsDataService getStatisticsDataService(){
    	StatisticsData statisticsData=null;
    	if(statisticsData==null){
    		statisticsData=new StatisticsData();
    	}
    	return statisticsData;
    }
    

	
}
