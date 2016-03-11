package dataService;

import Util.*;
import po.RepositoryPO;
import vo.RepositoryVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public interface RepositoryDataService {
    ArrayList<RepositoryPO> getRepositories() throws IOException;

    ArrayList<String> getRepositoriesNames() throws IOException;

    RepositoryPO checkRepository(String userName, String reponame) throws IOException;

    Map<String, Integer> languagesOfRepository(String userName, String reponame);

    String RepositoryInfo(String userName, String reponame, RepositoryInfo info);

    ArrayList<RepositoryPO> Search(String name) throws IOException;

    ArrayList<RepositoryPO>  sort(Repository_Sort sort) throws IOException;
}
