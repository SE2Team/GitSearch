package dataService;

import Util.PullInfo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/6 0006.
 */
public interface PullDataService {
    /**
     * 查询单个项目的Pull Request内容,一页50个
     *
     * @param userName
     * @param reponame
     * @return
     */
    ArrayList<String> getPulls(String userName, String reponame);

    /**
     * 查询单个项目的Pull Request编号,一页50个
     *
     * @param userName
     * @param reponame
     * @return
     */
    ArrayList<Integer> getPullNum(String userName, String reponame);

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
    String PullInfo(String userName, String reponame, int num, PullInfo info);

    /**
     * 查询单个项目的某个Pull Request
     *
     * @param userName
     * @param reponame
     * @param numbers
     * @return
     */
    String getPull(String userName, String reponame, int numbers);

    /**
     * 查询某个Pull Request的某项信息
     * <p/>
     * item可接受的参数有：
     * <p/>
     * state,locked,title,body
     * <p/>
     * user,user_id,user_type
     * <p/>
     * created_at,updates_at,closed_at,merged_at
     *
     * @param userName
     * @param reponame
     * @param info
     * @return
     */
    String getPullInfo(String userName, String reponame, int number,PullInfo info );
}
