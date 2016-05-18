package businesslogic.userBL;

import Util.UserInfo;
import Util.User_Sort;
import businesslogicService.UserBLService;
import vo.UserVO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class UserController implements UserBLService{
    User user=new User();

    public UserVO CheckUser(String name) throws IOException {
        return user.checkUser(name);
    }

    public String UserInfo(String name, UserInfo info) throws IOException {
        return user.UserInfo(name, info);
    }

    public Iterator<String> getStargazers(String userName, String reponame) throws IOException {
        return user.getStargazers(userName, reponame);
    }

    public Iterator<String> getStargazerNames(String userName, String reponame) throws IOException {
        return user.getStargazerNames(userName, reponame);
    }

    public Iterator<UserVO> getSubscribers(String userName, String reponame) throws IOException {
        return user.getSubscribers(userName, reponame);
    }

    public Iterator<String> NamesOfSubscriber(String userName, String reponame) throws IOException {
        return user.NamesOfSubscriber(userName,reponame);
    }

    public Iterator<UserVO> search(String name) throws FileNotFoundException, IOException {
        return user.search(name);
    }

    public Iterator<UserVO> getUser() throws IOException {
        return user.getUser();
    }

    public Iterator<UserVO> sortUser(User_Sort sort) throws IOException{
    	return user.sortUser(sort);
    }

    public Iterator<UserVO> screenTime(String time) throws IOException{
    	return user.screenTime(time);
    }
}
