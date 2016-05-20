package businesslogic.RepositoryBL;

import Util.CommitInfo;
import businesslogicService.CommitBLService;
import vo.RepositoryVO;
import vo.StaStrVO;

import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/6 0006.
 */
public class CommitController implements CommitBLService {
    Commit commit=new Commit();
    public Iterator<String> getCommits(String userName, String reponame) {
        return null;
    }

    public Iterator<Integer> getCommitNum(String userName, String reponame) {
        return null;
    }

    public String getCommit(String userName, String reponame, int sha) {
        return null;
    }

    public String CommitInfo(String userName, String reponame, int sha, CommitInfo info) {
        return null;
    }

    public String getCommitComment(String userName, String reponame, int num) {
        return null;
    }

    @Override
    public StaStrVO commitstatistic(RepositoryVO vo) {
        return commit.commitstatistic(vo);
    }
}
