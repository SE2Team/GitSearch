package businesslogicService;

import Util.*;
import vo.RepositoryVO;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public interface RepositoryBLService {
    Iterator<RepositoryVO> getRepositories() throws IOException;

    Iterator<String> getRepositoriesNames();

    RepositoryVO checkRepository(String userName, String reponame) throws IOException;

    Map<String, Integer> languagesOfRepository(String userName, String reponame);

    String RepositoryInfo(String userName, String reponame, RepositoryInfo info);

    RepositoryVO Search(String name) throws IOException;








}
