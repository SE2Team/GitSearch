package businesslogic.RepositoryBL;

import Util.IssueInfo;
import businesslogicService.IssuesBLService;

import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/6 0006.
 */
public class IssuesController implements IssuesBLService {
    public Iterator<String> getIssues(String userName, String reponame) {
        return null;
    }

    public Iterator<Integer> getIssueNum(String userName, String reponame) {
        return null;
    }

    public String getIssue(String userName, String reponame, int issueNum) {
        return null;
    }

    public String IssueInfo(String userName, String reponame, int num, IssueInfo info) {
        return null;
    }

    public String getIssueComment(String userName, String reponame, int num) {
        return null;
    }
}
