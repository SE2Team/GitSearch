package dataService;

import Util.*;
import po.RepositoryPO;
import po.StaStrPO;
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
    
    /**
     * 
     * @param userName
     * @param reponame
     * @return用<String,Integer>表示的<编程语言,语言使用量>的Map
     * @throws IOException
     */
    StaStrPO languagesOfRepository(String userName, String reponame) throws IOException;

    String RepositoryInfo(String userName, String reponame, RepositoryInfo info) throws IOException;

    ArrayList<RepositoryPO> Search(String name) throws IOException;

    ArrayList<RepositoryPO>  sort(Repository_Sort sort) throws IOException;
    
    ArrayList<RepositoryPO> screenLanguage(String language) throws IOException;
    
    /**
     * 根据项目创建时间进行筛选
     * @param time
     * @return
     * @throws IOException 
     */
    ArrayList<RepositoryPO> screenTime(String time) throws IOException;
    
    ArrayList<RepositoryPO> screenCategory(String key) throws IOException;
}
