package businesslogic.userBL;

import Util.UserInfo;
import businesslogicService.UserBLService;
import vo.UserVO;

import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class UserController implements UserBLService{
    public Iterator<String> CheckUser(User user) {
        return null;
    }

    public String UserInfo(User user, UserInfo info) {
        return null;
    }

    public Iterator<UserVO> getStargazers(User user, String userName, String reponame, int pageNum) {
        return null;
    }

    public Iterator<String> getStargazerNames(User user, String userName, String reponame, int pageNum) {
        return null;
    }

    public Iterator<String> getSubscribers(User user, String userName, String reponame, int pageNum) {
        return null;
    }

    public Iterator<String> NamesOfSubscriber(User user, String userName, String reponame, int pageNum) {
        return null;
    }

    public UserVO search(String name) {
        return null;
    }
}
