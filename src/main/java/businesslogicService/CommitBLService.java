package businesslogicService;

import Util.CommitInfo;

import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/6 0006.
 */
public interface CommitBLService {
    /**
     * 查询单个项目的Commits内容,一页50个
     *
     * @param userName
     * @param reponame
     * @return
     */
    Iterator<String> getCommits(String userName, String reponame);

    /**
     * 查询单个项目的commit编号,一页50个
     *
     * @param userName
     * @param reponame
     * @return
     */
    Iterator<Integer> getCommitNum(String userName, String reponame);

    /**
     * 查询单个项目的某个commit
     *
     * @param userName
     * @param reponame
     * @param sha      commit的sha值
     * @return
     */
    String getCommit(String userName, String reponame, int sha);


    /**
     * 查询某个commit的某项信息
     * item可接受的参数有：
     * committer,committer_email,Date,message
     * filenumber 更改文件数,additions 添加代码行数,deletions 删除代码行数,total 总共影响行数
     *
     * @param userName
     * @param reponame
     * @param sha
     * @return
     */
    String CommitInfo(String userName, String reponame, int sha, CommitInfo info);


    /**
     * 查询某个commit的评论
     *
     * @param userName
     * @param reponame
     * @param num
     * @return
     */
    String getCommitComment(String userName, String reponame, int num);
}
