package po;

import org.kohsuke.github.GHRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by moeyui on 2016/3/4 0004.
 */

/**
 * owner_name:项目所有者登录名/项目名 owner_id:所有者的id owner_type:所有者的用户类型（分为User和Organization）
 * <p>
 * html_url:项目主页url description:项目描述 fork:是否是fork了他人项目所产生的项目
 * <p>
 * created_at:创建时间 updated_at:更新时间 pushed_at:最后一次push的时间
 * <p>
 * size:项目大小 stargazers_count:点赞人数 language:项目主语言 forks:被fork的次数
 * open_issues:open的issue数 subscribers_count:关注者数量
 **/
public class RepositoryPO extends GHRepository {


    @Deprecated
    public RepositoryPO(String name, int id, String owner_type, String html_url, String description, Boolean fork,
                        Date created, Date updated, Date pushed, int size, int stargazers_count, String language, int forks,
                        int open_issues, int subscribers_count, int contributor, int collaborators_count,
                        ArrayList<String> collaborators, ArrayList<String> contributors) {

    }

    public int getSubscribers_count() {
        return getSubscribersCount();
    }

    public int getOpen_issues() {
        return getOpenIssueCount();
    }

    public int getStargazers() {
        return getWatchers();
    }



    public Date getPushed() {
        return getPushedAt();
    }

    public Date getUpdated() throws IOException {
        return getUpdatedAt();
    }

    public Date getCreated() throws IOException {
        return getCreatedAt();
    }



    public boolean getFork() {
        return isFork();
    }


    public String getOwner_type() {
        return "user";
    }

    public String getHtml_url() {
        return getHtmlUrl().toString();
    }





}
