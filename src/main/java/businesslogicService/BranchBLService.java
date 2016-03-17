package businesslogicService;

import Util.BranchInfo;

import vo.RepositoryVO;

import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/6 0006.
 */
public interface BranchBLService {
    Iterator<RepositoryVO> getBranches(String userName, String reponame);

    Iterator<String> NamesOfBranches(String userName, String reponame);

    RepositoryVO checkBranch(String userName, String reponame);

    /**
     * 查询单个项目的某个版本的某项信息
     *
     * @param userName
     * @param reponame
     * @param info     可接受的参数有：commit 对应提交的sha值 name 版本号 fn 项目全称
     * @return
     */
    String BranchInfo(String userName, String reponame, BranchInfo info);
}
