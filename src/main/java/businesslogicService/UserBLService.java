package businesslogicService;

import java.util.Iterator;

import Util.UserInfo;
import businesslogic.userBL.User;
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
    Iterator<UserVO> CheckUser(User user);


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
     */
    String UserInfo(User user, UserInfo info);

    /**
     * 查询单个项目的点赞者,一页50个
     *
     * @param user
     * @param userName
     * @param reponame String stargazers
     * @param pageNum
     * @return
     */
    Iterator<UserVO> getStargazers(User user, String userName, String reponame, int pageNum);

    /**
     * 查询单个项目的点赞者登录名,一页50个
     *
     * @param user
     * @param userName
     * @param reponame
     * @param pageNum
     * @return
     */

    Iterator<String> getStargazerNames(User user, String userName, String reponame, int pageNum);

    /**
     * 查询单个项目的订阅者,一页50个
     *
     * @param user
     * @param userName
     * @param reponame
     * @param pageNum
     * @return
     */
    Iterator<String> getSubscribers(User user, String userName, String reponame, int pageNum);

    /**
     * 查询单个项目的订阅者登录名,一页50个
     *
     * @param user
     * @param userName
     * @param reponame
     * @param pageNum
     * @return
     */
    Iterator<String> NamesOfSubscriber(User user, String userName, String reponame, int pageNum);

    /**
     * 按关键字搜索用户
     * @param name 关键字
     * @return
     */
    UserVO search(String name);

}
