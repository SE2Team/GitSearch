
package businesslogicService;

import Util.Repository_Sort;
import vo.RepositoryVO;
import vo.ScreenVO;
import vo.StaStrVO;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public interface RepositoryBLService {
    Iterator<RepositoryVO> getRepositories() throws IOException;

    Iterator<String> getRepositoriesNames();

    RepositoryVO checkRepository(String userName, String reponame) throws IOException;

    @Deprecated
    StaStrVO languagesOfRepository(String userName, String reponame) throws IOException;

    StaStrVO languagesOfRepository(RepositoryVO vo)throws IOException;

//    String RepositoryInfo(String userName, String reponame, RepositoryInfo info);

    Iterator<RepositoryVO> search(String name) throws IOException;


    Iterator<RepositoryVO> sort(Repository_Sort sort) throws IOException;

//    Iterator<RepositoryVO> screenLanguage(String language) throws IOException;
//    
//    Iterator<RepositoryVO> screenTime(String time) throws IOException;
//    
//    Iterator<RepositoryVO> screenCategory(String key) throws IOException;

    Iterator<RepositoryVO> screen(ScreenVO vo) throws IOException;

}
