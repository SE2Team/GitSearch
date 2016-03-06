package businesslogic.RepositoryBL;

import Util.ForkInfo;
import businesslogicService.ForkBLService;
import vo.RepositoryVO;

import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/6 0006.
 */
public class ForkController implements ForkBLService{
    public Iterator<RepositoryVO> getForks(String userName, String reponame) {
        return null;
    }

    public Iterator<String> NamesOfForks(String userName, String reponame) {
        return null;
    }

    public RepositoryVO checkForks(String userName, String reponame) {
        return null;
    }

    public String ForkInfo(String userName, String reponame, ForkInfo info) {
        return null;
    }
}
