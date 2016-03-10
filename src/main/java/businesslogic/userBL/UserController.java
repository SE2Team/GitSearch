package businesslogic.userBL;

import Util.UserInfo;
import businesslogicService.UserBLService;
import vo.UserVO;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class UserController implements UserBLService{
    User user=new User();
    public Iterator<UserVO> CheckUser(User user) throws IOException {
        return user.CheckUser(user);
    }

    public String UserInfo(User user, UserInfo info) {
        return user.UserInfo(user, info);
    }

    public Iterator<UserVO> getStargazers(String userName, String reponame) {
        return user.getStargazers(userName, reponame);
    }

    public Iterator<String> getStargazerNames(String userName, String reponame) throws IOException {
        return user.getStargazerNames(userName, reponame);
    }

    public Iterator<UserVO> getSubscribers(String userName, String reponame) {
        return user.getSubscribers(userName, reponame);
    }

    public Iterator<String> NamesOfSubscriber(String userName, String reponame) throws IOException {
        return user.NamesOfSubscriber(userName,reponame);
    }

}
