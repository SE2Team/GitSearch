package businesslogic.RepositoryBL;

import Util.RepositoryInfo;
import businesslogicService.RepositoryBLService;
import vo.RepositoryVO;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class RepositoryController implements RepositoryBLService {
    public Iterator<RepositoryVO> getRepositories() {
        return null;
    }

    public Iterator<String> getRepositoriesNames() {
        return null;
    }

    public RepositoryVO checkRepository(String userName, String reponame) {
        return null;
    }

    public Map<String, Integer> languagesOfRepository(String userName, String reponame) {
        return null;
    }

    public String RepositoryInfo(String userName, String reponame, RepositoryInfo info) {
        return null;
    }

    public RepositoryVO Search(String name) {
        return null;
    }


}
