package data;

import java.util.ArrayList;

import Util.BranchInfo;
import dataService.BranchDataService;
import dataService.CollaboratorsDataService;
import dataService.CommitDataService;
import dataService.ContributorsDataService;
import dataService.DataFatoryService;
import dataService.ForkDataService;
import dataService.IssuesDataService;
import dataService.PullDataService;
import dataService.RepositoryDataService;
import dataService.UserDataService;
import po.RepositoryPO;

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
    
}
