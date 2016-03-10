package businesslogic.userBL;

import Util.UserInfo;
import data.DataFactory;
import dataService.DataFatoryService;
import dataService.UserDataService;
import po.UserPO;
import vo.UserVO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class User {
    DataFatoryService factory=new DataFactory();
    UserDataService data=factory.getUserDataService();
    public Iterator<UserVO> CheckUser(User user) {
        ArrayList<UserVO> vos=new ArrayList<UserVO>();
        for (UserPO po:data.CheckUser(user)){
            
        }
        return data;
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
