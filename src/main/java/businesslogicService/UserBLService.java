package businesslogicService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import Util.UserInfo;
import vo.UserVO;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public interface UserBLService {
    /**
     * 查询某个user的详细信息（这里的user是项目中contributor或collaborator的登录名）
     *
     * @param user
     * @return
     */
    UserVO CheckUser(String user) throws IOException;


    /**
     * 查询某个user的某项信息（这里的user是项目中contributor或collaborator的登录名）
     *
     * @param name
     * @param info item可接受的参数有：
     *             id,login,type,name
     *             company,blog,location,email,bio
     *             public_repos,public_gists,followers,following
     *             created_at,updated_at
     * @return
     */
    String UserInfo(String name, UserInfo info) throws IOException;

    /**
     * 查询单个项目的点赞者,一页50个
     *
     * @param userName
     * @param reponame String stargazers
     * @return
     */
    Iterator<String> getStargazers(String userName, String reponame) throws IOException;

    /**
     * 查询单个项目的点赞者登录名,一页50个
     *
     * @param userName
     * @param reponame
     * @return
     */

    Iterator<String> getStargazerNames(String userName, String reponame) throws IOException;

    /**
     * 查询单个项目的订阅者,一页50个
     *
     * @param userName
     * @param reponame
     * @return
     */
    Iterator<UserVO> getSubscribers(String userName, String reponame);

    /**
     * 查询单个项目的订阅者登录名,一页50个
     *
     * @param userName
     * @param reponame
     * @return
     */
    Iterator<String> NamesOfSubscriber(String userName, String reponame) throws IOException;

    /**
     * 按关键字搜索用户
     *
     * @param name 关键字
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    Iterator<UserVO> search(String name) throws FileNotFoundException, IOException;

    Iterator<UserVO> getUser() throws IOException;
}
