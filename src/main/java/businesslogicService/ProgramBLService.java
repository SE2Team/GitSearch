package businesslogicService;

import Util.BranchInfo;
import Util.ForkInfo;
import Util.ProgramInfo;
import Util.PullInfo;
import vo.ProgramVO;
import vo.UserVO;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public interface ProgramBLService {
    Iterator<ProgramVO> getPrograms();

    Iterator<String> getProgramsNames();

    ProgramVO checkProgram(String userName, String reponame);

    Map<String, Integer> languagesOfProgram(String userName, String reponame);

    String programInfo(String userName, String reponame, ProgramInfo info);

    Iterator<UserVO> NamesOfContributors(String userName, String reponame);

    Iterator<String> getContributors(String userName, String reponame);

    Iterator<ProgramVO> getBranches(String userName, String reponame);

    Iterator<String> NamesOfBranches(String userName, String reponame);

    ProgramVO checkBranch(String userName, String reponame);

    /**
     * 查询单个项目的某个版本的某项信息
     *
     * @param userName
     * @param reponame
     * @param info     可接受的参数有：commit 对应提交的sha值 name 版本号 fn 项目全称
     * @return
     */
    String BranchInfo(String userName, String reponame, BranchInfo info);

    /**
     * 查询单个项目的所有fork项目
     *
     * @param userName 项目所有者登录名
     * @param reponame 项目名
     * @return
     */
    Iterator<ProgramVO> getForks(String userName, String reponame);

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
    ProgramVO checkForks(String userName, String reponame);

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

    /**
     * 查询单个项目的Pull Request内容,一页50个
     *
     * @param userName
     * @param reponame
     * @return
     */
    Iterator<String> getPulls(String userName, String reponame);

    /**
     * 查询某个Pull Request的某项信息
     *
     * @param userName
     * @param reponame
     * @param num
     * @param info     可接受的参数有：
     *                 state,locked,title,body
     *                 user,user_id,user_type
     *                 created_at,updates_at,closed_at,merged_at
     * @return
     */
    String PullInfo(String userName, String reponame, String num, PullInfo info);


}
