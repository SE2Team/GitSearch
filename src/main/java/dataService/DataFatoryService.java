package dataService;

import data.*;

/**
 * Created by moeyui on 2016/3/5 0005.
 */
public interface DataFatoryService {
    RepositoryDataService getRepositoryDataService();

    UserDataService getUserDataService();
    public CollaboratorsDataService getCollaboratorsDataService();

    public CommitDataService getCommitDataService();
    public BranchDataService getBranchDataService ();

    public ContributorsDataService getContributorsDataService();

    public ForkDataService getForkDataService();

    public IssuesDataService getIssuesDataService();

    public PullDataService getPullDataService();
    
    public StatisticsDataService getStatisticsDataService();
}
