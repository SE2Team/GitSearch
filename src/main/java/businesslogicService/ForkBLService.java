package businesslogicService;

import Util.ForkInfo;
import vo.RepositoryVO;

import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/6 0006.
 */
public interface ForkBLService {
    /**
     * 查询单个项目的所有fork项目
     *
     * @param userName 项目所有者登录名
     * @param reponame 项目名
     * @return
     */
    Iterator<RepositoryVO> getForks(String userName, String reponame);

    /**
     * 查询单个项目的所有fork项目的全称
     *
     * @param userName 项目所有者登录名
     * @param reponame 项目名
     * @return
     */
    Iterator<String> NamesOfForks(String userName, String reponame);

    /**
     * 查询某个fork项目的信息
     *
     * @param userName 项目所有者登录名
     * @param reponame 项目名
     * @return
     */
    RepositoryVO checkForks(String userName, String reponame);

    /**
     * 查询某个fork项目的某项信息
     *
     * @param userName
     * @param reponame
     * @param info     可接受的参数有：
     *                 owner_name:项目所有者登录名 owner_id:所有者的id owner_type:所有者的用户类型（分为User和Organization）
     *                 html_url:项目主页url description:项目描述 fork:是否是fork了他人项目所产生的项目
     *                 created_at:创建时间 updated_at:更新时间 pushed_at:最后一次push的时间
     *                 size:项目大小 stargazers_count:点赞人数 language:项目主语言 forks:被fork的次数open_issues:open的issue数
     *                 subscribers_count:关注者数量
     * @return
     */
    String ForkInfo(String userName, String reponame, ForkInfo info);
}
