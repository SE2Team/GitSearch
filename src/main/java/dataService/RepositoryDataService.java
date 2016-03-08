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
    ArrayList<RepositoryPO> getRepositories();

    ArrayList<String> getRepositoriesNames() throws IOException;

    RepositoryPO checkRepository(String userName, String reponame);

    Map<String, Integer> languagesOfRepository(String userName, String reponame);

    String RepositoryInfo(String userName, String reponame, RepositoryInfo info);

    RepositoryPO Search(String name);








}
