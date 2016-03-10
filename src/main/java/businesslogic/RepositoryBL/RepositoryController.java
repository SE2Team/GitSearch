package businesslogic.RepositoryBL;

import Util.RepositoryInfo;
import businesslogicService.RepositoryBLService;
import vo.RepositoryVO;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class RepositoryController implements RepositoryBLService {
    Repository repository = new Repository();
    public Iterator<RepositoryVO> getRepositories() throws IOException {
        return repository.getRepositories();
    }

    public Iterator<String> getRepositoriesNames() {
        return repository.getRepositoriesNames();
    }

    public RepositoryVO checkRepository(String userName, String reponame) throws IOException {
        return repository.checkRepository(userName, reponame);
    }

    public Map<String, Integer> languagesOfRepository(String userName, String reponame) {
        return repository.languagesOfRepository(userName, reponame);
    }

    public String RepositoryInfo(String userName, String reponame, RepositoryInfo info) {
        return repository.RepositoryInfo(userName, reponame, info);
    }

    public RepositoryVO Search(String name) throws IOException {
        return repository.Search(name);
    }


}
