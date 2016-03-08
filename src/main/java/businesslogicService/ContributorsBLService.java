package businesslogicService;

import vo.UserVO;

import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/6 0006.
 */
public interface ContributorsBLService {
    Iterator<UserVO> NamesOfContributors(String userName, String reponame);

    Iterator<String> getContributors(String userName, String reponame);
}
