package businesslogicService;

import Util.*;
import vo.RepositoryVO;
import vo.UserVO;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public interface RepositoryBLService {
    Iterator<RepositoryVO> getRepositories();

    Iterator<String> getRepositoriesNames();

    RepositoryVO checkRepository(String userName, String reponame);

    Map<String, Integer> languagesOfRepository(String userName, String reponame);

    String RepositoryInfo(String userName, String reponame, RepositoryInfo info);

    RepositoryVO Search(String name);








}
