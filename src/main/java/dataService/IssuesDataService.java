package dataService;

import Util.IssueInfo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/6 0006.
 */
public interface IssuesDataService {
    /**
     * 查询单个项目的Issues内容,一页50个
     *
     * @param userName
     * @param reponame
     * @return
     */
    ArrayList<String> getIssues(String userName, String reponame);

    /**
     * 查询单个项目的Issue编号,一页50个
     *
     * @param userName
     * @param reponame
     * @return
     */
    ArrayList<Integer> getIssueNum(String userName, String reponame);

    /**
     * 查询单个项目的某个issue
     *
     * @param userName
     * @param reponame
     * @param issueNum
     * @return
     */
    String getIssue(String userName, String reponame, int issueNum);

    /**
     * 查询某个Issue的某项信息
     * item可接受的参数有：
     * state,locked,title,body
     * user,user_id,user_type
     * created_at,updates_at,closed_at,merged_at
     * @param userName
     * @param reponame
     * @param num
     * @return
     */
    String IssueInfo(String userName, String reponame, int num, IssueInfo info);

    /**
     * 查询单个项目的某个issue的评论
     *
     * @param userName
     * @param reponame
     * @param num
     * @return
     */
    String getIssueComment(String userName, String reponame, int num);
}
