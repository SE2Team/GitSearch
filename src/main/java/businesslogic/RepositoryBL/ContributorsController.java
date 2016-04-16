package businesslogic.RepositoryBL;

import vo.UserVO;

import java.util.Iterator;

/**
 * @author
 * @version 1.0
 * @date 2016年3月24日
 * 上午10:21:06
 * @parameter
 * @return
 */
public class ContributorsController {
    Contributors contributors = new Contributors();

    public Iterator<UserVO> NamesOfContributors(String userName, String reponame) {
        return null;
    }

    public Iterator<String> getContributors(String userName, String reponame) {
        return contributors.getContributors(userName, reponame);
    }
}
