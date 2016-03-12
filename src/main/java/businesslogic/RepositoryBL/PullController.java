package businesslogic.RepositoryBL;

import Util.PullInfo;
import businesslogicService.PullBLService;

import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/6 0006.
 */
public class PullController implements PullBLService{
    public Iterator<String> getPulls(String userName, String reponame) {
        return null;
    }

    public Iterator<Integer> getPullNum(String userName, String reponame) {
        return null;
    }

    public String PullInfo(String userName, String reponame, int num, PullInfo info) {
        return null;
    }

    public String getPull(String userName, String reponame, int numbers) {
        return null;
    }

    public String getPullInfo(String userName, String reponame, int number, PullInfo info) {
        return null;
    }
}
