package businesslogic.RepositoryBL;

import Util.CommitInfo;
import businesslogicService.CommitBLService;

import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/6 0006.
 */
public class CommitController implements CommitBLService {
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
}
