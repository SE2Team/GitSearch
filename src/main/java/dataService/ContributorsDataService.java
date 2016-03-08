package dataService;


import java.util.ArrayList;

import po.UserPO;

/**
 * Created by moeyui on 2016/3/6 0006.
 */
public interface ContributorsDataService {
    ArrayList<UserPO> NamesOfContributors(String userName, String reponame);

    ArrayList<String> getContributors(String userName, String reponame);
}
