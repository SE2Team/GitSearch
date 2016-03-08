package businesslogic.RepositoryBL;

import Util.BranchInfo;
import businesslogicService.BranchBLService;
import vo.RepositoryVO;

import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/6 0006.
 */
public class BranchController implements BranchBLService {
    public Iterator<RepositoryVO> getBranches(String userName, String reponame) {
        return null;
    }

    public Iterator<String> NamesOfBranches(String userName, String reponame) {
        return null;
    }

    public RepositoryVO checkBranch(String userName, String reponame) {
        return null;
    }

    public String BranchInfo(String userName, String reponame, BranchInfo info) {
        return null;
    }
}
