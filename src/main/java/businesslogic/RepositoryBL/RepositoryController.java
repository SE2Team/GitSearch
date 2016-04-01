package businesslogic.RepositoryBL;

import Util.RepositoryInfo;
import Util.Repository_Sort;
import businesslogicService.RepositoryBLService;
import po.StaStrPO;
import vo.RepositoryVO;
import vo.StaStrVO;

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

    public Iterator<StaStrVO> languagesOfRepository(String userName, String reponame) throws IOException {
        return repository.languagesOfRepository(userName, reponame);
    }

    public String RepositoryInfo(String userName, String reponame, RepositoryInfo info) {
        return repository.RepositoryInfo(userName, reponame, info);
    }

    public Iterator<RepositoryVO> Search(String name) throws IOException {
        return repository.Search(name);
    }

    public Iterator<RepositoryVO> sort(Repository_Sort sort) throws IOException {
        return repository.sort(sort);
    }
    
    public Iterator<RepositoryVO> screenLanguage(String language) throws IOException {
    	return repository.screenLanguage(language);
    }
    
    public Iterator<RepositoryVO> screenTime(String time){
    	return repository.screenTime(time);
    }

}
