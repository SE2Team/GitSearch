package data;

import dataService.BranchDataService;
import dataService.CollaboratorsDataService;
import dataService.CommitDataService;
import dataService.ContributorsDataService;
import dataService.DataFatoryService;
import dataService.ForkDataService;
import dataService.IssuesDataService;
import dataService.PullDataService;
import dataService.RepositoryDataService;
import dataService.StatisticsDataService;
import dataService.UserDataService;


/**
 * Created by moeyui on 2016/3/5 0005.
 */
public class DataFactory implements DataFatoryService{
    public RepositoryDataService getRepositoryDataService() {
        return new RepositoryData();
    }

    public UserDataService getUserDataService() {
        return new UserData();
    }
    
    public BranchDataService getBranchDataService (){
    	return new BranchData() ;
    }
    
    public CollaboratorsDataService getCollaboratorsDataService(){
    	return new CollaboratorsData();
    }
    
    public CommitDataService getCommitDataService(){
    	return new CommitData();
    }
    
    public ContributorsDataService getContributorsDataService(){
    	return new ContributorsData();
    }
    
    public ForkDataService getForkDataService(){
    	return new ForkData();
    }
    
    public IssuesDataService getIssuesDataService(){
    	return new IssuesData();
    }
    
    public PullDataService getPullDataService(){
    	return new  PullData();
    }
    
    public StatisticsDataService getStatisticsDataService(){
    	return new StatisticsData();
    }
}
