package businesslogic.RepositoryBL;

import Util.Repository_Sort;
import businesslogicService.RepositoryBLService;
import vo.RepositoryVO;
import vo.ScreenVO;
import vo.StaStrVO;

import java.io.IOException;
import java.util.Iterator;

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

    public StaStrVO languagesOfRepository(String userName, String reponame) throws IOException {
        return repository.languagesOfRepository(userName, reponame);
    }

    @Override
    public StaStrVO languagesOfRepository(RepositoryVO vo) throws IOException {
        return repository.languagesOfRepository(vo);
    }

    public Iterator<RepositoryVO> search(String name) throws IOException {
        return repository.Search(name);
    }

    public Iterator<RepositoryVO> sort(Repository_Sort sort) throws IOException {
        return repository.sort(sort);
    }
    
//    public Iterator<RepositoryVO> screenLanguage(String language) throws IOException {
//    	return repository.screenLanguage(language);
//    }
//    
//    public Iterator<RepositoryVO> screenTime(String time) throws IOException{
//    	return repository.screenTime(time);
//    }
//    
//    public Iterator<RepositoryVO> screenCategory(String key) throws IOException{
//    	return repository.screenCategory(key);
//    }
    
    public Iterator<RepositoryVO> screen(ScreenVO vo)  throws IOException{
    	return repository.screen(vo);
    }



}
