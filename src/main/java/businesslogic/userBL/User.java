package businesslogic.userBL;

import Util.UserInfo;
import Util.User_Sort;
import data.DataFactory;
import dataService.DataFatoryService;
import dataService.UserDataService;
import po.UserPO;
import vo.PO2VO;
import vo.UserVO;

import java.io.FileNotFoundException;
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

    /**
     * 鎸夊叧閿瓧鎼滅储鐢ㄦ埛
     *
     * @param name 鍏抽敭瀛�
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    Iterator<UserVO> search(String name) throws FileNotFoundException, IOException {
        ArrayList<UserPO> pos = data.search(name);
        ArrayList<UserVO> vos = new ArrayList<UserVO>();
        for (UserPO po : pos) {
            vos.add(PO2VO.convert(po));
        }
        return vos.iterator();
    }

    Iterator<UserVO> getUser() throws IOException {
        ArrayList<UserVO> vos = new ArrayList<UserVO>();
        for (UserPO po : data.getUser()) {
            vos.add(PO2VO.convert(po));
        }
        return vos.iterator();
    }
    
    public Iterator<UserVO> sortUser(User_Sort sort) throws IOException{
    	ArrayList<UserVO> vos=new ArrayList<UserVO>();
    	for(UserPO po:data.sortUser(sort)){
    		vos.add(PO2VO.convert(po));
    	}
    	return vos.iterator();
    }
}
