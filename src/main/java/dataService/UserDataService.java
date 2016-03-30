package dataService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Util.UserInfo;
import Util.User_Sort;
import businesslogic.userBL.User;
import po.UserPO;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public interface UserDataService {
	
	 /**
     * 查询某个user的详细信息（这里的user是项目中contributor或collaborator的登录名）
     *
     * @param user
     * @return
	 * @throws IOException 
     */

	UserPO CheckUser(String user) throws IOException;

    /**
     * 查询某个user的某项信息（这里的user是项目中contributor或collaborator的登录名）
     *
     * @param user
     * @param info item可接受的参数有：
     *             id,login,type,name
     *             company,blog,location,email,bio
     *             public_repos,public_gists,followers,following
     *             created_at,updated_at
     * @return
     * @throws FileNotFoundException 
     * @throws IOException 
     */
    String UserInfo(String user, UserInfo info) throws FileNotFoundException, IOException;

    /**
     * 查询单个项目的点赞者,一页50个
     *
     * @param userName
     * @param reponame String stargazers
     * @return
     * @throws IOException 
     */
    ArrayList<String> getStargazers( String userName, String reponame) throws IOException;

    /**
     * 查询单个项目的点赞者登录名,一页50个
     *
     * @param userName
     * @param reponame
     * @return
     * @throws IOException 
     */

    ArrayList<String> getStargazerNames(String userName, String reponame) throws IOException;

    /**
     * 查询单个项目的订阅者,一页50个
     *
     * @param userName
     * @param reponame
     * @return
     */
    ArrayList<UserPO> getSubscribers( String userName, String reponame);

    /**
     * 查询单个项目的订阅者登录名,一页50个
     *
     * @param userName
     * @param reponame
     * @return
     * @throws IOException 
     */
    ArrayList<String> NamesOfSubscriber(String userName, String reponame) throws IOException;

    /**
     * 按关键字搜索用户
     * @param name 关键字
     * @return
     * @throws FileNotFoundException 
     * @throws IOException 
     */
    ArrayList<UserPO> search(String name) throws FileNotFoundException, IOException;
    
    ArrayList<UserPO> getUser() throws IOException;
    
    ArrayList<UserPO> sortUser(User_Sort sort) throws IOException;
    
    /**
     * 根据用户创建时间进行筛选
     * @param time
     * @return
     */
    ArrayList<UserPO> screenTime(String time);
}
