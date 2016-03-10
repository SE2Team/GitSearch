package businesslogic.userBL;

import Util.UserInfo;
import data.DataFactory;
import dataService.DataFatoryService;
import dataService.UserDataService;
import po.UserPO;
import vo.PO2VO;
import vo.UserVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class User {
    DataFatoryService factory=new DataFactory();
    UserDataService data=factory.getUserDataService();

    public UserVO checkUser(String name) throws IOException {

        return PO2VO.convert(data.CheckUser(name));
    }

    public String UserInfo(String user, UserInfo info) throws IOException {
        return data.UserInfo(user, info);
    }

    public Iterator<String> getStargazers(String userName, String reponame) throws IOException {
        ArrayList<UserVO> vos=new ArrayList<UserVO>();

        return data.getStargazers(userName, reponame).iterator();
    }

    public Iterator<String> getStargazerNames(String userName, String reponame) throws IOException {
        return data.getStargazerNames(userName, reponame).iterator();
    }

    public Iterator<UserVO> getSubscribers(String userName, String reponame) {
        ArrayList<UserVO> vos=new ArrayList<UserVO>();
        for (UserPO po:data.getSubscribers(userName, reponame)){
            vos.add(PO2VO.convert(po));
        }
        return vos.iterator();
    }

    public Iterator<String> NamesOfSubscriber(String userName, String reponame) throws IOException {
        return data.NamesOfSubscriber(userName, reponame).iterator();
    }

}
